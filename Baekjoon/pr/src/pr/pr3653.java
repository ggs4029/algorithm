// 백준 3653번
// 상근이는 그의 DVD 콜렉션을 쌓아 보관한다.
// 보고 싶은 영화가 있을 때는, DVD의 위치를 찾은 다음 쌓아놓은 콜렉션이 무너지지 않게 조심스럽게 DVD를 뺀다.
// 영화를 다 본 이후에는 가장 위에 놓는다.
// 각 DVD의 위치는, 찾으려는 DVD의 위에 있는 영화의 개수만 알면 쉽게 구할 수 있다.
// 각 영화는 DVD 표지에 붙어있는 숫자로 쉽게 구별 가능.
// 상근이가 영화를 한 편 볼 때마다 그 DVD의 위에 몇 개의 DVD가 있었는지 출력하는 문제.
// 방법---------------------
// 첫 줄에 테스트 케이스의 개수 t가 주어짐.
// 각 테스트 케이스 첫 줄에는 가지고 있는 영화의 수 n과 보려고 하는 영화의 수 m을 입력 받음.
// 둘째 줄에는 보려고 하는 영화의 번호가 순서대로 주어짐.
// 세그먼트 트리 클래스를 구현해 사용.
// dvd 위에 몇개가 있었는지 출력하고
// 본 dvd 빼고 업데이트, dvd 맨 위로 올리고 업데이트 후 위치 갱신.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr3653 {
	public static int n, m;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			// 입력 1
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			int[] dvd = new int[n+1];
			for(int j=1; j<=n; j++)
				dvd[j] = j + m - 1;
			// 트리 생성과 초기화
			SegmentTree sTree = new SegmentTree(n + m);
			sTree.init(1, 0, n + m - 1);
			// 입력 2
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				int input = Integer.parseInt(st.nextToken());
				int tmp = dvd[input];									// 보려고 하는 dvd의 위치
				int output = sTree.sum(1, 0, n + m - 1, 0, tmp - 1);	// 구간합 구하기
				sb.append(output).append(" ");
				sTree.update(1, 0, n + m - 1, tmp, -1);					// dvd 빼고
				sTree.update(1, 0, n + m - 1, m - 1 - j, 1);			// 맨 위로 올리기
				dvd[input] = m - 1 - j;									// 위치 갱신
			}
			sb.append("\n");
		}
		// 출력
		System.out.print(sb.toString().trim());
	}

	// 세그먼트 트리 클래스
	public static class SegmentTree {

		int[] tree;

		SegmentTree(int n) {
			tree = new int[4 * n];
		}

		// 세그먼트 트리 노드값 초기화
		public int init(int node, int start, int end) {
			if(start == end) {
				if(start < m)
					return tree[node] = 0;
				else
					return tree[node] = 1;
			}
			int mid = (start + end) / 2;
			tree[node] = init(2 * node, start, mid) + init(2 * node + 1, mid + 1, end);
			return tree[node];
		}

		// 구간합 구하기
		public int sum(int node, int start, int end, int left, int right) {
			if(left <= start && end <= right)
				return tree[node];
			if(right < start || end < left)
				return 0;
			int mid = (start + end) / 2;
			return sum(2 * node, start, mid, left, right) +
					sum(2 * node + 1, mid + 1, end, left, right);
		}

		// 차이 값을 더하는 방법을 사용한 세그먼트 트리 노드 값 변경
		public void update(int node, int start, int end, int index, int diff) {
			if(start <= index && index <= end)									// 구간에 속하면
				tree[node] += diff;												// 차이 값을 더하기
			else
				return;
			if(start != end) {
				int mid = (start + end) / 2;
				update(2 * node, start, mid, index, diff);
				update(2 * node + 1, mid + 1, end, index, diff);
			}
		}
	}
}