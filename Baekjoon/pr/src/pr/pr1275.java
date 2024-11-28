// 백준 1275번
// 어떤 N개의 수가 주어져 있다.
// 그런데 중간에 수의 변경이 빈번히 일어나고 그 중간에 어떤 부분의 합을 구하려 하는 문제.
// 이 문제는 부분의 합을 먼저 구하고 그 다음에 수의 변경이 이뤄지는 문제이다.
// 보통의 문제는 수의 변경이 먼저고 부분의 합을 구하지만 이 문제는 반대.
// 방법---------------------
// 첫 줄에 수의 개수 n과 턴의 개수 q가 주어짐.
// 그 다음 줄에 처음 배열에 들어가있는 정수 n개가 주어짐.
// 그 다음에 q줄에 걸쳐 x, y, a, b를 입력 받고 (x~y까지의 합을 구하여라, a번째 수를 b로 바꾸어라)
// 구간합을 먼저 구하고 수를 변경한다.
// 느리게 갱신되는 세그먼트 트리 클래스를 구현해 사용한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr1275 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력1
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int q = Integer.parseInt(input[1]);
		long[] num = new long[n+1];
		String[] input2 = br.readLine().split(" ");
		for(int i=1; i<=n; i++)
			num[i] = Long.parseLong(input2[i-1]);
		// 트리 생성과 초기화
		SegmentTree sTree = new SegmentTree(n);
		sTree.init(num, 1, 1, n);
		// 구간 합 구하기
		for(int i=0; i<q; i++) {
			// 입력2
			String[] input3 = br.readLine().split(" ");
			int x = Integer.parseInt(input3[0]);
			int y = Integer.parseInt(input3[1]);
			int a = Integer.parseInt(input3[2]);
			int b = Integer.parseInt(input3[3]);
			// 값 변경
			if(x>y) {
				int tmp = y;
				y = x;
				x = tmp;
			}
			long output = sTree.sum(1, 1, n, x, y);
			sb.append(output).append("\n");
			sTree.update(1, 1, n, a, a, b-num[a]);
			num[a] = b;
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