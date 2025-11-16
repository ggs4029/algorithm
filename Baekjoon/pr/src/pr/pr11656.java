// 백준 11656번
// 문자열 s가 주어지면, 모든 접미사를 사전순으로 정렬한 다음 출력하는 문제.
// 방법---------------------
// 첫 줄에 문자열 s를 입력 받음.
// 입력 받은 문자열의 접미사들을 모두 배열에 넣고
// 정렬한 다음 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class pr11656 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		String s = br.readLine();
		String[] arr = new String[s.length()];
		for(int i=0; i<s.length(); i++)
			arr[i] = s.substring(i, s.length());
		// 접미사 정렬
		Arrays.sort(arr);
		// 출력
		for(String i : arr)
			sb.append(i).append("\n");
		System.out.print(sb.toString().trim());
	}
}