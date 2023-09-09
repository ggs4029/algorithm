// 백준 11650번
// 2차원 평면 위의 점 N개가 주어지면
// 좌표를 x좌표가 증가하는 순으로,
// x좌표가 같다면 y좌표가 증가하는 순으로 정렬하여 출력하는 문제
// 방법----------------------
// 첫째 줄에 점의 개수 n을 입력 받고
// 둘째 줄부터 n개의 줄에 걸쳐 좌표를 입력 받는다.
// 입력 받은 좌표는 2차원 배열에 넣는다.
// 람다식을 이용해 x좌표가 같으면 y좌표끼리 비교해 정렬하게 한다.
// 정렬 결과를 출력

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class pr11650 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];
		for (int x = 0; x < n; x++) {
			String[] input = br.readLine().split(" ");
			arr[x][0] = Integer.parseInt(input[0]); // x좌표
			arr[x][1] = Integer.parseInt(input[1]); // y좌표
		}
		// 정렬
		Arrays.sort(arr, (a,b) -> a[0]==b[0] ? a[1] - b[1] : a[0] - b[0]);
		// 최종 출력
		for (int x = 0; x < arr.length; x++) {
			System.out.println(arr[x][0] + " " + arr[x][1]);
		}
	}
}
