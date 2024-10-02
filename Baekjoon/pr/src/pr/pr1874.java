// 백준 1874번
// 1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써, 하나의 수열을 만들 수 있고
// 이때, 스택에 push하는 순서는 반드시 오름차순을 지키도록 한다고 한다.
// 스택을 이용해 주어진 수열을 만들 수 있는지 만들 수 있다면 연산 순서를 출력하고
// 불가능하면 NO를 출력하는 문제
// 방법---------------------
// 첫 줄에 n을 입력 받고 다음 줄부터 n줄에 걸쳐 수열을 이루는 정수들을 입력 받음
// for문 안에서 스택 계산하며 결과를 출력
// 주의! - 스택의 제일 위가 input[i]보다 크면 수열을 만들 수 없음을 주의해야함.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class pr1874 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		int[] input = new int[n];
		for(int i=0; i<n; i++)
			input[i] = Integer.parseInt(br.readLine());
		// 스택 계산
		Stack<Integer> s = new Stack<>();
		int num = 1;							// 1부터 스택에 들어감
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			while(num <= input[i]) {			// 스택의 제일 위가 input[i]보다 작으면
				s.push(num);					// push
				num++;
				sb.append("+\n");
			}
			if(s.peek() == input[i]) {			// 스택의 제일 위가 input[i]랑 같으면
				s.pop();						// pop
				sb.append("-\n");
			}
			else {								// 스택의 제일 위가 input[i]보다 큰 경우
				num = 0;						// NO 출력용
				break;
			}
		}
		// 출력
		if(num==0)
			System.out.print("NO");
		else
			System.out.print(sb.toString());
	}
}