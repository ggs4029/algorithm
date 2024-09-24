// 백준 20114번
// 물에 번진 문자열의 원래 문자를 구하는 문제
// 방법---------------------
// 첫째 줄에 원래 문자열의 길이 n, 세로로 번진 글자의 개수 h, 가로로 번진 글자의 개수 w를 받음.
// 둘째 줄부터 h줄에 걸쳐 n*w길이의 문자열을 받음.
// 원래 문자열을 초기에 ?로 다 채워넣고
// for문을 통해 받은 번진 문자열에서 ?면 그대로 놔두고
// 문자면 원래 문자열에 그 번진 문자의 인덱스를 w로 나눈 인덱스에 그 문자를 저장

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr20114 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 입력
		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		char[] note = new char[n];
		for(int i=0; i<n; i++)
			note[i] = '?';
		for(int i=0; i<h; i++) {
			String s = br.readLine();
			for(int j=0; j<n*w; j++) {
				// ?면 넘어가고 문자면 w로 나눈 인덱스에 문자 저장
				if(s.charAt(j)=='?')
					continue;
				else
					note[j/w] = s.charAt(j);
			}
		}
		// 출력
		for(int i=0; i<n; i++)
			System.out.print(note[i]);
	}
}