// 백준 1978번
// 소수 찾기
// 방법-------------
// 첫줄에 입력 받을 수의 개수 N을 입력 받고
// 둘째줄에 N개의 수를 입력 받음
// 주어진 수들을 중첩for문을 돌며 소수인지 체크
// 소수 = 약수가 1과 자기자신만

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr1978 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int N = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		// 소수인지 체크
		int output = 0;
		for(int x=0; x<N; x++) {
			int count = 0;
			for(int y=1; y<=Integer.parseInt(input[x]); y++) {
				if(Integer.parseInt(input[x])%y==0) { // 약수면
					count++;
				}
			}
			if(count==2) // 소수면
				output++;
		}
		// 최종 출력
		System.out.print(output);
	}
}