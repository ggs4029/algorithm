// 백준 5525번
// 입력 받은 문자열(I와 O로만 이루어져있음)에서 Pn이 몇 군데 포함되어있는지 출력하는 문제.
// P1 = IOI, P2 = IOIOI 이런식...
// 방법---------------------
// 첫 줄에 n을 입력 받음.
// 둘째 줄에 문자열의 길이 m이 주어지고 셋째 줄에 문자열 s가 주어짐.
// for문 안에서 i를 기준으로 앞, 뒤 즉 3구간을 검사해 I O I인지 검사하고 n번 OI가 반복될 때 까지 검사.
// tmp = n을 만족하면 출력값에 +1하고 tmp 값을 -1 함.
// tmp 값을 0으로 초기화가 아닌 -1 하는 이유는 중복 문자열 세기 위함.
// 결과값을 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr5525 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		String s = br.readLine();
		// Pn 세기
		int sum = 0;
		int tmp = 0;
		for(int i=1; i<s.length()-1; i++) {
			if(s.charAt(i-1)=='I' && s.charAt(i)=='O' && s.charAt(i+1)=='I') {
				tmp++;
				if(tmp==n) {
					tmp--;
					sum++;
				}
				i++;						// if문에서 i랑 i+1번째 두개를 검사했으므로 i+2로 넘겨야함
			}
			else							// IOI 끊긴 경우
				tmp = 0;					// tmp 초기화
		}
		// 출력
		System.out.print(sum);
	}
}