// 백준 30458번
// 입력 받은 문자열을 가운데 문자 왼쪽과 오른쪽 문자를 하나씩 교환해가는 행동을 0번 이상 수행해서
// 팰린드롬으로 만들 수 있으면 Yes 출력 불가능하면 No 출력하는 문제.
// 방법---------------------
// 첫 줄에 문자열의 길이 n을 입력 받음.
// 다음 줄에 문자열 s를 입력 받음.
// 가운데 알파벳 빼고 나머지 알파벳들이 나온 횟수를 다 세서 다 짝수인지 확인하고
// 짝수면 Yes 출력 홀수 섞여있으면 No 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr30458 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		// 알파벳 나온 횟수 세기
		int[] alphabet = new int[26];
		for(int i=0; i<n; i++)
			alphabet[s.charAt(i)-'a'] += 1;
		if(n%2==1)								// 홀수 길이면 가운데 문자 제외
			alphabet[s.charAt(n/2)-'a'] -= 1;
		// 출력
		for(int i=0; i<26; i++) {
			if (alphabet[i]%2==1) {
				System.out.print("No");
				return;
			}
		}
		System.out.print("Yes");
		br.close();
	}
}