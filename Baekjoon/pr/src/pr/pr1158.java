// 백준 1158번
// 1~n번까지 n명의 사람이 원을 이루어 앉아 있고 양의 정수 k가 주어짐.
// 순서대로 k번째 사람을 제거하며 n명이 다 제거될 때까지 계속함.
// 제거되는 순서를 요세푸스 순열이라고 함.
// n과 k가 주어지면 요세푸스 순열 구하기.
// 방법---------------------
// 첫 줄에 n과 k가 주어짐.
// 큐 만들고 1 ~ n까지 집어넣음.
// 큐에 마지막 하나만 남을 때 까지 순회하면서
// k번째 애를 찾아 제거하고 스트링빌더에 append
// 결과를 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class pr1158 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		Queue<Integer> q = new LinkedList<>();
		for(int i=1; i<=n; i++)
			q.offer(i);
		// 요세푸스 순열 구하기
		sb.append("<");
		while(q.size() > 1) {
			for(int i=0; i<k-1; i++)			// k번째가 아니면 맨 앞 애를 맨 뒤로
				q.offer(q.poll());
			sb.append(q.poll()).append(", ");	// k번째 제거
		}
		sb.append(q.poll()).append(">");
		// 출력
		System.out.print(sb.toString().trim());
	}
}