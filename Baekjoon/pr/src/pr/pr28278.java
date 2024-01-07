// 백준 28278번
// 스택 2
// 스택을 구현하고 문제대로 명령을 처리한다.
// 방법------------
// 명령의 수 n을 먼저 입력 받고
// n줄에 걸쳐 명령들을 입력 받는다
// 입력의 요구에 맞는 답을 출력한다.
// System.out.println() -> 시간초과
// StringBuilder 사용

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class pr28278 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		// 명령의 수 입력
		int n = Integer.parseInt(br.readLine());
		// 명령 수행
		Stack<Integer> stack = new Stack<Integer>();
		for(int x=0; x<n; x++) {
			st = new StringTokenizer(br.readLine());
			String input = st.nextToken();
			// 1번 명령 : push()
			if(input.equals("1")) {
				stack.push(Integer.parseInt(st.nextToken()));
			}
			// 2번 명령 : pop()
			else if(input.equals("2")) {
				if(stack.isEmpty()) {
					sb.append("-1").append("\n");
				}
				else {
					sb.append(stack.pop()).append("\n");
				}
			}
			// 3번 명령 : size()
			else if(input.equals("3")) {
				sb.append(stack.size()).append("\n");
			}
			// 4번 명령 : isEmpty()
			else if(input.equals("4")) {
				if(stack.isEmpty()) {
					sb.append("1").append("\n");
				}
				else {
					sb.append("0").append("\n");
				}
			}
			// 5번 명령 : lastElement()
			else if(input.equals("5")) {
				if(stack.isEmpty()) {
					sb.append("-1").append("\n");
				}
				else {
					sb.append(stack.lastElement()).append("\n");
				}
			}
		}
		// 출력
		System.out.print(sb.toString());
	}
}