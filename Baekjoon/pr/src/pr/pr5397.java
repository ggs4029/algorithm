// 백준 7662번
// 키로거를 설치해서 비밀번호 창에 입력한 글자를 얻어냈음.
// 비밀번호 창에서 입력한 키가 주어졌을 때, 강산이의 비밀번호를 알아내는 프로그램을 작성.
// 키보드로 입력한 키는 알파벳 대문자, 소문자, 숫자, 백스페이스, 화살표.
// 방법---------------------
// 첫째 줄에 테스트 케이스의 개수 t가 주어짐.
// 각 테스트 케이스마다 한줄에 입력한 순서대로 길이가 l인 문자열이 주어짐.
// 스택 두개를 활용해 풀이.
// < 들어오면 전의 문자는 tmp스택으로 빼두고 pop
// > 들어오면 tmp에 빼둔 문자 다시 가져옴.
// - 들어오면 그냥 pop
// 스택 리버스로 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class pr5397 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb2 = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			StringBuilder sb = new StringBuilder();
			// 입력
			String input = br.readLine();
			// 비밀번호 찾기
			Stack<Character> s = new Stack<>();
			Stack<Character> tmp = new Stack<>();					// 임시 스택 tmp
			for(int j=0; j<input.length(); j++) {
				if(input.charAt(j)=='<') {							// < 들어오면 tmp로 빼둠
					if(!s.isEmpty())
						tmp.push(s.pop());
				}
				else if(input.charAt(j)=='>') {						// > 들어오면 tmp에 빼둔 문자 다시 가져옴
					if(!tmp.isEmpty())
						s.push(tmp.pop());
				}
				else if(input.charAt(j)=='-') {						// - 들어오면 pop
					if(!s.isEmpty())
						s.pop();
				}
				else												// 그냥 문자면 push
					s.push(input.charAt(j));
			}
			while(!tmp.isEmpty())
				s.push(tmp.pop());
			while(!s.isEmpty())
				sb.append(s.pop());
			sb2.append(sb.reverse()).append("\n");
		}
		// 출력
		System.out.print(sb2.toString());
	}
}