// 백준 10866번
// 정수를 저장하는 데크 구현하는 문제.
// 구현해야하는 명령 여덟가지는 문제 참조.
// 방법---------------------
// 첫 줄에 명령의 수 n을 입력 받고
// 다음 줄부터 n줄에 걸쳐 명령을 입력 받는다.
// 문제대로 구현해 답을 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class pr10866 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		int n = Integer.parseInt(br.readLine());
		Deque<Integer> dq = new ArrayDeque<>();
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String input = st.nextToken();
			// 명령 처리
			// 명령 1 - 정수 x 덱 앞에 놓기
			if(input.equals("push_front"))
				dq.addFirst(Integer.parseInt(st.nextToken()));
			// 명령 2 - 정수 x 덱 뒤에 놓기
			else if(input.equals("push_back"))
				dq.addLast(Integer.parseInt(st.nextToken()));
			// 명령 3 - 덱 가장 앞에 있는 정수 pop 하고 출력
			else if(input.equals("pop_front")) {
				if(!dq.isEmpty())
					sb.append(dq.pollFirst()).append("\n");
				else
					sb.append(-1).append("\n");
			}
			// 명령 4 - 덱 가장 뒤에 있는 정수 pop 하고 출력
			else if(input.equals("pop_back")) {
				if(!dq.isEmpty())
					sb.append(dq.pollLast()).append("\n");
				else
					sb.append(-1).append("\n");
			}
			// 명령 5 - 덱 크기 출력
			else if(input.equals("size"))
				sb.append(dq.size()).append("\n");
			// 명령 6 - 덱이 비어있는지 체크
			else if(input.equals("empty")) {
				if(dq.isEmpty())
					sb.append(1).append("\n");
				else
					sb.append(0).append("\n");
			}
			// 명령 7 - 덱 가장 앞에 있는 정수 출력
			else if(input.equals("front")) {
				if(!dq.isEmpty())
					sb.append(dq.peekFirst()).append("\n");
				else
					sb.append(-1).append("\n");
			}
			// 명령 8 - 덱 가장 뒤에 있는 정수 출력
			else {
				if(!dq.isEmpty())
					sb.append(dq.peekLast()).append("\n");
				else
					sb.append(-1).append("\n");
			}
		}
		// 출력
		System.out.print(sb.toString().trim());
	}
}