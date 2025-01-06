// 백준 30021번
// 준원이는 정수 1~n을 가지고 있음.
// 준원이는 자신이 가지고 있는 정수를 하루에 하나씩 n일에 걸쳐서 현석이에게 선물해 주려고 함.
// 현석이는 소수를 싫어하기 때문에 지금까지 선물 받은 수의 합이 소수가 되는 날이 없도록 해야 한다.
// 준원이가 현석이를 만족시키며 선물하려면 어떤 순서로 선물해야하는지 출력하는 문제.
// 방법---------------------
// 첫 줄에 n이 주어짐.
// n==2인 경우만 따로 빼서 처리하고
// 나머지 경우에 예제 입력 참고해서 2 처리하고 나머지 i 붙여 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr30021 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		int n = Integer.parseInt(br.readLine());
		// 선물 가능한지
		if(n==2) {
			System.out.print("NO");
			return;
		}
		else {
			System.out.println("YES");
			// 선물 순서 정하기
			if(n==1)
				System.out.print(1);
			else {
				sb.append(1+" "+3+" "+2);
				for(int i=4; i<=n; i++)
					sb.append(" "+i);
			}
		}
		// 출력
		System.out.print(sb.toString());
	}
}