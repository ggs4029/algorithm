// 백준 1145번
// 적어도 대부분의 배수
// 서로 다른 다섯 개의 자연수가 주어질 때
// 적어도 대부분의 배수(수 다섯개 중 적어도 세 개로 나누어 지는 가장 작은 자연수)
// 를 출력하는 프로그램
// 방법---------------------
// 자연수수 다섯개를 한 줄에 입력 받고
// 무한루프를 돌며 적어도 대부분의 배수를 찾고
// 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr1145 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 입력
		int[] input = new int[5];
		for(int x=0; x<5; x++) {
			input[x] = Integer.parseInt(st.nextToken());
		}
		// 적어도 대부분의 배수 구하기
		int sum = 0;										// sum>=3을 만족하면 적어도 대부분의 배수
		int output = 1;										// 출력할 답
		while(true) {
			for(int x=0; x<5; x++) {
				if(output%input[x]==0 && output>=input[x])	// 나눠지면
					sum++;
			}
			// sum>=3을 만족하면 적어도 대부분의 배수
			if(sum>=3)
				break;
			else
				sum = 0;
			output++;
		}
		// 출력
		System.out.print(output);
	}
}