// 백준 17387번
// 2차원 좌표 평면 위의 두 선분 l1, l2가 주어지면
// 두 선분이 교차하는지 구하는 문제.
// 한 선분의 끝 점이 다른 선분이나 끝 점 위에 있는 것도 교차하는 것으로 침.
// 방법---------------------
// 첫 줄에 l1의 양 끝 점 x1, y1 x2, y2가 한 줄에 주어짐.
// 다음 줄에 l2의 양 끝 점 x3, y3 x4, y4가 한 줄에 주어짐.
// 입력 받은 점들 포인트 클래스 구현해서 저장하고
// ccw 돌려서 선분 교차하는지 확인하고 출력.
// 끝 점끼리 만나는지 if문으로 검사.
// 오답노트1-----------------
// 선분 끝 점끼리 만나는지만 검사하고
// 어떤 선분의 끝 점이 다른 선분 위(끝 점이 아닌 곳)에 있는지는 검사 안했음.
// 즉 첫번째로, 선분끼리 교차하는지 검사하고
// 다음으로 네 점을 다 한 줄로 그을수 있는지 검사한 뒤에
// 그을수 있다면 점들끼리 크기비교 해가지고 겹치는 부분이 있나도 검사해야함.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr17387 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		Point p1 = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
		Point p2 = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
		st = new StringTokenizer(br.readLine());
		Point p3 = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
		Point p4 = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
		// 선분 교차하는지 확인
		long tmp1 = ccw(p1, p2, p3) * ccw(p1, p2, p4);
		long tmp2 = ccw(p3, p4, p1) * ccw(p3, p4, p2);
		if(tmp1<=0 && tmp2<=0) {											// 선분끼리 교차하면
			if(tmp1==0 && tmp2==0) {										// 네 점이 다 한줄로 그어짐
				if(Math.min(p1.x, p2.x)<=Math.max(p3.x, p4.x) &&			// 그럼 점끼리 크기 비교해서 겹치는 부분이 있으면
						Math.min(p3.x, p4.x)<=Math.max(p1.x, p2.x) &&
						Math.min(p1.y, p2.y)<=Math.max(p3.y, p4.y) &&
						Math.min(p3.y, p4.y)<=Math.max(p1.y, p2.y)) {
					sb.append(1);
				}
				else														// 점끼리 겹치는 부분이 없음
					sb.append(0);
			}
			else															// 선분끼리 교차하지만 한줄로 그어지진 않음
				sb.append(1);
		}
		else																// 선분끼리 교차 안하면
			sb.append(0);
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
}