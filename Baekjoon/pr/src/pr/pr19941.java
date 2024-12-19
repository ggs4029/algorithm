// 백준 19941번
// 식탁의 길이 N, 햄버거를 선택할 수 있는 거리 K, 사람과 햄버거의 위치가 주어졌을 때,
// 햄버거를 먹을 수 있는 사람의 최대 수를 구하는 프로그램을 작성하는 문제.
// 사람들은 자신의 위치에서 거리가 K 이하인 햄버거를 먹을 수 있다.
// 방법---------------------
// 첫 줄에 n과 k가 주어짐.
// 두번째 줄에 p와 h로 이루어진 길이 n의 문자열이 주어짐.
// 앞사람부터 먹을 수 있는 햄버거 중 맨 앞에 있는거 먼저 먹도록 그리디 하게 구현.
// for문으로 탐색 후 최대값을 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr19941 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		char[] table = br.readLine().toCharArray();
		// 먹을 수 있는 최대 수 구하기
		boolean[] eat = new boolean[n];
		int output = 0;
		for(int i=0; i<n; i++) {
			if(table[i]=='P') {											// 사람이면
				for(int j=-k; j<=k; j++) {								// 그 사람 주변 -k ~ k 반복
					// 인덱스 범위 초과
					if(i+j>=n)
						break;
					if(i+j<0)
						continue;
					// 범위 안이면
					if(table[i+j]=='H' && eat[i+j]==false) {			// 햄버거고 안먹었으면
						eat[i+j] = true;								// 먹고
						output++;										// +1
						break;
					}
				}
			}
		}
		// 출력
		System.out.print(output);
	}
}