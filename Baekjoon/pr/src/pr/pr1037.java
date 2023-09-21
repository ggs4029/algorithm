// 백준 1037번
// 약수를 보고 정수 n 구하기
// 방법--------------------
// 첫째 줄의 n의 약수의 개수를 입력 받고
// 다음줄에 1과 n을 제외한 약수들을 입력 받는다.
// 1과 n을 제외한 제일 작은 약수와 제일 큰 약수를 곱한 것이 n이다.
// 입력 받은 약수들이 들어있는 배열을 정렬한 후 맨앞과 맨뒤를 곱하여 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class pr1037 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int num = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		int[] divisor = new int[num];
		for(int x=0; x<num; x++) {
			divisor[x] = Integer.parseInt(input[x]);
		}
		// 정렬
		Arrays.sort(divisor);
		// 최종 출력
		System.out.print(divisor[0]*divisor[divisor.length-1]);

	}
}