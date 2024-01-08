// 백준 10773번
// 제로
// 간단한 push, pop 문제
// 방법---------------
// 정수 k를 입력 받고
// for문을 사용해 k번 돌며 정수를 입력 받는다.
// 0이 아닌 정수를 입력 받으면 push
// 0을 입력 받으면 pop
// k줄의 입력이 끝나면 스택 안에 있는 정수들의 합을 출력

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class pr10773 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int k = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		for(int x=0; x<k; x++) {
			int input = Integer.parseInt(br.readLine());
			if(input != 0) {				// 0이 아니면
				stack.push(input);			// push()
			}
			else {							// 0이면
				stack.pop();				// pop()
			}
		}
		// 합 계산
		int sum = 0;
		while(!stack.isEmpty()) {
			sum += stack.pop();
		}
		// 출력
		System.out.print(sum);
	}
}