// 백준 2587번
// 다섯 개의 수를 입력 받고
// 평균과 중앙값을 구하는 문제
// 방법------------------
// 한 줄에 하나씩 수를 입력 받고
// for문을 이용해 평균을 구하고
// sort와 배열의 인덱스를 이용해 중앙값을 출력한다

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class pr2587 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input2 = new int[5];
		int sum = 0;
		for(int x=0; x<5; x++) {
			int input = Integer.parseInt(br.readLine()); // 입력
			input2[x] = input;
			sum += input2[x];
		}
		Arrays.sort(input2); // 정렬
		// 최종 출력
		System.out.println(sum/5);
		System.out.print(input2[2]);
	}
}