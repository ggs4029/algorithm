// 백준 28702번
// 입력 받은 정수를 문제에서 주어진 규칙에 따라 출력
// 3의 배수 or 5의 배수 (둘다거나 아니거나)
// 방법---------------------
// 입력 세번 받는데 세번 모두 문자열일수 없지 않나
// 걍 숫자 세서 적당히 i더해주고 적당히 3의 배수이거나 5의 배수인지 판별하고 맞게 출력

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr28702 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input = new String[3];
		for(int i=0; i<3; i++)
			input[i] = br.readLine();
		// 계산
		for(int i=0; i<3; i++) {
			if(input[i].equals("FizzBuzz") || input[i].equals("Fizz") || input[i].equals("Buzz")) {
				continue;
			}
			else {
				// 출력
				Long output = Long.parseLong(input[i])+3-i;
				if(output%5==0 && output%3==0)
					System.out.print("FizzBuzz");
				else if(output%5==0)
					System.out.print("Buzz");
				else if(output%3==0)
					System.out.print("Fizz");
				else
					System.out.print(output);
				return;
			}
		}
	}
}