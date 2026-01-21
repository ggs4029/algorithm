// 백준 5676번
// 길이가 n인 수열이 주어지면 쿼리를 수행하는 문제.
// k개의 명령을 내릴거고 명령엔 두가지가 있음.
// 명령에 대해선 문제 참조.
// 방법---------------------
// 테스트 케이스를 입력이 안 들어올 때 까지 받을 거임.
// 각 테스트 케이스의 첫줄은 수열 크기 n과 명령 개수 k를 입력 받음.
// 둘쨰 줄에 수열의 요소들이 한 줄에 주어짐.
// 셋째 줄부터 k줄에 걸쳐 명령이 주어짐.
// 세그먼트 트리 클래스 만들고 구간곱 메소드 구현하기.
// 부호만 구하면 되므로 처음에 저장할 때 1, -1, 0으로 구분해 저장.
// 명령에 대한 답을 출력.
// 오답노트1-----------------
// 세그먼트 클래스 안의 구간곱 구하는 메소드에서
// 구간 밖일 때 -1을 리턴하고 있는데 이는 곱셈 부호에 영향을 주므로
// 1을 리턴하도록 바꿈.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr5676 {
	public static int[] num;
	public static int n, k;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input;
		while((input = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(input);
			if(!st.hasMoreTokens())
				break;
			// 입력
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			num = new int[n+1];
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=n; i++) {
				int tmp = Integer.parseInt(st.nextToken());
				if(tmp > 0)
					num[i] = 1;
				else if(tmp < 0)
					num[i] = -1;
				else
					num[i] = 0;
			}
			// 트리 생성과 초기화
			SegmentTree sTree = new SegmentTree(n);
			sTree.init(1, 1, n);
			// 명령 받기
			for(int x=0; x<k; x++) {
				st = new StringTokenizer(br.readLine());
				String order = st.nextToken();
				// 변경 명령
				if(order.equals("C")) {
					int i = Integer.parseInt(st.nextToken());
					int v = Integer.parseInt(st.nextToken());
					if(v > 0)
						sTree.update(1, 1, n, i, 1);
					else if(v < 0)
						sTree.update(1, 1, n, i, -1);
					else
						sTree.update(1, 1, n, i, 0);
				}
				// 곱셈 명령
				else {
					int i = Integer.parseInt(st.nextToken());
					int j = Integer.parseInt(st.nextToken());
					int output = sTree.query(1, 1, n, i, j);
					if(output > 0)
						sb.append("+");
					else if(output < 0)
						sb.append("-");
					else
						sb.append("0");
				}
			}
			sb.append("\n");
		}
		// 출력
		System.out.print(sb.toString().trim());
	}

	// 세그먼트 트리 클래스
	public static class SegmentTree {
		public int[] tree;

		// 트리 높이
		SegmentTree(int n) {
			tree = new int[4*n];
		}

		// 세그먼트 트리 노드값 초기화
		void init(int node, int s, int e){
			if(s == e)													// 리프노드면
				tree[node] = num[s];
			else {
				int mid = (s + e) / 2;
				init(2*node, s, mid);
				init(2*node+1, mid+1, e);
				tree[node] = tree[2*node] * tree[2*node+1];
			}
		}

		// 주어진 구간에 있는 요소들의 곱을 구하는 쿼리
		int query(int node, int s, int e, int l, int r) {
			if(r<s || e<l)												// 구간 밖이면 1 리턴
				return 1;
			if(l<=s && e<=r)
				return tree[node];
			int mid = (s + e) / 2;
			int left = query(node*2, s, mid, l, r);
			int right = query(node*2+1, mid+1, e, l, r);
			return left * right;
		}

		// 세그먼트 트리 값 변경
		void update(int node, int s, int e, int index, int value) {
			if(index<s || e<index)
				return;
			if(s == e) { 												// 리프노드면
				num[index] = value; 									// 값 변경하고
				tree[node] = value; 									// 부호값 업뎃
			}
			else {
				int mid = (s + e) / 2;
				update(node*2, s, mid, index, value);
				update(node*2+1, mid+1, e, index, value);
				tree[node] = tree[node*2] * tree[node*2+1];
			}
		}
	}
}