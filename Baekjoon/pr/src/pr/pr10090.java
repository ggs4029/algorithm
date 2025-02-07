// 백준 10090번
// 1부터 n까지의 정수로 이루어진 순열이 주어지면 역순의 개수를 구하는 문제.
// 주어진 순열에서 역순의 개수 구해 출력.
// 방법---------------------
// 첫 줄에 순열의 크기 n이 주어짐.
// 둘째 줄에는 순열의 값들이 주어짐.
// 세그먼트 트리 클래스 구현해 사용.
// for문으로 뒤에서부터 돌며
// 역순 개수 세고 num[i]를 트리에 추가해가며
// 개수 세고 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr10090 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] num = new int[n+1];
		for(int i=1; i<=n; i++)
			num[i] = Integer.parseInt(st.nextToken());
		// 트리 생성
		// 초기화 불필요 - 단순 역순 계산만 하면되므로 + 순열이라 각 숫자가 한번만 등장
		SegmentTree sTree = new SegmentTree(n);
		// 역순 개수 구허기
		long output = 0;
		for(int i=n; i>0; i--) {							// 뒤에서부터
			output += sTree.query(1, 1, n, 1, num[i]-1);	// 역순 개수 더해주고
			sTree.update(1, 1, n, num[i]);					// num[i] 트리에 추가
		}
		// 출력
		System.out.print(output);
	}

	// 세그먼트 트리 클래스
	public static class SegmentTree {
		public int[] tree;

		// 세그먼트 트리 초기화
		SegmentTree(int n) {
			tree = new int[4*n];
		}

		// 구간 합 계산 메소드
		int query(int node, int start, int end, int l, int r) {
			if(r<start || end<l)							// 구간 밖이면
				return 0;
			if(l<=start && end<=r)
				return tree[node];
			int mid = (start + end) / 2;
			return query(2*node, start, mid, l, r) +
					query(2*node+1, mid+1, end, l, r);
		}

		// 세그먼트 트리 노드 값 변경 메소드
		int update(int node, int start, int end, int index) {
			if(index<start || end<index)					// 구간 밖이면
				return tree[node];
			if(start == end)
				return ++tree[node];
			int mid = (start + end) / 2;
			tree[node] = update(2*node, start, mid, index) +
					update(2*node+1, mid+1, end, index);
			return tree[node];
		}
	}
}