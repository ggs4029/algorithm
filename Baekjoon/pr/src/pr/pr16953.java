// 백준 16953번
// 정수 A를 B로 바꾸려고 한다. 가능한 연산은 다음과 같은 두 가지이다.
// 2를 곱한다.
// 1을 수의 가장 오른쪽에 추가한다.
// A를 B로 바꾸는데 필요한 연산의 최솟값 출력하기.
// 방법---------------------
// 첫 줄에 a, b가 주어짐.
// b를 2를 나누거나 맨 오른쪽 수가 1이면 지워가며 a로 만들어감.
// 연산 수를 구해 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr16953 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int output = 0;
		// 연산
		while(a!=b) {
			output++;
			if(a>b) {
				System.out.println(-1);
				return;
			}
			String tmp = b+"";
			if(b%2==0)											// 2로 나눠지면
				b /= 2;											// 나누기
			else if(tmp.charAt(tmp.length() - 1)=='1') {		// 막자리 1이면
				tmp = tmp.substring(0, tmp.length() - 1);		// 1지우기
				b = Integer.parseInt(tmp);
			}
			else {												// 둘다 안되면
				System.out.println(-1);							// 연산 불가
				return;
			}
		}
		// 출력
		System.out.println(output+1);							// 마지막 연산 +1 해주기
	}
}