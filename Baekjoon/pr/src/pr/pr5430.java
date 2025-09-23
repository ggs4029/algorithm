// 백준 5430번
// 새로운 언어 ac를 만든 선영이
// 두가지 함수 r과 d가 있음.
// r은 배열에 있는 수의 순서를 뒤집는 함수
// d는 첫 번째 수를 버리는 함수
// 배열 초기값과 수행할 함수가 주어지면 최종 결과를 출력하는 문제.
// 방법---------------------
// 첫 줄에 테스트 케이스의 개수 t가 주어짐.
// 각 테스트 케이스 첫 줄에는 수행할 함수 p가 주어짐.
// 그 다음 줄에는 배열에 들어있는 수의 개수 n이 주어지고
// 그 담줄에는 배열이 한 줄에 주어짐.
// 명령에 순서대로 실행하고 결과를 출력.
// 덱으로 구현하고 뒤집기 연산을 직접 뒤집지 말고
// 뒤집어진 상태에서 버리기 연산이 들어오면 앞 뒤 어디를 버릴지만
// 선택하는 식으로 구현.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class pr5430 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			String ac = br.readLine();
			int n = Integer.parseInt(br.readLine());
			String input = br.readLine();
			Deque<Integer> dq = new ArrayDeque<>();
			if(n > 0) {
				String input2 = input.substring(1, input.length()-1);
				StringTokenizer st = new StringTokenizer(input2, ",");
				while(st.hasMoreTokens())
					dq.add(Integer.parseInt(st.nextToken()));
			}
			// 연산
			boolean reverse = false;
			boolean error = false;
			for(char c : ac.toCharArray()) {
				// 뒤집기
				if(c == 'R')
					reverse = !reverse;
				// 버리기
				else {
					if(dq.isEmpty()) {
						error = true;
						break;
					}

					if(reverse)
						dq.pollLast();
					else
						dq.pollFirst();
				}
			}
			if(error)
				sb.append("error").append("\n");
			else {
				sb.append("[");
				while(!dq.isEmpty()) {
					if(reverse)
						sb.append(dq.pollLast());
					else
						sb.append(dq.pollFirst());
					if(!dq.isEmpty())
						sb.append(",");
				}
				sb.append("]").append("\n");
			}
		}
		// 출력
		System.out.print(sb.toString().trim());
	}
}