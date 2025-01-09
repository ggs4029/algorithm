// 백준 1064번
// 풀에 숨은 소를 찾는 것을 어려워하고 있음.
// 존에게 그 풀밭은 N개의 소괄호로 이루어진 문자열처럼 보였기 때문.
// 에를 들어 )((()())())
// 존은 소의 뒷다리가 (( 과 똑같이 생긴 것을 알고있음. 또한 베시의 앞다리는 )) 과 똑같이 생김.
// 베시의 위치는 뒷다리의 위치가 x이고 앞다리의 위치가 y라고 할때 x < y가 되는 쌍으로 표현될 수 있다.
// 베시가 서있는 위치가 될 수 있는 서로 다른 순서쌍들의 개수를 구하는 문제.
// 방법---------------------
// 첫 줄에 문자열이 주어짐.
// (( 찾고 그 뒤에 ))가 몇개 나오는지 구해서 더하기.
// 싹 탐색하고 결과 출력.
// 오답노트------------------
// (( 개수 * )) 개수 해버리면 오답.
// 뒷다리 뒤에 앞다리가 있으면 x

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr5874 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String input = br.readLine();
		// 경우의 수 구하기
		long tmp = 0, tmp2 = 0;
		for(int i=0; i<input.length()-1; i++) {
			if(input.charAt(i)=='(') {				// (( 먼저 찾고
				if(input.charAt(i+1)=='(')
					tmp++;
			}
			else {									// 그 뒤애서 )) 찾기
				if(input.charAt(i+1)==')')
					tmp2 += tmp;
			}
		}
		// 출력
		System.out.print(tmp2);
	}
}