// 백준 11658번
// N×N개의 수가 N×N 크기의 표에 채워져 있음.
// 중간에 수의 변경이 빈번히 일어나고 그 중간에 어떤 부분의 합을 구하려 하는 문제.
// 방법---------------------
// 첫 줄에 n과 연산 수 m이 주어짐.
// 그 다음 줄부터 n줄에 걸쳐 수들이 한 줄씩 주어짐.
// 그 다음 m줄에 걸쳐 w, x, y, c 나 w, x1, y1, x2, y2를 입력 받고
// w가 0인 경우 (x, y)를 c (1 ≤ c ≤ 1,000)로 바꾸고
// w가 1인 경우에는 (x1, y1)부터 (x2, y2)의 합을 구해 출력.
// 2차원 펜윅 트리 클래스를 구현해 사용.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr11658 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		long[][] num = new long[n+1][n+1];
		long[][] tree = new long[n+1][n+1];
		SegmentTree sTree = new SegmentTree(n);
		for(int i=1; i<=n; i++) {
			String[] input2 = br.readLine().split(" ");
			for(int j=1; j<=n; j++) {
				num[i][j] = Integer.parseInt(input2[j-1]);
				sTree.update(i, j, num[i][j]);
			}
		}
		// 입력2
		for(int i=0; i<m; i++) {
			String[] input3 = br.readLine().split(" ");
			int w = Integer.parseInt(input3[0]);
			int x = Integer.parseInt(input3[1]);
			int y = Integer.parseInt(input3[2]);
			int c = Integer.parseInt(input3[3]);
			// 값 변경 or 구간 합 구하기
			if(w==0) {
				sTree.update(x, y, c-num[x][y]);
				num[x][y] = c;
			}
			else {
				int x2 = c;
				int y2 = Integer.parseInt(input3[4]);
                long output = sTree.sum2(x, y, x2, y2);
                sb.append(output).append("\n");

			}
		}
		// 출력
		System.out.print(sb.toString());
	}

	// 2차원 세그먼트 트리 클래스
	public static class SegmentTree {

		public int n;
		public static long[][] tree;

		// 세그먼트 트리 전체 노드 수 계산
		SegmentTree(int n) {
			this.n = n;
			this.tree = new long[n+1][n+1];
		}

		// 세그먼트 트리에 값 추가
		public void update(int x, int y, long val) {
			while(x<=n) {
				for(int i=y; i<=n; i+=i&-i)
					tree[x][i] += val;
				x += x & -x;
			}
		}

		// 전체 구간 합 구하기
		public long sum(int x, int y) {
			int result = 0;
			while(x>0) {
				for(int i=y; i>0; i-=i&-i)
					result += tree[x][i];
				x -= x & -x;
			}
			return result;
		}

		// 주어진 구간 합 구하기
		public long sum2(int x1, int y1, int x2, int y2) {
			return sum(x2, y2) - sum(x2, y1-1) - sum(x1-1, y2) + sum(x1-1, y1-1);
		}
	}
}