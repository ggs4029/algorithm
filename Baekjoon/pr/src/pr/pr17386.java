// 백준 17386번
// 2차원 좌표 평면 위의 두 선분 l1, l2가 주어지면
// 두 선분이 교차하는지 구하는 문제.
// 방법---------------------
// 첫 줄에 l1의 양 끝 점 x1, y1 x2, y2가 한 줄에 주어짐.
// 다음 줄에 l2의 양 끝 점 x3, y3 x4, y4가 한 줄에 주어짐.
// 입력 받은 점들 포인트 클래스 구현해서 저장하고
// ccw 돌려서 선분 교차하는지 확인하고 출력.
// 오답노트1-----------------
// ccw끼리 곱하는 과정에서 수가 너~무 커지므로
// ccw메소드에서 리턴할 때 부호만 리턴하도록 변경.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr17386 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
		int output = 0;
		if(tmp1<0 && tmp2<0)
			output = 1;
		// 출력
		System.out.print(output);
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