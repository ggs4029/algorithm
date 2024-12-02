// 백준 1541번
// 세준이가 양수와 +, -, 그리고 괄호를 가지고 식을 만들었음. 그리고 나서 괄호 모두 지움.
// 이제 세준이는 괄호를 적절히 쳐서 이 식의 값을 최소로 만들려고 함.
// 괄호를 적절히 쳐서 이 식의 값을 최소로 만드는 문제.
// 방법---------------------
// 첫째 줄에 식 주어짐.
// - 기준으로 문자열 나누고 나눈 문자열들 for문 돌리면서 덧셈있으면 자기들끼리 미리 다 더해줌.
// 그 다음 그 값을 output에서 빼줌.
// 결과값을 출력.
// 덧셈을 미리 다 하고 그 다음 뺄셈을 하는 것이 해결법.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr1541 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String input = br.readLine();
		// 최소값 구하기
		int output = 0;
		String[] tmp = input.split("-");							// - 기준으로 스플릿
		for(int i=0; i<tmp.length; i++) {
			int sum = 0;
			String[] tmp2 = tmp[i].split("\\+");						// + 기준으로 스플릿
			for(int j=0; j<tmp2.length; j++)
				sum += Integer.parseInt(tmp2[j]);
			if(i==0)
				output = sum;
			else
				output -= sum;
		}
		// 출력
		System.out.print(output);
	}
}