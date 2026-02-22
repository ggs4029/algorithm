// 백준 7469번
// 현정이가 자료 구조 프로젝트로 새로운 자료 구조를 만들었음.
// 배열 a에 n개의 서로 다른 수가 저장되어 있고 q(i, j ,k) 함수를 만듬.
// 그 함수는 배열 a[i ~ j]를 정렬했을 때, k번째 수를 리턴하는 함수임.
// 배열 a와 q함수를 호출한 횟수가 주어지면, 각 함수의 리턴값을 출력하는 문제.
// 방법---------------------
// 첫 줄에 배열의 크기 n과 q함수 호출 횟수 m이 한 줄에 주어짐.
// 다음 줄에 배열에 포함된 정수가 순서대로 주어짐.
// 그 다음 줄부터 m줄에 걸쳐 q함수에 사용된 i, j, k가 한 줄씩 주어진다.
// 세그먼트 트리 클래스를 만들고 메소드 구현해 풀이.
// k보다 작거나 같은 수의 개수를 세기 -> 부분 수열에 대해 정렬 -> 이분탐색
// 노드로 나눠서 미리 정렬해두기 -> 머지소트트리 사용
// 미리 정렬된 노드에서 k보다 작거나 같은 수 개수 세고 k번째 값을 출력.
// 오답노트------------------
// num배열에 숫자를 인덱스 1부터 채워넣었기 때문에
// 걍 정렬 때리면 인덱스 0이 비어있어서 문제 있음.
// 범위 정해서 1 ~ n+1 정렬해야함.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class pr7469 {
	public static int[] num;
	public static int[] num2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력1
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		num = new int[n+1];
		num2 = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++)
			num[i] = Integer.parseInt(st.nextToken());
		num2 = num.clone();
		// 트리 생성과 초기화
		MergeTree sTree = new MergeTree(n);
		sTree.init(1, 1, n);
		// 정렬
		Arrays.sort(num2, 1, n+1);
		while(m-- > 0) {
			// 입력2
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			// 이분탐색으로 k번째 수 찾기
			int left = 1;
			int right = n;
			int output = 0;
			while(left <= right) {
				int mid = (left + right) / 2;
				if(sTree.query(1, 1, n, i, j, num2[mid])>=k) {
					output = num2[mid];
					right = mid - 1;
				}
				else
					left = mid + 1;
			}
			sb.append(output).append("\n");
		}
		// 출력
		System.out.print(sb.toString().trim());
	}

	// 머지소트 트리 클래스
	public static class MergeTree {
		public int[][] tree;

		// 트리 높이
		MergeTree(int n) {
			tree = new int[4*n][];
		}

        // 머지소트 트리 노드값 초기화
        public void init(int node, int start, int end){
        	if(start == end)													// 리프노드면
        		tree[node] = new int[]{num[start]};
        	else {
        		int mid = (start + end) / 2;
        		init(2*node, start, mid);
        		init(2*node+1, mid+1, end);
        		tree[node] = new int[end-start+1];
        		int l = 0;
        		int r = 0;
        		int tmp = 0;
        		int[] left = tree[2*node];
        		int[] right = tree[2*node+1];
        		while(l<left.length && r<right.length) {
        			if(left[l] <= right[r])
        				tree[node][tmp++] = left[l++];
        			else
        				tree[node][tmp++] = right[r++];
        		}
        		while(l < left.length)
        			tree[node][tmp++] = left[l++];
        		while(r < right.length)
        			tree[node][tmp++] = right[r++];
			}
		}

		// 주어진 구간에 있는 요소들 중 k보다 작거나 같은 수의 개수 찾기
        public int query(int node, int start, int end, int l, int r, int k) {
        	if(r<start || end<l)												// 구간 밖이면
        		return 0;
        	if(l<=start && end<=r) {
        		int[] num2 = tree[node];
        		int tmp = Arrays.binarySearch(num2, k);							// k가 있으면
        		if(tmp >= 0) {
        			while(tmp<num2.length && num2[tmp]<=k)
        				tmp++;
        			return tmp;
        		}
        		else															// k가 없으면
        			return -(tmp + 1);
        	}
			int mid = (start + end) / 2;
			int left = query(2*node, start, mid, l, r, k);
			int right = query(2*node+1, mid+1, end, l, r, k);
			return left + right;
		}
	}
}