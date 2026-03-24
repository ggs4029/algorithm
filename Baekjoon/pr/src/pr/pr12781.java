// 백준 12781번
// 친구 세명과 피자를 나눠먹기로 했음.
// 피자의 모양은 항상 볼록 다각형이고 이걸 다음과 같은 방법으로 자를거임.
// 한 명씩 피자의 가장자리의 한 점을 선택하고 선택한 순서대로 첫 번째 점과 두 번째 점을 이어 선분을 만듬.
// 그 다음 세 번째 점과 네 번째 점을 이은 선분도 만듬.
// 만들어진 두 선분을 따라 피자를 자를 때 피자가 네 조각으로 잘라지지 않으면 친구들은 싸울거임.
// 점 네개가 주어지면 친구들이 싸울지 안싸울지 구하는 문제.
// 방법---------------------
// 첫 줄에 친구들이 선택한 점 네개의 좌표들이 한 줄에 주어짐.
// 입력 받은 점들 포인트 클래스로 저장하고
// ccw 돌려서 선분 교차 판정하고 교차하면 1 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr12781 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		Point p1 = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
		Point p2 = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
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