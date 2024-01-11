// 백준 11866번
// 요세푸스 문제 0
// 방법-------------
// n과 k를 한 줄에 입력 받고
// for문을 이용해 1부터 n까지 큐에 넣는다.
// 요세푸스 순열을 for문을 통해 구한다.
// while문 안의 for문을 돌며
// k번째가 아니면 poll()한걸 바로 offer()하는 식으로 뒤로 원소를 밀고
// k번째일때 poll()하는 식으로 구현

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class pr11866 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		// 입력
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		Queue<Integer> que = new LinkedList<>();
		for(int x=0; x<n; x++) {
			que.add(x+1);
		}
		// 요세푸스 순열 구하기
		while(que.size()>=1) {									// 큐에 원소가 남아있으면
			for(int x=0; x<k; x++) {
				if(x==k-1) {									// k번째인 경우
					if(que.size()==1)							// 큐의 마지막 원소일 경우
						sb.append(que.poll()).append(">");
				else
						sb.append(que.poll()).append(", ");
				}
				else {											// k번째가 아닌 경우
					que.offer(que.poll());						// poll한걸 다시 offer
				}
			}
		}
		// 출력
		System.out.print(sb.toString());
	}
}