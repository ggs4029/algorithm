// 백준 2268번
// 두 함수가 주어짐.
// sum 함수 - N개의 수 A[1], A[2], …, A[N] 이 주어졌을 때, A[i] + A[i+1] + … + A[j]를 구하는 함수
// modify 함수 - Modify(i, k)를 수행하면 A[i] = k가 되는 함수
// Sum함수와 Modify 함수의 사용 목록이 주어졌을 때, 이에 해당하는 연산을 하고 결과를 출력하는 문제.
// 방법---------------------
// 첫 줄에 n과 m을 입력 받음.
// 그 다음 줄부터 m줄에 걸쳐 수행한 순서대로 연산 목록이 주어짐.
// 0일 경우에는 Sum 함수를, 1일 경우에는 Modify 함수를 나타내고, 그 다음의 두 수는 각 함수의 인자 (i, j)나 (i, k)를 나타냄.
// 세그먼트 트리 클래스를 구현해 사용.

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class pr2268 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		// 트리 생성과 초기화
		SegmentTree sTree = new SegmentTree(n);
		sTree.init(0, n-1, 1);
		// 연산
		for(int i=0; i<m; i++) {
			// 입력2
			String[] input2 = br.readLine().split(" ");
			int a = Integer.parseInt(input2[0]);
			int b = Integer.parseInt(input2[1])-1;
			int c = Integer.parseInt(input2[2])-1;
			// 구간합 구하기 - sum
			if(a==0) {
				if(b<=c)
					sb.append(sTree.sum(0, n - 1, 1, b, c)).append("\n");
				else
					sb.append(sTree.sum(0, n - 1, 1, c, b)).append("\n");
			}
			// 값 변경하기 - modify
			else {
				sTree.modify(0, n - 1, 1, b, c + 1);
				sTree.tmp[b] = c + 1;
			}
		}
		// 출력
		System.out.print(sb.toString());
	}

	// 세그먼트 트리 클래스
	public static class SegmentTree {
		long[] tree, tmp;
		int n;

		// 트리 초기화
		public SegmentTree(int n) {
			this.n = n;
			this.tree = new long[4*n];
			this.tmp = new long[n];
		}

		// 트리 노드 값 초기화
		public long init(int start, int end, int node) {
			if(start == end)
				return tree[node] = tmp[start];
			int mid = (start + end) / 2;
			return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
		}

		// 구간 합 구하기
		public long sum(int start, int end, int node, int left, int right) {
			if(left > end || right < start)
				return 0;
			if(left <= start && end <= right)
				return tree[node];
			int mid = (start + end) / 2;
			return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
		}

		// 값 갱신
		public long modify(int start, int end, int node, int index, int val) {
			if(index < start || index > end)
				return tree[node];
			if(start == end)
				return tree[node] = val;
			int mid = (start + end) / 2;
			return tree[node] = modify(start, mid, node * 2, index, val) + modify(mid + 1, end, node * 2 + 1, index, val);
		}
	}
}