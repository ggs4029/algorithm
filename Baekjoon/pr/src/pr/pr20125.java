// 백준 20125번
// 쿠키의 신체가 주어졌을 때 심장의 위치와 팔, 다리, 허리의 길이를 구하는 문제.
// 방법---------------------
// 첫 줄에 n이 입력으로 주어짐.
// 다음 줄부터 n줄에 걸쳐 쿠키의 신체가 주어짐.
// 쿠키 하나하나 순회하며 머리 위치부터 찾고
// 심장 위치 구해서 팔 길이 구하고 심장 위치를 기준으로 허리와 다리 길이를 구하고 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr20125 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		char[][] cookie = new char[n][n];
		for(int i=0; i<n; i++) {
			String input = br.readLine();
			for(int j=0; j<n; j++)
				cookie[i][j] = input.charAt(j);
		}
		// 신체 길이 구하기
		// 머리 위치 찾기
		boolean b = false;
		int tmp = 0;
		int tmp2 = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(cookie[i][j]=='*') {
					b = true;
					tmp = i+1;
					tmp2 = j;
					break;
				}
			}
			if(b==true)
				break;
		}
		// 팔 길이 구하기
		int left_arm = 0;
		int right_arm = 0;
		for(int i=0; i<n; i++) {
			if(cookie[tmp][i]=='*' && i<tmp2)
				left_arm++;
			if(cookie[tmp][i]=='*' && i>tmp2)
				right_arm++;
		}
		// 허리 길이 구하기
		int waist = 0;
		int tmp3 = tmp;
		while(true) {
			tmp3++;
			if(cookie[tmp3][tmp2]=='*')
				waist++;
			else
				break;
		}
		// 다리 길이 구하기
		int left_leg = 0;
		int right_leg = 0;
		while(true) {
			if(cookie[tmp3][tmp2-1]=='*') {
				left_leg++;
			}
			if(cookie[tmp3][tmp2+1]=='*') {
				right_leg++;
			}
			tmp3++;
			if(tmp3==n)
				break;
		}
		// 출력
		System.out.println((tmp+1) + " " + (tmp2+1));
		System.out.print(left_arm + " " + right_arm + " " + waist + " " + left_leg + " " + right_leg);
	}
}