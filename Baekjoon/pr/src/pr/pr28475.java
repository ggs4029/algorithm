// 백준 28475번
// 편광판은 빛의 진동 방향을 바꿈.
// 빛이 현재 진동하는 방향과 수직한 편광판을 만나면 가로막힌다.
// 그렇지 않은 경우에는 편광판 방향으로 진동 방향을 바꾸면서 통과한다.
// 여러 편광판들이 연속해서 있고, 각 편광판은 45도 단위로 조작할 수 있다.
// 시작점과 끝점이 주어지면 시작점에서 빛을 쏴서 편광판을 모두 통과하여 끝점에 도달할 수 있는지 구하는 문제.
// 쿼리에서
// 1 a b	-> a번째 편광판을 45 * b도 방향으로 조작.
// 2 a b	-> a번째 편광판에 빛을 쐈을 때 b번째 편광판을 빛이 통과할수 있는지 출력.
// 방법---------------------
// 첫 줄에 편광판의 개수 n과 쿼리의 개수 m이 주어짐.
// 둘째 줄에는 편광판의 초기 상태인 n개의 정수가 주어짐.
// 다음 줄부터 m줄에 걸쳐 쿼리 q a b가 주어짐.
// 세그먼트 트리 클래스 구현해 사용.
// 세그먼트 트리 클래스 dont 메소드에서
// 360/45 = 8 이므로 두 편광판의 방향 차가 2나 6이면 수직인 것.
// 오답노트------------------
// 업데이트 메소드 호출 시 인덱스 실수.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr28475 {
	public static int[] num;
	public static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 입력 1
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		num = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++)
			num[i] = Integer.parseInt(st.nextToken());
		// 트리 생성과 초기화
		SegmentTree sTree = new SegmentTree(n);
		sTree.init(1, 1, n-1);
		// 쿼리 처리
		for(int i=0; i<m; i++) {
			// 입력 2
			st = new StringTokenizer(br.readLine());
			int q = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			// 쿼리 처리
			if(q==1) {
				num[a] = b;
				if(a>1)
					sTree.update(1, 1, n-1, a-1);		// 전 편광판 상태도 업뎃
				if(a<n)
					sTree.update(1, 1, n-1, a);
			}
			else {
				if(sTree.query(1, 1, n-1, a, b-1))		// 통과 가능하면
					sb.append(1).append("\n");
				else									// 불가능하면
					sb.append(0).append("\n");
			}
		}
		// 출력
		System.out.print(sb.toString().trim());
	}

	// 세그먼트 트리 클래스
	public static class SegmentTree {
		public static boolean[] tree;

		SegmentTree(int n) {
			tree = new boolean[4*n+1];
		}

		// 세그먼트 트리 노드값 초기화
		boolean init(int node, int start, int end) {
			if(start == end)
				return tree[node] = !dont(start);
			else {
				int mid = (start+end)/2;
				boolean left = init(2*node, start, mid);
				boolean right = init(2*node+1, mid+1, end);
				tree[node] = left && right;
				return tree[node];
			}
		}

		// 모든 구간에서 빛이 편광판을 통과하는지 검사하는 메소드
		boolean query(int node, int start, int end, int l, int r) {
			if(r<start || end<l)											// 구간 밖이면
				return true;
			if(l<=start && end<=r)
				return tree[node];
			int mid = (start+end)/2;
			boolean left = query(2*node, start, mid, l, r);
			boolean right = query(2*node+1, mid+1, end, l, r);
			return left && right;
		}

		// 세그먼트 트리 값 변경
		void update(int node, int start, int end, int value) {
			if(start<=value && value<=end) {
				if(start == end)
					tree[node] = !dont(value);
				else {
					int mid = (start+end)/2;
					if(value <= mid)
                        update(2*node, start, mid, value);
                    else
                        update(2*node+1, mid+1, end, value);
                    tree[node] = tree[2*node] && tree[2*node+1];
				}
			}
		}

		// 방향차 계산으로 빛이 편광판을 통과할 수 없는 구간 결정하는 메소드
		boolean dont(int k) {
			long angle = Math.abs(num[k] - num[k+1]);
			return angle==2 || angle==6;								// 편광판끼리 수직인 경우
		}
	}
}