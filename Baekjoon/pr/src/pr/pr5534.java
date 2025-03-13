// 백준 5534번
// 버려진 간판에서 글자 지워서 간판을 새로 만들건데
// 내가 만드려는 간판 이름과 버려진 간판들의 정보가 주어졌을 때
// 글자들을 지워서 새로 만들수있나 판별하는 문제.
// 글자들을 지우되, 지우고 남은 문자열이 내가 만들려는 이름이어야 하고, 남은 문자가 모두 일정한 간격으로 떨어져 있어야함.
// 방법---------------------
// 버려진 간판 수 n을 입력 받고
// 다음 줄에 내가 만들려는 간판 이름을 입력 받음.
// 그 다음 줄부터 n줄에 걸쳐 버려진 간판들의 이름들을 한 줄에 하나씩 입력 받음.
// 오래된 간판들 순회하면서 글자 간격 1부터 늘려가며
// 새간판 만들수있나 검사하고 통과하면 +1 해서 결과 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr5534 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		String input = br.readLine();
		int output = 0;
		String[] old = new String[n];
		for(int i=0; i<n; i++)
			old[i] = br.readLine();
		// 오래된 간판에서 글자 지우기
		for(String i : old) {
			boolean tmp = false;								// 간판 만들수 있는지
			int inputLen = input.length();
			int iLen = i.length();
			for(int j = 0; j<iLen; j++) {
				if(i.charAt(j) != input.charAt(0))
					continue;
				for(int k=1; j+(inputLen-1)*k<iLen; k++) {		// 글자 간격 늘려가면서
					int l;
					for(l=0; l<inputLen; l++) {
						if(i.charAt(j+l*k) != input.charAt(l))
							break;
					}
					if(l == inputLen) {
						tmp = true;
						break;
					}
				}
				if(tmp)											// 못만들면
					break;
			}
			if(tmp)
				output++;
		}
		// 출력
		System.out.print(output);
	}
}