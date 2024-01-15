// 백준 2164번
// 카드2
// 큐를 이용해 문제에서 제시된 동작을 구현해
// 마지막으로 남는 카드를 구하는 문제
// 방법-------------
// n을 입력 받는다.
// 큐에 카드를 순서대로 넣는다.
// while문과 for문을 이용해
// 마지막 카드를 구하고 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class pr2164 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();
		for(int x=0; x<n; x++) {
			q.add(x+1);
		}
		// 마지막 카드 구하기
		while(q.size()>1) {				// 큐에 원소가 둘 이상 남아있으면
			q.poll();					// 카드 버리고
			q.offer(q.poll());			// 그 다음 카드를 맨 밑으로

		}
		// 출력
		System.out.print(q.poll());
	}
}