// 백준 1010번
// 다리 놓기
// 강 서쪽에 n개의 사이트, 동쪽에 m개의 사이트가 있을 때
// n개의 사이트 만큼 다리를 지을 때 다리를 지을 수 있는 경우의 수를
// 구하는 문제(다리끼리 겹칠 수 x)
// 방법 ---------------------
// 첫 줄에 테스트 케이스의 개수 t를 입력 받고
// 그 다음 줄부터 n, m을 입력 받는다.
// 동쪽의 사이트들을 배열로 만들어 경우의 수를 구한다.
// m개의 수에서 순서를 고려하지 않고 뽑는 경우의 수이므로
// mCn의 경우의 수를 구해 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr1010 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			// 입력
			String[] input = br.readLine().split(" ");
			int n = Integer.parseInt(input[0]);
			int m = Integer.parseInt(input[1]);
			// 경우의 수 구하기
			long sum = 1;
			for(int x=1; x<=n; x++) { // mCn
				sum = sum * (m+1-x) / x;
			}
			// 최종 출력
			System.out.println(sum);
		}
	}
}