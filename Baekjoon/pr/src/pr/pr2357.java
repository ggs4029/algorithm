// 백준 2357번
// 어떤 N개의 수가 주어져 있다.
// 그 수들의 중간에 어떤 부분의 최솟값과 최댓값을 M번 구하려 하는 문제.
// 방법---------------------
// 첫째 줄에 n, m이 주어진다.
// 다음 n개의 줄에는 정수들이 주어짐.
// 다음 m개의 줄에 a, b의 쌍이 주어짐.
// 세그먼트 트리 클래스를 구현해 최솟값과 최댓값 구해 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr2357 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력1
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		long[] num = new long[n+1];
		for(int i=1; i<=n; i++)
			num[i] = Long.parseLong(br.readLine());
		// 트리 생성과 초기화
		SegmentTree sTree = new SegmentTree(n);
		sTree.init(num, 1, 1, n);
		// 구간 합 구하기
		for(int i=0; i<m; i++) {
			// 입력2
			String[] input2 = br.readLine().split(" ");
			int a = Integer.parseInt(input2[0]);
			int b = Integer.parseInt(input2[1]);
			// 최솟값, 최댓값 출력
			long min = sTree.min(1, 1, n, a, b);
            long max = sTree.max(1, 1, n, a, b);
            sb.append(min).append(" ").append(max).append("\n");
		}
		// 출력
		System.out.print(sb.toString());
	}

	// 세그먼트 트리 클래스
	public static class SegmentTree {
		public static long[] tree1;
		public static long[] tree2;

		// 세그먼트 트리 전체 노드 수 계산
		SegmentTree(int n) {
			double treeH = Math.ceil(Math.log(n)/Math.log(2))+1;				// 트리 높이 계산
			long nodeSum = Math.round(Math.pow(2, treeH));						// 트리의 노드 수 계산						// 트리의 길이
			tree1 = new long[Math.toIntExact(nodeSum)];
			tree2 = new long[Math.toIntExact(nodeSum)];
		}

		// 세그먼트 트리 노드값 초기화
		void init(long[] num, int node, int start, int end ){
			if(start == end) {													// 리프노드면
				tree1[node] = num[start];
				tree2[node] = num[start];
			}
			else {																// 리프노드 아니면
				int tmp = (start + end) / 2;
				init(num, node * 2, start, tmp);
				init(num, node * 2 + 1, tmp + 1, end);
				tree1[node] = Math.min(tree1[node * 2], tree1[node * 2 + 1]);
				tree2[node] = Math.max(tree2[node * 2], tree2[node * 2 + 1]);
			}
		}

		// 세그먼트 트리로 최솟값 찾기
		long min(int node, int start, int end, int l, int r) {
			if(r < start || end < l)
				return Long.MAX_VALUE;
			if(l <= start && end <= r)
				return tree1[node];
			int tmp = (start + end) / 2;
			long left = min(node * 2, start, tmp, l, r);
			long right = min(node * 2 + 1, tmp + 1, end, l, r);
			return Math.min(left, right);
		}

		// 세그먼트 트리로 최댓값 찾기
		long max(int node, int start, int end, int l, int r) {
			if(r < start || end < l)
				return Long.MIN_VALUE;
			if(l <= start && end <= r)
				return tree2[node];
			int tmp = (start + end) / 2;
			long left = max(node * 2, start, tmp, l, r);
			long right = max(node * 2 + 1, tmp + 1, end, l, r);
			return Math.max(left, right);
		}
	}
}