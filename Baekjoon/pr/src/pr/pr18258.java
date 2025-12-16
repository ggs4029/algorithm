// 백준 10845번
// 정수를 저장하는 큐를 구현하고
// 입력으로 주어지는 명령을 처리하는 문제.
// 방법---------------------
// 첫 줄에 명령 수 n을 입력 받음.
// 다음 줄부터 명령들을 입력 받음.
// 명령에 맞는 행동을 구현해 결과를 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class pr18258 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();
		int last = 0;
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String input = st.nextToken();
			// 명령 수행
			// 명령 1 - 정수 x 큐에 넣기
			if(input.equals("push")) {
				int x = Integer.parseInt(st.nextToken());
				q.add(x);
				last = x;
			}
			// 명령 2 - 큐 가장 앞 정수 빼고 그 수 출력
			else if(input.equals("pop")) {
				if(q.size() != 0)
					sb.append(q.poll()).append("\n");
				else
					sb.append(-1).append("\n");
			}
			// 명령 3 - 큐에 들어있는 정수 개수 출력
			else if(input.equals("size"))
				sb.append(q.size()).append("\n");
			// 명령 4 - 큐가 비어있는지 출력
			else if(input.equals("empty")) {
				if(q.isEmpty())
					sb.append(1).append("\n");
				else
					sb.append(0).append("\n");
			}
			// 명령 5 - 큐 가장 앞 원소 출력
			else if(input.equals("front")) {
				if(q.size() != 0)
					sb.append(q.peek()).append("\n");
				else
					sb.append(-1).append("\n");
			}
			// 명령 6 - 큐 가장 뒤 정수 출력
			else {
				if(q.size() != 0)
					sb.append(last).append("\n");
				else
					sb.append(-1).append("\n");
			}
		}
		// 출력
		System.out.print(sb.toString().trim());
	}
}