// 백준 24494번
// 주어진 3+3줄의 문자열에서 정답 문자열과 추측 문자열을 비교해서
// 각 칸이 초록색(정확한 위치 맞춤) 또는 노란색(올바른 품종이지만 잘못된 위치)에 해당하는지 계산하는 문제.
// 방법---------------------
// 6줄에 걸쳐 문자열을 입력 받음.
// boolean함수를 만들어 각 char마다 비교해 같은지 다른지 검사하며
// 초록색과 노란색의 개수를 구해 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr24494 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] q = new String[3];
		String[] a = new String[3];
		for(int i=0; i<3; i++)
			q[i] = br.readLine();
		for(int i=0; i<3; i++)
			a[i] = br.readLine();
		// 정답 그리드에 등장하는 문자 개수 세기
		int[] alphabet = new int[26];
		for(int i=0; i<3; i++) {
			for(char c : q[i].toCharArray())
				alphabet[c - 'A']++;
		}
		// 초록, 노란색 세기
		int green = 0;
		int yellow = 0;
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(q[i].charAt(j)==a[i].charAt(j)) {
					green++;
					alphabet[q[i].charAt(j) - 'A']--;
				}
			}
		}
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(alphabet[a[i].charAt(j)-'A']>0 && q[i].charAt(j)!=a[i].charAt(j)) {
					yellow++;
					alphabet[a[i].charAt(j) - 'A']--;
				}
			}
		}
		// 출력
		System.out.println(green);
		System.out.print(yellow);
	}
}