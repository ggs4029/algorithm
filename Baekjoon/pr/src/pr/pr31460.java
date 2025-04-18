// 백준 31460번
// n자리수가 주어지면
// 팰린드롬 + 11의 배수인 n자리수를 출력하는 문제.
// 방법---------------------
// 첫 줄에 테스트 케이스의 개수 t를 입력 받음.
// 각 테스트 케이스에 양의 정수 n을 입력 받음.
// 양끝만 1이고 나머지 2로 채워넣으면 11의 배수가 보장됨.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr31460 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			int n = Integer.parseInt(br.readLine().trim());
			if(n == 1)								// 길이 1이면
				sb.append("0");
			else {									// 2이상이면
				sb.append("1");						// 1로 시작해서
				for(int j=0; j<n-2; j++)			// 가운데 싹다
					sb.append("2");					// 2로 채우고
				sb.append("1");						// 마지막만 1
			}
			sb.append("\n");
		}
		// 출력
		System.out.print(sb.toString().trim());
	}
}