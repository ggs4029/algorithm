// 백준 11050번
// 이항 계수 1
// n개중에서 k를 순서 없이 뽑는 경우의 수 구하기
// 방법----------
// n과 k를 입력 받고
// n * (n-1) * (n-2) ... * (n-k)/ 1 * 2 * 3 ... * k를 곱해 출력

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr11050 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 입력
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		// 경우의 수 구하기
		int output = 1;
		for(int x=0; x<k; x++) {
			output *= (n-x);
			output /= (x+1);
		}
		// 출력
		System.out.print(output);
	}
}