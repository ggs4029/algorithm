// 백준 8892번
// 입력 받은 문자열 중 두개를 합쳐 팰린드롬이면 출력하는 문제.
// 방법---------------------
// 첫 줄에 테스트 케이스의 개수 t를 입력 받고
// 다음줄부터 테스트 케이스마다 첫줄에는 단어의 수 k를 입력 받고,
// 다음 k줄에 걸쳐 단어들을 입력 받는다.
// 이중 for문을 돌며 합친 문자열을 팰린드롬인지 검사하고
// 팰린드롬이면 출력하고 이중for문을 다 돌았음에도 팰린드롬인 문자열이 하나도 없으면 0을 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr8892 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			// 입력
			int k = Integer.parseInt(br.readLine());
			String[] word = new String[k];
			for(int j=0; j<k; j++)
				word[j] = br.readLine();
			// 단어 두개 합쳐 팰린드롬 찾기
			StringBuilder sb = new StringBuilder();
			int tmp2 = 0;										// 팰린드롬 발견 여부
			for(int x=0; x<k; x++) {
				for(int y=0; y<k; y++) {
					if(x==y)									// 같은 단어 건너뛰기
						continue;
					else {
						String tmp = word[x]+word[y];
						if(palin(tmp, 0, tmp.length()-1)) {
							sb.append(tmp).append("\n");
							tmp2 = 1;
							break;
						}
					}
				}
				if(tmp2==1)
					break;
			}
			// 출력
			if(tmp2==0)
				System.out.println(tmp2);
			else
				System.out.print(sb.toString());
		}
	}
	// 팰린드롬 검사 함수
	public static boolean palin(String s, int l, int r) {
		while (l<r) {
			if (s.charAt(l)!=s.charAt(r))
				return false;
			l++;
			r--;
		}
		return true;
	}
}