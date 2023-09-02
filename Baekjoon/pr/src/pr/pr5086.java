// 백준 5086번
// 두 수가 주어지면
// 두 수의 관계가 약수인지 배수인지 구하는 문제
// 방법-----------------------------
// for문을 돌며 두 수를 계속 입력을 받고
// 두 수 중에서 더 큰 수로 작은 수를 나눠
// 배수인지 약수인지 판단 후 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr5086 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(true) {
			// 입력
			String[] input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			// 둘 다 0인 경우 break
			if(a==0 && b==0) {
				break;
			}
			// 출력
			else if(a>=b) { // a가 더 큰 수면
				if(a%b==0) {
					System.out.println("multiple");
				}
				else {
					System.out.println("neither");
				}

			}
			else { // b가 더 큰 수면
				if(b%a==0) {
					System.out.println("factor");
				}
				else {
					System.out.println("neither");
				}
			}
		}
	}
}