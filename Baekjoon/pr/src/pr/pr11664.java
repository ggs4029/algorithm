// 백준 11664번
// 3차원 좌표 평면 위에 선분 하나랑 점 하나 있음.
// 선분의 양 끝 점은 a(ax, ay, az), 점 b(bx, by, bz)고
// 점의 좌표는 c(cx, cy, cz)이다.
// 선분과 점 사이의 거리의 최솟값을 구하는 문제.
// 방법---------------------
// 첫 줄에 ax ay az bx by bz cx cy cz가 한 줄에 주어짐.
// 선분 위의 한 점 ab에 대해서 삼분 탐색 진행.
// 문제에서 주어진 오차 10^-6보다 작게 오차 나게 while문 돌리고 거리 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr11664 {
	public static double ax, ay, az, bx, by, bz, cx, cy, cz = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		ax = Double.parseDouble(st.nextToken());
		ay = Double.parseDouble(st.nextToken());
		az = Double.parseDouble(st.nextToken());
		bx = Double.parseDouble(st.nextToken());
		by = Double.parseDouble(st.nextToken());
		bz = Double.parseDouble(st.nextToken());
		cx = Double.parseDouble(st.nextToken());
		cy = Double.parseDouble(st.nextToken());
		cz = Double.parseDouble(st.nextToken());
		// 삼분 탐색
		double left = 0.0;												// ab의 최소 범위
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

	// 선분 위의 점과 선분 밖의 점 사이의 거리를 구하는 메소드
	public static double distance(double t) {
		double abx = ax + t * (bx - ax);
		double aby = ay + t * (by - ay);
		double abz = az + t * (bz - az);
		return Math.sqrt(Math.pow(abx - cx, 2) + Math.pow(aby - cy, 2) + Math.pow(abz - cz, 2));
	}
}