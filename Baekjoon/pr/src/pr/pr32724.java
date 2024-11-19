// 백준 32724번
// 학생들의 점수 차이를 점수가 더 높은 학생에서 점수가 더 낮은 학생의 점수를 빼서 계산하는데,
// 모든 학생 쌍을 고려하여, 모든 쌍의 점수 차이를 합산하고 그 합을 쌍의 개수로 나눌 것임.
// 대규모 데이터를 처리할 수 있을 만큼 효율적으로 코드를 짜야하는 문제.
// 방법---------------------
// 첫 줄에 학생 수 n이 입력으로 주어짐.
// 두번째 줄에 n명의 학생들의 점수가 주어짐.
// 정렬해서 낮은 값부터 시작.
// 누적합 이용해 점수 차이 계산하기.
// num[i] * i - sum = (num[i] - num[0]) + (num[i] - num[1]) + ... + (num[i] - num[i-1])
// 이므로 num[i]가 i번 나오고 - sum (1부터 i-1번째까지)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class pr32724 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		int[] num = new int[n];
		String[] input = br.readLine().split(" ");
		for(int i=0; i<n; i++)
			num[i] = Integer.parseInt(input[i]);
		// 정렬
		Arrays.sort(num);
		// 점수 차이 계산
		long output = 0;
		long sum = 0;
		for(int i = 0; i < n; i++) {
			output += num[i] * i - sum;  			// 점수 차이를 더해주고
			sum += num[i];  						// 누적합 구하기
		}
		// 출력
		System.out.print(output);
	}
}