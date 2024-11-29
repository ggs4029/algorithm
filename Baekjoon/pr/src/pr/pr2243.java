// 백준 2243번
// 수정이는 평소에 여러 개의 사탕을 사서 사탕상자에 넣어두고, 동생이 말을 잘 들을 때면 그 안에서 사탕을 꺼내서 주곤 한다.
// 각각의 사탕은 그 맛의 좋고 나쁨이 1부터 1,000,000까지의 정수로 구분된다.
// 1 = 가장 맛있는 사탕, 1,000,000 = 가장 맛없는 사탕
// 수정이는 동생이 말을 잘 들은 정도에 따라서, 사탕상자 안에 있는 사탕들 중 몇 번째로 맛있는 사탕을 꺼내줌.
// 수정이가 보관하고 있는 사탕은 매우 많기 때문에 매번 사탕상자를 뒤져서 꺼낼 사탕을 골라내는 일은 매우 어려움.
// 고로 수정이를 도와주는 프로그램을 작성.
// 방법---------------------
// 첫 줄에 사탕상자에 손 댄 횟수 n을 입력 받음.
// 다음 줄부터 a,b or a,b,c를 입력 받는다.
// a=1인 경우 - 사탕상자에서 사탕 꺼내는 경우, 이때에는 한 정수만 주어지며, b는 꺼낼 사탕의 순위를 의미.
// a=2인 경우 - 사탕 넣는 경우,  b는 넣을 사탕의 맛을 나타내는 정수이고 c는 그러한 사탕의 개수를 의미.
// 세그먼트 트리 클래스를 구현해 사용.
// 트리의 인덱스 = 사탕의 맛, 들어있는 값 = 그 맛의 사탕 개수

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class pr2243 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		int n = Integer.parseInt(br.readLine());
		// 트리 생성과 초기화
		SegmentTree sTree = new SegmentTree(1000000);
		for(int i=0; i<n; i++) {
			// 입력2
			String[] input2 = br.readLine().split(" ");
			int a = Integer.parseInt(input2[0]);
			int b = Integer.parseInt(input2[1]);
			// 연산
			if(a==1) {
				int tmp = sTree.query(1, 1000000, 1, b);
				sb.append(tmp).append("\n");
			}
			else {
				int c = Integer.parseInt(input2[2]);
				sTree.update(1, 1000000, 1, b, c);
			}
		}
		// 출력
		System.out.print(sb.toString());
	}

	// 세그먼트 트리 클래스
	public static class SegmentTree {
		int[] tree;
		int n;

		// 트리 초기화
		public SegmentTree(int n) {
			this.n = n;
			this.tree = new int[4*n];
		}

		// 쿼리
		public int query(int start, int end, int idx, int target) {
			if(start == end) {														// 사탕 찾으면
				update(1, n, 1, start, -1);											// 사탕 개수 -1
				return start;
			}
			int mid = (start + end) / 2;
			if(target <= tree[idx * 2])
				return query(start, mid, idx * 2, target);
			else
				return query(mid + 1, end, idx * 2 + 1, target - tree[idx * 2]);
		}

		// 업데이트
		public void update(int start, int end, int idx, int target, int diff) {
			if(target < start || end < target)
				return;
			tree[idx] += diff;
			if(start == end)
				return;
			int mid = (start + end) / 2;
			update(start, mid, idx * 2, target, diff);
			update(mid + 1, end, idx * 2 + 1, target, diff);
		}
	}
}