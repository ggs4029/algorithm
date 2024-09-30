// 백준 2609번
// 자연수 두 개 입력 받아 최대공약수랑 최소공배수 출력
// 방법---------------------
// 첫 줄에 두개의 자연수를 입력 받고
// 출력 첫줄에 최대공약수, 다음 줄에 최소공배수를 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class pr2609 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] input = new int[2];
		input[0] = Integer.parseInt(st.nextToken());
		input[1] = Integer.parseInt(st.nextToken());
		// 최대공약수 + 출력
		Arrays.sort(input);
		int x = 1;
		for(int i=1; i<=input[0]; i++) {
			if(input[0]%i==0 && input[1]%i==0)
				x = i;
		}
		System.out.println(x);
		// 최소공배수 + 출력
		System.out.print(x * (input[0]/x) * (input[1]/x));
	}
}