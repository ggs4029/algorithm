// 백준 2566번
// 행렬이 주어지면
// 최댓값을 찾고 최댓값이 위치를 출력하는 문제
// 방법-----------------------------
// 9 * 9 행렬을 입력 받고
// 중첩 반복문을 통해 최댓값과 그 위치를 찾는다.
// 첫째 줄에 최댓값을 출력
// 둘째 줄에 그 위치를 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr2566 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] arr = new int[9][9];
		// 수 입력 받기
		for (int x = 0; x < 9; x++) {
			String[] input = br.readLine().split(" ");
			for (int y = 0; y < 9; y++) {
				arr[x][y] = Integer.parseInt(input[y]);
			}
		}
		// 최댓값 찾기 + 위치 저장
		int max = 0;
		int n = 0;
		int m = 0;
		for (int x = 0; x < 9; x++) {
			for (int y = 0; y < 9; y++) {
				if(arr[x][y]>max) {
					max = arr[x][y];
					n = x;
					m = y;
				}
			}
		}
		// 최종 출력
		n++;
		m++; // 배열은 0부터 index가 시작하지만 우리가 행열을 셀 때는 1부터 세기 때문
		System.out.println(max);
		System.out.print(n+" "+m);
	}
}