// 백준 14427번
// 길이가 n인 수열이 주어지면 쿼리를 수행하는 문제.
// 쿼리에는 두가지가 있고 문제 참조.
// 수열의 인덱스는 1부터 시작한다.
// 방법---------------------
// 첫 줄에 수열의 크기 n이 주어짐.
// 둘쨰 줄에 수열의 요소들이 한 줄에 주어짐.
// 셋째 줄에 쿼리의 개수 m이 주어지고
// 다음 줄부터 m줄에 걸쳐 쿼리가 주어짐.
// pr14428에서 사용한 코드의 세그먼트 트리 클래스를 가져와 사용.
// 14428의 경우에는 특정 구간에서의 최솟값의 인덱스를 찾는 쿼리였고
// 이 문제는 전체에서 최솟값의 인덱스를 찾는 문제이므로
// 이 문제에서는 그냥 범위를 1, n으로 잡고 14428의 메소드 그대로 이용.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr14427 {
	public static long[] num;
	public static int[] tree;
	public static int n, m;

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
		sTree.init(1, 1, n);
		// 구간 합 구하기
		int m = Integer.parseInt(br.readLine());
		for(int i=0; i<m; i++) {
			// 입력2
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			// 값 변경
			if(a==1) {
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				sTree.update(1, 1, n, b, c);
			}
			// 크기가 가장 작은 값 인덱스 구하기
			else {
				int output = sTree.query(1, 1, n, 1, n);
				sb.append(output).append("\n");
			}
		}
		// 출력
		System.out.print(sb.toString().trim());
	}

	// 세그먼트 트리 클래스
	public static class SegmentTree {
		public static int[] tree;

		// 트리 높이
		SegmentTree(int n) {
			tree = new int[4*n];
		}

		// 세그먼트 트리 노드값 초기화
		void init(int node, int s, int e){
			if(s == e)													// 리프노드면
				tree[node] = s;
			else {
				int mid = (s + e) / 2;
				init(2*node, s, mid);
				init(2*node+1, mid+1, e);
				if(num[tree[2*node]] <= num[tree[2*node+1]])
					tree[node] = tree[2*node];
				else
					tree[node] = tree[2*node+1];
			}
		}

		// 주어진 구간에 있는 요소들 중 최소값의 인덱스를 찾기
		int query(int node, int s, int e, int l, int r) {
			if(r<s || e<l)												// 구간 밖이면 -1 리턴
				return -1;
			if(l<=s && e<=r)
				return tree[node];
			int mid = (s + e) / 2;
			int left = query(2*node, s, mid, l, r);
			int right = query(2*node+1, mid+1, e, l, r);
			if(left == -1)
				return right;
			else if(right == -1)
				return left;
			else {
				if(num[left]<=num[right])
					return left;
				else
					return right;
			}
		}

		// 세그먼트 트리 값 변경
		void update(int node, int s, int e, int index, long value) {
			if(s == e) { 												// 리프노드면
				num[s] = value; 										// 값 변경하고
				tree[node] = s; 										// 인덱스 업뎃
			}
			else {
				int mid = (s + e) / 2;
				if(s<=index && index<=mid)
					update(2*node, s, mid, index, value);
				else
					update(2*node+1, mid+1, e, index, value);
				int left = tree[2*node];
				int right = tree[2*node+1];
				if(num[left] < num[right])
					tree[node] = left;
				else if(num[left] > num[right])
					tree[node] = right;
				else													// 값이 같으면
					tree[node] = Math.min(left, right);					// 작은거 반환
			}
		}
	}
}