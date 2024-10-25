// 백준 23905번
// 정수로 구성된 배열에서 m-countdown이 몇개 있는지 구하기.
// m-countdown -> 정수 m,m−1,m−2,…,2,1이 그 순서대로 포함되어 있어야함.
// 방법---------------------
// 첫 줄에 테스트케이스의 개수 t를 입력 받음
// 각 테스트 케이스는 두 줄로 구성되어있음.
// 첫 줄에는 배열의 크기 n, k(k-countdown)
// 다음줄에는 n개의 정수가 주어짐.
// 이중 for문을 돌며 k-countdown인지 값을 대조해가며 k-countdown의 수를 세고
// 마지막에 한꺼번에 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr23905 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<t; i++) {
			// 입력
			String[] input = br.readLine().split(" ");
			int n = Integer.parseInt(input[0]);
			int k = Integer.parseInt(input[1]);
			String[] input2 = br.readLine().split(" ");
			int[] countdown = new int[n];
			for(int j=0; j<n; j++)
				countdown[j] = Integer.parseInt(input2[j]);
			// k-countdown의 수 구하기
			int output = 0;
			for(int j=0; j<n-k+1; j++) {
				boolean ifCount = true;								// k-countdown인지 판별
				for(int l=0; l<k; l++) {							// k번 돌며
					if(countdown[j+l]!=k-l) {						// -1씩 안줄어들면
						ifCount = false;							// k-countdown 아님
						break;
					}
				}
				if(ifCount)
					output++;
			}
			sb.append("Case #" + (i+1) + ": " + output).append("\n");
		}
		// 출력
		System.out.print(sb.toString());
	}
}