// 백준 1439번
// 0과 1로만 이루어진 문자열 s가 주어지고, 이 문자열에 있는 모든 숫자를 전부 같게 만들려고 함.
// 내가 할 수 있는 행동이 s에서 연속된 하나 이상의 숫자를 잡고 모두 뒤집는 것일 때
// 내가 해야하는 행동의 최소 횟수를 구하는 문제.
// 방법---------------------
// 첫 줄에 문자열 s를 입력 받음.
// 연속하는 0과 1의 뭉탱이들의 개수를 구하고 둘이 비교해서 더 적은 수만큼 뒤집으면 됨.
// 구현해서 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr1439 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String s = br.readLine();
		// 뒤집기 최소 횟수 구하기
		int tmp0 = 0, tmp1 = 0;
		char pre = s.charAt(0);						// 이전 숫자
		for(int i=1; i<s.length(); i++){
			char tmp = s.charAt(i);					// 지금 숫자
			if(tmp != pre){							// 전이랑 다른 숫자면
				pre = tmp;
				if(tmp == '1')
					tmp0++;
				else
					tmp1++;
			}
		}
		if(pre == '0')
			tmp0++;
		else
			tmp1++;
		// 출력
		System.out.print(Math.min(tmp0, tmp1));
	}
}