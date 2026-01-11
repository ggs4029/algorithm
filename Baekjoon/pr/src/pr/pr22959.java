// 백준 22959번
// 길이 n인 수열 a1 ~ an이 주어지면
// 두가지 쿼리에 대해 계산하고 답을 출력하는 문제.
// 쿼리내용은 문제 참조.
// 방법---------------------
// 첫 줄에 수의 개수 n이 주어짐.
// 그 다음 줄에 수열의 원소가 n개 주어짐.
// 다음 줄에 쿼리 개수 m이 주어지고
// 다음 줄부터 m줄에 걸쳐 쿼리를 입력 받음.
// 세그먼트 트리 클래스를 만들어 사용.
// 쿼리가 1인 경우 - 차이 값을 더하는 방법으로 세그 트리 노드 값 변경
// 쿼리가 2인 경우 - 왼, 오 경계 구하는 이분탐색 메소드를 둘 다 만들고
//				구간 합 구하는 메소드도 만들고 구한 경계 사이에서 구간합의 최대 값을 구해 출력

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr22959 {
	public static int n, m;
    public static long[] num;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력1
		int n = Integer.parseInt(br.readLine());
		num = new long[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++)
			num[i] = Long.parseLong(st.nextToken());
		// 트리 생성하고 초기화
		SegmentTree sTree = new SegmentTree(n);
		sTree.init(num, 1, 1, n);
		// 입력2
		m = Integer.parseInt(br.readLine());
		for(int k=0; k<m; k++) {
			st = new StringTokenizer(br.readLine());
			int q = Integer.parseInt(st.nextToken());							// 쿼리
			int i = Integer.parseInt(st.nextToken());
			long j = Long.parseLong(st.nextToken());
			// 쿼리 처리
			// 1번 쿼리 - 단일 노드 값 업뎃
			if(q == 1)
				sTree.update(1, 1, n, i, j);
			// 2번 쿼리 - 조건을 만족하는 구간 합의 최댓값 구하기
			else {
				int l = sTree.leftBinary(1, 1, n, 1, i, j);
				int r = sTree.rightBinary(1, 1, n, i, n, j);
				sb.append(sTree.sum(1, 1, n, l, r)).append("\n");
			}
		}
		// 출력
		System.out.print(sb.toString().trim());
	}

	// 세그먼트 트리 클래스
	public static class SegmentTree {
		long[] treeSum;															// 구간 합 저장용
		long[] treeMin;															// 구간 최솟값 저장용

		// 세그 트리 전체 노드 수 계산
		SegmentTree(int n) {
			treeSum = new long[4*n];
			treeMin = new long[4*n];
		}

		// 세그 트리 노드값 초기화
		void init(long[] num, int node, int s, int e) {
			if(s == e) {														// 리프노드면
				treeSum[node] = num[s];
				treeMin[node] = num[s];
			}
			else {																// 리프노드 아니면
				int mid = (s + e) / 2;
				init(num, node*2, s, mid);
				init(num, node*2+1, mid+1, e);
				treeSum[node] = treeSum[node*2] + treeSum[node*2+1];
				treeMin[node] = Math.min(treeMin[node*2], treeMin[node*2+1]);
			}
		}

		// 차이 값을 더하는 방법을 사용한 세그먼트 트리 노드 값 변경
		void update(int node, int s, int e, int index, long diff) {
			if(s <= index && index <= e) {
				if(s == e) {													// 리프노드면
					treeSum[node] = diff;
					treeMin[node] = diff;
				}
				else {															// 리프노드 아니면
					int mid = (s + e) / 2;
					update(node*2, s, mid, index, diff);
					update(node*2+1, mid+1, e, index, diff);
					treeSum[node] = treeSum[node*2] + treeSum[node*2+1];
					treeMin[node] = Math.min(treeMin[node*2], treeMin[node*2+1]);
				}
			}
		}

		// 구간 합 구하기
		long sum(int node, int s, int e, int l, int r) {
			if(r<s || e<l)
				return 0;
			if(l<=s && e<=r)
				return treeSum[node];
			int mid = (s + e) / 2;
			return sum(node*2, s, mid, l, r)
					+ sum(node*2+1, mid+1, e, l, r);
		}

		// 이분 탐색을 이용해 왼쪽 범위 찾기 - 1 ~ i에서 j 미만인 값 중 제일 오른쪽 값
		int leftBinary(int node, int s, int e, int l, int r, long j) {
			int left;
			if(r<s || e<l || treeMin[node]>=j)									// 범위 밖
				return l;
			if(s == e)
				return s + 1;
			// 이분탐색
			int mid = (s + e) / 2;
			int tmp = leftBinary(node*2+1, mid+1, e, l, r, j);
			if(tmp != l)
				left = tmp;
			else
				left = leftBinary(node*2, s, mid, l, r, j);
			return left;
		}

		// 이분 탐색을 이용해 오른쪽 범위 찾기 - i ~ n에서 j 미만인 값 중 제일 왼쪽 값
		int rightBinary(int node, int s, int e, int l, int r, long j) {
			int right;
			if(r<s || e<l || treeMin[node]>=j)									// 범위 밖
				return r;
			if(s == e)
				return s - 1;
			// 이분탐색
			int mid = (s + e) / 2;
			int tmp = rightBinary(node*2, s, mid, l, r, j);
			if(tmp != r)
				right = tmp;
			else
				right = rightBinary(node*2+1, mid+1, e, l, r, j);
			return right;
		}
	}
}