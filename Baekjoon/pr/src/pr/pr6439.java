// 백준 6439번
// 입력으로 선분과 직사각형이 주어지면 교차하는지 아닌지 구하는 문제.
// 선분과 직사각형이 교차하려면 적어도 한 점을 공유해야함.
// 직사각형의 넓이가 0일 수도 있음.
// 방법---------------------
// 첫 줄에 테스트 케이스의 개수 t가 주어짐.
// 각 테스트 케이스에 대한 입력은 한 줄이고
// 선분의 시작점 좌표, 선분의 끝점 좌표, 직사각형의 한 쪽 모서리 좌표, 직사각형의 반대쪽 모서리 좌표
// 이렇게 여덟개를 한 줄에 입력 받음.
// 입력 받은 점들 포인트 클래스로 저장하고
// 선분과 직사각형이 교차하는지 검사.
// 첫번째로 선분의 끝 점이 사각형 안에 있는지 검사하고
// 밖에 있다면 선분과 직사각형의 네 선분에 대해 선분 교차 판별 메소드 돌려서 검사하고 결과 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr6439 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			// 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 선분 시작점
			long x1 = Long.parseLong(st.nextToken());
			long y1 = Long.parseLong(st.nextToken());
			// 선분 끝점
			long x2 = Long.parseLong(st.nextToken());
			long y2 = Long.parseLong(st.nextToken());
			// 직사각형 모서리1, 2
			long x3 = Long.parseLong(st.nextToken());
			long y3 = Long.parseLong(st.nextToken());
			long x4 = Long.parseLong(st.nextToken());
			long y4 = Long.parseLong(st.nextToken());
			// 포인트 클래스로 선분이랑 직사각형 저장
			Point p1 = new Point(x1, y1);
			Point p2 = new Point(x2, y2);
			long minX = Math.min(x3, x4);
			long maxX = Math.max(x3, x4);
			long minY = Math.min(y3, y4);
			long maxY = Math.max(y3, y4);
			Point top_left = new Point(minX, maxY);
			Point top_right = new Point(maxX, maxY);
			Point bottom_left = new Point(minX, minY);
			Point bottom_right = new Point(maxX, minY);
			// 선분과 직사각형 교차 판별
			boolean tmp = false;
			if((x1>=minX && x1<=maxX && y1>=minY && y1<=maxY) ||			// 선분의 끝 점이 사각형 안에 있으면
					(x2>=minX && x2<=maxX && y2>=minY && y2<=maxY))
				tmp = true;
			if(!tmp) {
				if(crossing(p1, p2, top_left, top_right) || 				// 직사각형의 네 변과 교차하는지
						crossing(p1, p2, top_right, bottom_right) ||
						crossing(p1, p2, bottom_right, bottom_left) ||
						crossing(p1, p2, bottom_left, top_left))
					tmp = true;
			}
			if(tmp)
				sb.append("T").append("\n");
			else
				sb.append("F").append("\n");
		}
		// 출력
		System.out.print(sb.toString().trim());
	}

	// ccw 메소드
	public static long ccw(Point a, Point b, Point c) {
		// 반시계 방향 = 양수
		// 일직선 = 0
		// 시계 방향 = 음수
		long output = (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
		// 부호만 리턴
		if(output > 0)
			return 1;
		if(output < 0)
			return -1;
		return 0;
	}

	// Point 클래스
	public static class Point {
		long x, y;

		Point(long x, long y) {
			this.x = x;
			this.y = y;
		}
	}

	// 선분 교차 판별 메소드
	public static boolean crossing(Point p1, Point p2, Point p3, Point p4) {
		long tmp1 = ccw(p1, p2, p3) * ccw(p1, p2, p4);
		long tmp2 = ccw(p3, p4, p1) * ccw(p3, p4, p2);
		if(tmp1<=0 && tmp2<=0) {
			if(tmp1==0 && tmp2==0) {										// 네 점이 다 한줄에 있으면
				if(Math.min(p1.x, p2.x) <= Math.max(p3.x, p4.x) &&			// 점끼리 크기 비교해서 겹치는 부분 있는지
						Math.min(p3.x, p4.x) <= Math.max(p1.x, p2.x) &&
						Math.min(p1.y, p2.y) <= Math.max(p3.y, p4.y) &&
						Math.min(p3.y, p4.y) <= Math.max(p1.y, p2.y))
					return true;
				else
					return false;
			}
			return true;
		}
		return false;
	}
}