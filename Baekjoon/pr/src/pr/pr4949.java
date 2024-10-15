// 백준 4949번
// 문제의 조건에 맞게 괄호들이 짝을 이루고 있는지
// 문자열이 주어지면 균형잡힌 문자열인지 아닌지 판단하는 문제
// 방법---------------------
// 온점 하나가 들어올때까지 무한루프를 돌며 입력을 받음.
// 자료구조 스택을 이용.
// 주의! - 문자열 검사하는 if문에서 s.empty() || s.peek()!='( or [' 의 위치를 조심해야함.
// 	      비어있는지 먼저 검사하게 해야함.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class pr4949 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		while(true) {
			String input = br.readLine();
			if(input.equals("."))
				break;
			// 균형잡힌 문자열 검사
			Stack<Character> s = new Stack<>();
			int tmp = 0;
			for(int i=0; i<input.length(); i++) {
				char c = input.charAt(i);
				if(c=='(' || c=='[') {							// 왼쪽 괄호면
					s.push(c);									// push
				}
				else if(c==')') {								// 오른쪽 괄호면
					if(s.empty() || s.peek()!='(') {			// 짝이 안맞으면
						s.clear();
						tmp++;
						break;
					}
					else										// 짝 맞으면
						s.pop();								// pop
				}
				else if(c==']') {
					if(s.empty() || s.peek()!='[') {			// 짝이 안맞으면
						s.clear();
						tmp++;
						break;
					}
					else										// 짝 맞으면
						s.pop();
				}
			}
			if(s.empty() && tmp==0)								// 문제 없으면
				System.out.println("yes");						// yes 출력
			else
				System.out.println("no");
			s.clear();
		}
	}
}