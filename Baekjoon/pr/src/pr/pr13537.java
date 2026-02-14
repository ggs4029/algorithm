// 백준 13537번
// 길이가 n인 수열이 주어지면 쿼리를 수행하는 문제.
// 쿼리 하나를 수행하는 문제.
// i j k -> ai ~ aj로 이루어진 부분 수열에서 k보다 큰 원소 개수 출력.
// 방법---------------------
// 첫 줄에 수열의 크기 n이 주어짐.
// 둘쨰 줄에 수열의 요소들이 한 줄에 주어짐.
// 셋째 줄에 쿼리의 개수 m이 주어지고
// 다음 줄부터 m줄에 걸쳐 쿼리가 주어짐.
// 세그먼트 트리 클래스를 만들고 메소드 구현해 풀이.
// k보다 큰 원소의 개수를 세기 -> 부분 수열에 대해 정렬 필요
// 노드로 나눠서 미리 정렬해두기 -> 머지소트트리 사용
// 미리 정렬된 노드에서 k보다 큰 원소 개수 세서 출력.
// 오답노트1-----------------
// 머지소트 트리 쓰겠다고 미리 정렬해둬놓고
// 정작 트리 클래스 안에 k보다 큰 원소 개수 찾는 쿼리메소드에서
// k를 찾는 방식을 for문으로 나이브하게 해버리면 정렬해둔 의미가 없음. (굳이 정렬 안해놔도 할 수 있는 짓)
// 정렬 해놨으면 이분탐색으로 k보다 큰 숫자가 첨 나올때까지 돌리고
// 그 수부터 좌르륵 개수 찾는 코드로 쿼리메소드 수정하기.
// 오답노트2-----------------
// Arrays.binarySearch(num2, k)에서
// num2에 k가 없으면 -(삽입될 위치 + 1)이 반환된다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class pr13537 {
	public static int[] num;
	public static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력1
		int n = Integer.parseInt(br.readLine());
		num = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++)
			num[i] = Integer.parseInt(st.nextToken());
		// 트리 생성과 초기화
		MergeTree sTree = new MergeTree(n);
		sTree.init(1, 1, n);
		// 입력2
		int m = Integer.parseInt(br.readLine());
		while(m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			// 쿼리 처리
			sb.append(sTree.query(1, 1, n, i, j, k)).append("\n");
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

		// 주어진 구간에 있는 요소들 중 k보다 큰 값의 개수 찾기
        public int query(int node, int start, int end, int l, int r, int k) {
        	if(r<start || end<l)												// 구간 밖이면
        		return 0;
        	if(l<=start && end<=r) {
        		int[] num2 = tree[node];
        		int tmp = Arrays.binarySearch(num2, k);							// k가 있으면
        		if(tmp >= 0) {
        			while(tmp<num2.length && num2[tmp]<=k)
        				tmp++;
        			return num2.length - tmp;
        		}
        		else															// k가 없으면
        			return num2.length + tmp + 1;
        	}
			int mid = (start + end) / 2;
			int left = query(2*node, start, mid, l, r, k);
			int right = query(2*node+1, mid+1, end, l, r, k);
			return left + right;
		}
	}
}