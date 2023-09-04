// 백준 9063번
// N개의 점을 둘러싸는  최소 크기의 직사각형 넓이 구하기
// 방법------------------------------
// 첫째줄에 입력 받을 점의 개수를 입력 받고
// 그 다음줄부터 그 개수만큼의 줄을 이용해 점을 입력 받는다.
// x좌표를 비교해 제일 작은 x좌표와 제일 큰 x좌표를 구하고
// y좌표를 비교해 똑같이 구해 그 두 점으로 만들어지는 직사각형의 넓이를 출력

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class pr9063 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력 받기
		int n = Integer.parseInt(br.readLine());
		int[] x = new int[n];
		int[] y = new int[n];
		for (int a = 0; a < n; a++) {
			String[] input = br.readLine().split(" ");
			x[a] = Integer.parseInt(input[0]);
			y[a] = Integer.parseInt(input[1]);
		}
		// 최종 출력
		Arrays.sort(x);
		Arrays.sort(y);
		if (n == 1) {
			System.out.print(0);
		} else {
			System.out.print((x[n - 1] - x[0]) * (y[n - 1] - y[0]));
		}
	}
}
