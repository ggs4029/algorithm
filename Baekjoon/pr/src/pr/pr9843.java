// 백준 9843번
// 롬복가상머신 구현하려한데요.
// 스택을 이용해 문제에서 요구하는 동작들을 작동하게 하고 적절히 출력해야하는 문제.
// 방법---------------------
// 첫 줄에 명령어의 개수 n을 입력 받음.
// 다음 n줄에 걸쳐 명령어들이 주어짐.
// 스택 사용해 명령어 처리하고 DONE값 출력

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class pr9843 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		String[][] input = new String[n][];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int tmp = st.countTokens();
			input[i] = new String[tmp];
			for(int j=0; j<tmp; j++)
				input[i][j] = st.nextToken();
		}
		// 명령어 실행하기
		Stack<Integer> s = new Stack<>();
		int register = 0;
		int sum = 0;
		while(sum < n) {
			String[] tmp = input[sum];
			if(tmp[0].equals("PUSH")) {					// 정수 x push
				int x = Integer.parseInt(tmp[1]);
				s.push(x);
				sum++;
			}
			else if(tmp[0].equals("STORE")) {			// 스택의 맨위값 pop하고 레지스터에 저장
				register = s.pop();
				sum++;
			}
			else if(tmp[0].equals("LOAD")) {			// 레지스터 값 스택에 push
				s.push(register);
				sum++;
			}
			else if(tmp[0].equals("PLUS")) {			// 스택 맨위값 두개 pop하고 더한 뒤 다시 push
				int a = s.pop();
				int b = s.pop();
				s.push(a+b);
				sum++;
			}
			else if(tmp[0].equals("TIMES")) {			// 스택에서 맨위값 pop하고 곱한 후 다시 push
				int a = s.pop();
				int b = s.pop();
				s.push(a * b);
				sum++;
			}
			else if(tmp[0].equals("IFZERO")) {			// 스택 맨위값 pop한게 0이면 명령어 주소 n2으로 점프
				int n2 = Integer.parseInt(tmp[1]);
				int top = s.pop();
				if(top == 0)
					sum = n2;
				else
					sum++;
			}
			else if(tmp[0].equals("DONE")) {			// 스택 매뉘이값 출력하고 종료
				System.out.print(s.peek());
				break;
			}
			else
				sum++;
		}
	}
}