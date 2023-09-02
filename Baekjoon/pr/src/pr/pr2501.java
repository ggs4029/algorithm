// 백준 2501번
// 약수 구하기
// 두 자연수 N, K가 주어지면
// N의 약수들 중 K번째로 작은 수를 출력한다.
// 방법----------------------
// 첫째 줄에 N과 K를 입력 받고
// N의 약수들을 구하는 동시에
// K번째로 작은 약수를 출력하고
// N의 약수가 K개보다 적으면 0을 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr2501 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		// 약수 구하기
		int count = 0;
		for(int x=1; x<=N; x++) {
			if(N%x==0) { // 나머지가 0이면 약수
				++count;
				if(count==K) // K번째로 작은 약수
					System.out.print(x);
			}
		}
		// N의 약수가 K개보다 적은 경우
		if(count<K)
			System.out.print(0);
	}
}