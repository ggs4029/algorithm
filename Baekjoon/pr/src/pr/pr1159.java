// 백준 1159번
// 농구 경기
// 첫 글자가 같은 선수 5명 선발하기
// 방법------------------------
// n을 첫줄에 입력 받고
// 그 다음줄부터 n줄에 걸쳐 선수 이름들을 입력 받는다.
// 입력 받은 이름들의 첫 글자만 배열에 따로 저장하고
// a~z가 나온 횟수를 세는 배열output에도 +1해서 기록한다.
// 다섯번 이상 나온 첫 글자들을 출력한다.
// 다섯번 이상 나온 글자들이 하나도 없으면 다른 문자열을 출력

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr1159 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		char[] arr = new char[n];
		int[] output = new int[26];			// a~z
		for(int x=0; x<n; x++) {
			String name = br.readLine();
			arr[x] = name.charAt(0);		// 첫 글자만 저장
			output[arr[x]-97]++;
		}
		// 출력
		int sum = 0;
		for(int x=0; x<26; x++) {
			if(output[x]>=5) {		// 다섯번 이상 나왔으면
				System.out.print((char)(x+97));
				sum++;
			}
		}
		if(sum==0)
			System.out.print("PREDAJA");
	}
}