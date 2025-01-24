// 백준 14428번
// 길이가 n인 수열이 주어지면 쿼리를 수행하는 문제.
// 쿼리에는 두가지가 있고 문제 참조.
// 수열의 인덱스는 1부터 시작한다.
// 방법---------------------
// 첫 줄에 수열의 크기 n이 주어짐.
// 둘쨰 줄에 수열의 요소들이 한 줄에 주어짐.
// 셋째 줄에 쿼리의 개수 m이 주어지고
// 다음 줄부터 m줄에 걸쳐 쿼리가 주어짐.
// 세그먼트 트리 클래스를 구현해 사용.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr14428 {
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
			String[] input2 = br.readLine().split(" ");
			int a = Integer.parseInt(input2[0]);
			int b = Integer.parseInt(input2[1]);
			int c = Integer.parseInt(input2[2]);
			// 값 변경
			if(a==1)
				sTree.update(1, 1, n, b, c);
			// 크기가 가장 작은 값 인덱스 출력
			else {
				int output = sTree.query(1, 1, n, b, c);
				sb.append(output).append("\n");
			}
		}
		// 출력
		System.out.print(sb.toString().trim());
	}

	public static class SegmentTree {
		public static int[] tree;

		// 세그먼트 트리
		SegmentTree(int n) {
			tree = new int[4*n];
		}

		// 세그먼트 트리 노드값 초기화
		void init(int node, int start, int end){
			if(start == end)													// 리프노드면
				tree[node] = start;
			else {
				int mid = (start + end) / 2;
				init(2*node, start, mid);
				init(2*node+1, mid+1, end);
				if(num[tree[2*node]] <= num[tree[2*node+1]])
					tree[node] = tree[2*node];
				else
					tree[node] = tree[2*node+1];
			}
		}

		// 주어진 구간에 있는 요소들 중 최소값의 인덱스를 찾기
		int query(int node, int start, int end, int l, int r) {
			if(r<start || end<l)												// 구간 밖이면 -1 리턴
				return -1;
			if(l<=start && end<=r)
				return tree[node];
			int mid = (start + end) / 2;
			int left = query(2*node, start, mid, l, r);
			int right = query(2*node+1, mid+1, end, l, r);
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
		void update(int node, int start, int end, int index, long value) {
			if(start == end) { 													// 리프노드면
				num[start] = value; 											// 값 변경하고
				tree[node] = start; 											// 인덱스 업뎃
			}
			else {
				int mid = (start + end) / 2;
				if(start<=index && index<=mid)
					update(2*node, start, mid, index, value);
				else
					update(2*node+1, mid+1, end, index, value);
				int left = tree[2*node];
				int right = tree[2*node+1];
				if(num[left] < num[right])
					tree[node] = left;
				else if(num[left] > num[right])
					tree[node] = right;
				else															// 값이 같으면
					tree[node] = Math.min(left, right);							// 작은거 반환
			}
		}
	}
}