// 백준 11662번
// 민호랑 강호가 2차원 좌표 평면 위에 서있음.
// 민호는 점 a(ax, ay)에서 점 b(bx, by)로 걸어가고
// 강호는 점 c(cx, cy)에서 점 d(dx, dy)로 걸어가고 있음.
// 둘 다 동시에 출발하고 도착도 같이함 + 일정한 속도로 걸어감.
// 두 사람의 거리가 가장 가까울때 거리를 구하는 문제.
// 방법---------------------
// 첫 줄에 ax ay bx by cx cy dx dy가 한 줄에 주어짐.
// 시간 t에 대해서 삼분 탐색을 진행.
// 문제에서 주어진 오차 10^-6보다 작게 오차 나게 while문 돌리고 거리 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr11662 {
	public static double ax, ay, bx, by, cx, cy, dx, dy = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		ax = Double.parseDouble(st.nextToken());
		ay = Double.parseDouble(st.nextToken());
		bx = Double.parseDouble(st.nextToken());
		by = Double.parseDouble(st.nextToken());
		cx = Double.parseDouble(st.nextToken());
		cy = Double.parseDouble(st.nextToken());
		dx = Double.parseDouble(st.nextToken());
		dy = Double.parseDouble(st.nextToken());
		// 삼분 탐색
		double left = 0.0;												// 최소 t
		double right = 1.0;
		while(right-left > 1e-7) {
			double leftThird = left + (right - left) / 3;
			double rightThird = right - (right - left) / 3;
			if(distance(leftThird) < distance(rightThird))				// 왼쪽 지역이 거리가 더 작으면
				right = rightThird;										// 오른쪽 지역 버리기
			else														// 오른쪽 지역이 거리가 더작거나 같므면
				left = leftThird;										// 왼쪽 지역 버리기
		}
		// 출력
		System.out.print(distance(left));
	}

	// 민호와 강호 두 점 사이의 거리를 구하는 메소드
	public static double distance(double t) {
		double mx = ax + t * (bx - ax);
		double my = ay + t * (by - ay);
		double kx = cx + t * (dx - cx);
		double ky = cy + t * (dy - cy);
		return Math.sqrt(Math.pow(mx - kx, 2) + Math.pow(my - ky, 2));
	}
}