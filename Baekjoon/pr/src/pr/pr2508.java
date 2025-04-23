// 백준 2508번
// 2차원 배열이 주어지면 거기서 사탕의 개수를 세서 출력하는 문제.
// 사탕은 >o< 이나
// v
// o
// ^  두가지 방법으로만 존재함.
// 방법---------------------
// 첫 줄에 테스트 케이스의 개수 t를 입력 받음.
// 각 테스트 케이스의 입력은 한 줄로 r과 c를 입력 받음.
// 순회하면서 사탕 모양 찾아 세기.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr2508 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			br.readLine();									// 각 테스트 케이스 빈 줄로 구분
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			char[][] num = new char[r][c];
			for(int j=0; j<r; j++) {
				String input = br.readLine();
				for(int k=0; k<c; k++)
					num[j][k] = input.charAt(k);
			}
			// 사탕 세기
			int output = 0;
			for(int j=0; j<r; j++) {
				for (int k = 2; k < c; k++) {
					if(num[j][k] != '<')
						continue;
					if(num[j][k-1]=='o' && num[j][k-2]=='>')
						output++;
				}
			}
			for(int j=2; j<r; j++) {
				for(int k=0; k<c; k++) {
					if(num[j][k]!='^')
						continue;
					if(num[j-1][k]=='o' && num[j-2][k]=='v')
						output++;
				}
			}
			sb.append(output).append('\n');
		}
		// 출력
		System.out.print(sb.toString().trim());
	}
}