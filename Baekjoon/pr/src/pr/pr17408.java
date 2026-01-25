// 백준 17408번
// 길이가 n인 수열이 주어지면 쿼리를 수행하는 문제.
// 쿼리에는 두가지가 있고 문제 참조.
// 수열의 인덱스는 1부터 시작함.
// 방법---------------------
// 첫 줄에 수열의 크기 n이 주어짐.
// 둘쨰 줄에 수열의 요소들이 한 줄에 주어짐.
// 셋째 줄에 쿼리의 개수 m이 주어지고
// 다음 줄부터 m줄에 걸쳐 쿼리가 주어짐.
// 세그먼트 트리 클래스를 만들고 메소드 구현해 푸링.
// 1번 쿼리를 해결 -> update메소드
// 2번쿼리 = l ≤ i < j ≤ r을 만족하는 모든 Ai + Aj 중에서 최댓값 출력하기
// 두 값을 더한 최댓값을 구하려면 l~r 구간에서 제일 큰 두 값을 찾아야함.
// -> 노드 클래스가 이 두 값을 가질거임.
// -> 세그트리에 노드로 이걸 저장.
// 만들어진 트리에서 max메소드 사용해 구간에서 제일 큰 값(ai)랑 다음으로 큰 값(aj)을 비교를 통해 구해서 출력.
// 오답노트------------------
// 널포인트 에러 -> 전역변수로 설정한 num 놔두고 main메소드 안에서 long[]으로 num 지역변수로 다시 선언해서 씀.
// 세그 트리 클래스에서도 num에 접근하므로 전역변수로 둬야함.
// 오답노트2-----------------
// 리프 노드에는 값이 하나만 저장됨.
// node에 두 값 중 하나만 채우면 됨(value)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr17408 {
	public static long[] num;
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
		// 입력2
		int m = Integer.parseInt(br.readLine());
		while(m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int input = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			// 쿼리 처리
			// 1번 쿼리 - 값 변경
			if(input == 1)
				sTree.update(1, 1, n, l, r);
			// 2번 쿼리 - l~r 구간에서 두 수의 합의 최댓값 찾기
			else {
				SegmentTree.Node node = sTree.query(1, 1, n, l, r);
				sb.append(node.x + node.y).append("\n");
			}
		}
		// 출력
		System.out.print(sb.toString().trim());
	}

	// 세그먼트 트리 클래스
	public static class SegmentTree {
		public Node[] tree;

		// 트리 높이
		SegmentTree(int n) {
			tree = new Node[4*n];
		}

		// 구간 최대값 담을 노드 클래스
        public static class Node {
            long x;
            long y;

            Node(long x, long y) {
                this.x = x;
                this.y = y;
            }
        }

		// 세그먼트 트리 노드값 초기화
		public void init(int node, int start, int end){
			if(start == end)												// 리프노드면
				tree[node] = new Node(num[start], 0);
			else {
				int mid = (start + end) / 2;
				init(2*node, start, mid);
				init(2*node+1, mid+1, end);
				tree[node] = max(tree[2*node], tree[2*node+1]);
			}
		}

		// 세그먼트 트리 값 변경
		public void update(int node, int start, int end, int index, long value) {
			if(start == end)												// 리프노드면
				tree[node] = new Node(value, 0);							// 값이 하나만 있음
			else {
				int mid = (start + end) / 2;
				if(start<=index && index<=mid)
					update(2*node, start, mid, index, value);
				else
					update(2*node+1, mid+1, end, index, value);
				tree[node] = max(tree[2*node], tree[2*node+1]);
			}
		}

		// 주어진 구간에 있는 요소들 중 최댓값 찾기
		public Node query(int node, int start, int end, int l, int r) {
			if(r<start || end<l)											// 구간 밖이면 0으로 채운 노드 반환
				return new Node(0, 0);
			if(l<=start && end<=r)
				return tree[node];
			int mid = (start + end) / 2;
			Node left = query(2*node, start, mid, l, r);
			Node right = query(2*node+1, mid+1, end, l, r);
			return max(left, right);
		}

		// 구간 내 최댓값인 Ai, Aj 구하는 메소드
        public Node max(Node l, Node r) {
        	long ai;
        	long aj;
        	ai = Math.max(l.x, r.x);
        	if(ai == l.x)													// 왼구간 x가 제일크면
        		aj = Math.max(l.y, r.x);
        	else															// 오른구간 x가 제일크면
        		aj = Math.max(l.x, r.y);
        	return new Node(ai, aj);
        }
	}
}