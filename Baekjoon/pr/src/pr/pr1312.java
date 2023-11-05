// 백준 1312번
// a와 b를 나누었을때 소숫점 아래 n번째 자리수 구하기
// 방법----------------
// a와 b, n을 입력 받고
// for문 안에서 나머지를 구한뒤 10을 곱해가며 다음자리를 구한다.
// n번째 자리수 전에서 멈추고 출력할때는 나누기를 하여 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr1312 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input = br.readLine().split(" ");
		int a = Integer.parseInt(input[0]);
		int b = Integer.parseInt(input[1]);
		int n = Integer.parseInt(input[2]);
		// n번째 자리수 찾기
		int output = a%b;
		for(int x=0; x<n; x++) {
			output = output*10;
			if(x==n-1) // 마지막 자리수에서는 나누기
				output = output/b;
			else // 그 외에는 나머지를
				output = output %b;
		}
		// 출력
		System.out.print(output);
	}
}