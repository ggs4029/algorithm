// 백준 2822번
// 8개의 문제를 풀어 점수를 얻을 때, 참가자의 총 점수는 가장 높은 점수 5개 점수의 합임.
// 참가자의 8개 문제 점수가 주어졌을 때, 총 점수와 어떤 문제가 총 점수에 포함되는지 출력하는 문제.
// 방법---------------------
// 8줄에 걸쳐 각 문제에 대한 참가자의 점수가 주어짐.
// 2차원 배열로 만들어 문제 순서도 셈.
// 정렬해서 답 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class pr2822 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		int[][] num = new int[8][2];
		int[] num2 = new int[5];
		int sum = 0;
		for(int i=0; i<8; i++){
			num[i][0] = Integer.parseInt(br.readLine());
			num[i][1] = i + 1;
		}
		// 정렬
		Arrays.sort(num, (x, y) -> y[0] - x[0]);
		// 총 점수 구하기
		for(int i=0; i<5; i++){
			sum += num[i][0];
			num2[i] = num[i][1];
		}
		// 정렬
		Arrays.sort(num2);
		// 출력
		sb.append(sum).append("\n");
		for(int i=0; i<5; i++)
			sb.append(num2[i] + " ");
		System.out.print(sb.toString().trim());
	}
}