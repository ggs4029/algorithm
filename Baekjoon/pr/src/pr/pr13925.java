// 백준 13925번
// 길이가 n인 수열이 주어지고 이 때 주어진 쿼리를 수행하는 문제.
// 쿼리의 종류는 4가지이고 자세한 내용은 문제 참조.
// 방법---------------------
// 첫 줄에 수열의 크기 n이 주어짐.
// 둘째 줄에는 수열의 값들이 주어짐.
// 셋째 줄에는 쿼리의 개수 m이 주어진다.
// 그 다음줄부터 m개의 줄에 걸쳐 쿼리가 한줄씩 주어진다.
// 구간 전체에 더하거나 곱할 일이 있으므로 느리게 갱신되는 세그트리 사용.
// 구간합 구하는데 필요한 메소드들 짜고 마지막으로 lazy_update메소드 구현.
// 2개의 lazy값 사용 -> 더하기(1번 쿼리), 곱하기(2번 쿼리) = ax + b
// 오답노트------------------
// lazy_update 메소드에서 자식노드에 값 물려주고 난 뒤에
// 자기자신 초기화 안했음.
// 오답노트2-----------------
// lazy_update 메소드에서 곱하기 먼저하고 다음 줄에 더하기를 해야함.
// 내가 lazy1, lazy2로 ax + b에서 a와 b를 관리하는데
// 더하기 먼저 해버리면 x+b에 나중에 a를 곱하는 꼴이 되어버리니까
// lazy2가 먼저 tree[node]에 연산되고 그 다음 줄에 lazy1을 처리해야함.
// 오답노트3-----------------
// 쿼리 메소드에서 if문 조건 수정.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr13925 {
	public static long[] num;
	public static long mod = 1_000_000_000 + 7;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력1
		int n = Integer.parseInt(br.readLine());
		num = new long[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++)
			num[i] = Long.parseLong(st.nextToken());
		// 트리 생성과 초기화
		SegmentTree sTree = new SegmentTree(n);
		sTree.init(num, 1, 1, n);
		// 입력2
		int m = Integer.parseInt(br.readLine());
		while(m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int q = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			// 쿼리 처리
			// 1 -> 더하기
			// 2 -> 곱하기
			// 3 -> 값 변경
			if(q != 4) {
				long v = Long.parseLong(st.nextToken());
				sTree.update(1, 1, n, x, y, q, v);
			}
			// 4 -> 구간합 구하기
			else
				sb.append(sTree.query(1, 1, n, x, y)).append("\n");
		}
		// 출력
		System.out.print(sb.toString().trim());
	}

	// 세그먼트 트리 클래스
	public static class SegmentTree {
		public long[] tree;
		public long[] lazy1;													// 1번 쿼리 덧셈용
		public long[] lazy2; 													// 2번 쿼리 곱셈용

		// 트리 높이
		SegmentTree(int n) {
			tree = new long[4*n];
			lazy1 = new long[4*n];
			lazy2 = new long[4*n];
			for(int i=0; i<4*n; i++)
				lazy2[i] = 1;													// 곱셈용이니까 1로 초기화
		}

		// 세그 트리 노드값 초기화
		public void init(long[] num, int node, int start, int end) {
			lazy2[node] = 1;
			if(start == end) 												// 리프노드면
				tree[node] = num[start] % mod;
			else {															// 리프노드 아니면
				int mid = (start + end) / 2;
				init(num, 2*node , start, mid);
				init(num, 2*node+1, mid+1, end);
				tree[node] = (tree[2*node] + tree[2*node+1]) % mod;
			}
		}

		// 세그 트리 노드값 변경
		public void update(int node, int start, int end, int l, int r, int q, long v) {
			lazy_update(node, start, end);
			if(r<start || end<l)												// 구간 밖이면
				return;
			if(l<=start && end<=r) {
				if(q == 1) 														// 1번 쿼리 - 더하기
					lazy1[node] = (lazy1[node] + v) % mod;
				else if(q == 2) {												// 2번 쿼리 - 곱하기
					lazy1[node] = (lazy1[node] * v) % mod;
					lazy2[node] = (lazy2[node] * v) % mod;
				}
				else {															// 3번 쿼리 - 값 변경
					lazy1[node] = v;
					lazy2[node] = 0;
				}
				lazy_update(node, start, end);
			}
			else {
				int mid = (start + end) / 2;
				update(2*node , start, mid, l, r, q, v);
				update(2*node+1, mid+1, end, l, r, q, v);
				tree[node] = (tree[2*node] + tree[2*node+1]) % mod;
			}
		}

		// 구간합 구하기
		public long query(int node, int start, int end, int l, int r) {
			lazy_update(node, start, end);
			if(r<start || end<l)												// 구간 밖이면
				return 0;
			if(l<=start && end<=r)
				return tree[node];
			int mid = (start + end) / 2;
			long left = query(2*node, start, mid, l, r);
			long right = query(2*node+1, mid+1, end, l, r);
			return (left + right) % mod;
		}

		// lazy 업데이트
		private void lazy_update(int node, int start, int end) {
			if(lazy1[node]==0 && lazy2[node]==1)								// 더하거나 곱할게 없으면
				return;
			tree[node] = (tree[node] * lazy2[node]) % mod;						// 곱하기 먼저 ( ax + b )
			tree[node] = (tree[node] + (end - start + 1) * lazy1[node]) % mod;	// 그 뒤에 더하기
			if(start != end) {													// 리프노드 아니면
				for(int i : new int[]{2*node, 2*node+1}) {
					lazy1[i] = (lazy1[i] * lazy2[node] + lazy1[node]) % mod;
					lazy2[i] = (lazy2[i] * lazy2[node]) % mod;
				}
			}
			// 값 초기화
			lazy1[node] = 0;
			lazy2[node] = 1;
		}
	}
}