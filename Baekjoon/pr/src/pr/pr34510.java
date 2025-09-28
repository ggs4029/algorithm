// 백준 2025 Centroid Cup B번
// 우유갑은 꼭지 머리 몸통 세부분으로 나누어져 잇음.
// 각 부분의 높이는 h1, h2, h3임.
// 꼭지 = 선분 = h1
// 머리 = 등변삼각형 = h2
// 몸통 직사각형 = h3
// 우유갑을 쌓아 n층 우유탑을 만들려고 함.
// 우유갑을 쌓는 방식은 문제 참조.
// n층 우유탑의 전체 높이를 구하는 문제.
// 방법---------------------
// 첫 줄에 h1, h2, h3를 한 줄에 입력 받음.
// 다음 줄에 n이 주어진다.
// 1층만 쌓는 경우 = h1 + h2 + h3
// 1층은 우유갑 하나 높이.
// 2층은 h3 *2 + h2
// 3층은 우유값 하나 + 2층 높이
// 즉 홀수층 = n-1층 높이 + 우유갑 하나 높이
// 짝수층 = 2층 높이 * n/2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr34510 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int h1 = Integer.parseInt(st.nextToken());
		int h2 = Integer.parseInt(st.nextToken());
		int h3 = Integer.parseInt(st.nextToken());
		long n = Long.parseLong(br.readLine());
		// 우유탑 높이 구하기
		long milk = h1 + h2 + h3;							// 우유갑 하나의 전체 높이
		long secondFloor = h3 * 2 + h2;						// 2층 높이
		// 출력
		if(n%2 == 1)
			System.out.print(secondFloor * (n / 2) + milk);
		else
			System.out.print(secondFloor * (n / 2));
	}
}