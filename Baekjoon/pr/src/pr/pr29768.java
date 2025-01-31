// 백준 29769번
// 축제의 이름의 길이는 n이고 이름은 서로 다른 영어 알파벳 소문자 k가지로 이루어져 있어야 한다.
// 축제 이름의 조건을 만족하면서 서로 다른 부분 문자열 중 팰린드롬의 개수가 가장 많은 문자열을 축제의 이름으로 정한다.
// 축제의 이름으로 정할 수 있는 이름이 여러 개라면, 사전순으로 가장 앞선 이름으로 만들 때, 이를 출력하는 문제.
// 방법---------------------
// 첫 줄에 이름의 길이 n과 알파벳 소문자의 개수 k를 입력 받음.
// n과 k중 더 작은 값만큼 a를 추가해주고
// 나머지 필요한만큼 알파벳 abcd ... 에서 떼다가 붙여서 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr29768 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		// 이름 만들기
		int tmp = Math.min(n, k);
		for(int i=0; i<n-tmp; i++)
			sb.append('a');										// a로 채우기 (사전순 + 제일 많은 팰린드롬)
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		sb.append(alphabet.substring(0, tmp));
		// 출력
		System.out.print(sb.toString().trim());
	}
}