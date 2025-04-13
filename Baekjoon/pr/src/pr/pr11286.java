// 백준 11286번
// 절댓값 힙을 구현하는 문제.
// 문제에서 주어진 연산을 구현.
// 빈 배열에서 시작.
// 방법---------------------
// 첫 줄에 연산의 개수 n을 입력 받음.
// 다음 줄부터 연산 정보 x를 입력 받음.
// 우선순위 큐 구현해 문제에서 주어진 연산 수행 후 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class pr11286 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer x, Integer y) {
				if(Math.abs(x) == Math.abs(y))				// 같으면
					return x - y;							// 작은거 리턴
				else
					return Math.abs(x) - Math.abs(y);		// 절댓값 차이로 리턴
			}
		});
		for(int i=0; i<n; i ++) {
			int x = Integer.parseInt(br.readLine());
			if(x == 0) {
				if(q.isEmpty())
					sb.append(0).append("\n");
				else
					sb.append(q.poll()).append("\n");
			}
			else
				q.offer(x);
		}
		// 출력
		System.out.print(sb.toString().trim());
	}
}