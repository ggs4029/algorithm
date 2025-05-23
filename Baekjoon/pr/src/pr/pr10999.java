// 백준 10999번
// 어떤 N개의 수가 주어져 있다.
// 그런데 중간에 수의 변경이 빈번히 일어나고 그 중간에 어떤 부분의 합을 구하려 하는 문제.
// 방법---------------------
// 첫 줄에 수의 개수 n과 수의 변경이 일어나는 횟수 m, 구간의 합을 구하는 횟수 k가 주어진다.
// 그 다음 줄부터 n줄에 걸쳐 수가 주어진다.
// 그 다음에 m+k줄에 걸쳐 a, b, c나 a, b,c, d를 입력 받고
// a가 1인 경우 b번째 수부터 c번째 수에 d를 더하고, a가 2인 경우에는 b번째 수부터 c번째 수의 합을 구하여 출력.
// 느리게 갱신되는 세그먼트 트리 클래스를 구현해 사용한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr10999 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력1
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int k = Integer.parseInt(input[2]);
		long[] num = new long[n+1];
		for(int i=1; i<=n; i++)
			num[i] = Long.parseLong(br.readLine());
		// 트리 생성과 초기화
		SegmentTree sTree = new SegmentTree(n);
		sTree.init(num, 1, 1, n);
		// 구간 합 구하기
		for(int i=0; i<m+k; i++) {
			// 입력2
			String[] input2 = br.readLine().split(" ");
			int a = Integer.parseInt(input2[0]);
			int b = Integer.parseInt(input2[1]);
			int c = Integer.parseInt(input2[2]);
			// 값 변경
			if(a==1) {
				long d = Long.parseLong(input2[3]);
				sTree.update(1, 1, n, b, c, d);
			}
			// 구간 합 출력
			else {
				long output = sTree.sum(1, 1, n, b, Math.toIntExact(c));
				sb.append(output).append("\n");
			}
		}
		// 출력
		System.out.print(sb.toString());
	}

	public static class SegmentTree {
		public static long[] tree;
		public static long[] lazy;

		// 세그먼트 트리 전체 노드 수 계산
		SegmentTree(int n) {
			double treeH = Math.ceil(Math.log(n)/Math.log(2))+1;				// 트리 높이 계산
			long treeS = Math.round(Math.pow(2, treeH));						// 트리의 노드 수 계산
			tree = new long[Math.toIntExact(treeS)];							// 트리의 길이
			lazy = new long[Math.toIntExact(treeS)];
		}

		// 세그먼트 트리 노드값 초기화
		long init(long[] num, int node, int start, int end ){
			if(start == end) {													// 리프노드면
				tree[node] = num[start];										// 배열 값 저장 후 리턴
				return tree[node];
			}
			else {																// 리프노드 아니면
				tree[node] = init(num, node*2, start, (start+end)/2)+			// 자식노드(좌, 우) 더해서 리턴(재귀)
						init(num, node*2+1, (start+end)/2+1, end);
				return tree[node];
			}
		}

		// 세그먼트 트리로 구간 합 구하기
		long sum(int node, int start, int end, int l, int r) {
			updateLazy(node, start, end);
			if(r < start || end < l)
				return 0;
			else if (l <= start && end <= r) {									// 구간에 속하면
				return tree[node];												// 노드 값 리턴
			}
			else {
				int tmp = (start+end)/2;										// 중간
				return sum(node*2, start, tmp, l, r)
						+ sum(node*2+1, tmp+1, end, l, r);
			}
		}

		// 차이 값을 더하는 방법을 사용한 세그먼트 트리 노드 값 변경
		static void update(int node, int start, int end, int left, int right, long diff) {
			updateLazy(node, start, end);
			if(right<start || end<left)
				return;
			if(left<=start && end<=right) {
				lazy[node] += diff;
				updateLazy(node, start, end);
				return;
			}
			int tmp = (start+end) / 2;
			update(node*2, start, tmp, left, right, diff);
			update(node*2+1, tmp + 1, end, left, right, diff);
			tree[node] = tree[node*2] + tree[node*2+1];
		}

		// lazy 업데이트
		static void updateLazy(int node, int start, int end) {
			if(lazy[node]!=0) {
				tree[node] += (end - start + 1) * lazy[node];
				if(start!=end) {
					lazy[node*2] += lazy[node];
					lazy[node*2+1] += lazy[node];
				}
				lazy[node] = 0;
			}
		}
	}
}