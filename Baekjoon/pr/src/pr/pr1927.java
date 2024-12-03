// 백준 1927번
// 최소 힙을 이용하여 다음과 같은 연산을 지원하는 프로그램 작성하기.
// 1. 배열에 자연수 x를 넣는다.
// 2. 배열에서 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다.
// 방법---------------------
// 첫째 줄에 연산의 개수 n이 주어짐.
// 다음 n줄에는 연산에 대한 정보를 나타내는 정수 x가 주어짐.
// x가 자연수면 값을 추가하는 연산, 0이면 배열에서 가장 작은 값을 제거하는 연산.
// 우선순위 큐를 사용해 최소값 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class pr1927 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> h = new PriorityQueue<>();
		for(int i=0; i<n; i++) {
			// 입력
			int x = Integer.parseInt(br.readLine());
			// 연산
			if(x==0) {
				if(h.isEmpty())
					sb.append(0).append("\n");
				else
					sb.append(h.poll()).append("\n");
			}
			else
				h.offer(x);
		}
		// 출력
		System.out.print(sb.toString());
	}
}