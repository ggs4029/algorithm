// 백준 16975번
// 길이가 n인 수열이 주어짐.
// 두가지 쿼리를 수행하는 프로그램을 작성하시오.
// 1 i j k -> i~j범위의 값에 k를 더함.
// 2 x     -> 수열의 값을 출력.
// 방법---------------------
// 첫 줄에 수열의 크기 n이 주어짐.
// 둘째 줄에는 수열의 값들이 주어짐.
// 셋째 줄에는 쿼리의 개수 m이 주어진다.
// 그 다음줄부터 m개의 줄에 걸쳐 쿼리가 한줄씩 주어진다.
// 그 다음 줄부터 n줄에 걸쳐 수가 주어진다.
// 느리게 갱신되는 세그먼트 트리 클래스를 구현해 사용.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr16975 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력1
		int n = Integer.parseInt(br.readLine());
		long[] num = new long[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++)
			num[i] = Long.parseLong(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		// 트리 생성과 초기화
		SegmentTree sTree = new SegmentTree(n);
		sTree.init(num, 1, 1, n);
		// 구간 합 구하기
		for(int l=0; l<m; l++) {
			// 입력2
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			// k 더하기
			if(a==1) {
				int i = Integer.parseInt(st.nextToken());
				int j = Integer.parseInt(st.nextToken());
				long k = Long.parseLong(st.nextToken());
				sTree.update(1, 1, n, i, j, k);
			}
			// Ax 출력
			else {
				int x = Integer.parseInt(st.nextToken());
				sb.append(sTree.printAx(x)).append("\n");
			}
		}
		// 출력
		System.out.print(sb.toString().trim());
	}

	public static class SegmentTree {
		public static long[] tree;
		public static long[] lazy;
		public static int n;

		// 세그먼트 트리 전체 노드 수 계산
		SegmentTree(int n) {
			this.n = n;
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

		// 세그먼트 트리 노드 값 변경 -> 차이 값을 더하는 방법을 사용
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

		// 세그먼트 트리 값 출력
		static long query(int node, int start, int end, int left, int right) {
			updateLazy(node, start, end);
			if(right<start || end<left)
				return 0;
			if(left<=start && end<=right)
				return tree[node];
			int tmp = (start+end) / 2;
			long leftSide = query(node*2, start, tmp, left, right);
			long rightSide = query(node*2+1, tmp + 1, end, left, right);
			return leftSide + rightSide;
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

		// Ax 출력 메소드
		static long printAx(int x) {
			return query(1, 1, n, x, x);
		}
	}
}