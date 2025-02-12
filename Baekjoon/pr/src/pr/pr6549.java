// 백준 6549번
// 히스토그램에서 가장 넓이가 큰 직사각형을 구하는 문제.
// 방법---------------------
// 입력은 여러 개의 테스트 케이스로 이루어져 있음.
// 각 테스트 케이스는 한 줄이고
// 직사각형의 수 n이 가장 처음으로 주어지고 그 다음 n개의 정수가 주어짐.
// 펜윅트리 클래스 구현해 사용.
// 펜윅 트리 클래스를 사용해 구간 내의 최소 높이를 가진 사각형의 인덱스를 구함.
// 분할정복 메소드 이용해 최소값 기준 좌우 최대 사각형 넓이 구해 비교 후 큰 값 출력.
// 오답노트------------------
// 펜윅 트리 클래스 안에 있는 쿼리 메소드에서
// 시작 인덱스가 구간 밖인 경우를 생각하지 못했음.
// else문으로 구현해 시작 인덱스가 구간 밖이면
// 하나의 구간으로 처리하지말고 하나하나 처리하도록 코드 짬.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr6549 {
	public static int n;
	public static long[] num;
	public static FenwickTree fTree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			// 입력
			String input = br.readLine();
			if(input.equals("0"))
				break;
			StringTokenizer st = new StringTokenizer(input);
			n = Integer.parseInt(st.nextToken());
			num = new long[n+1];
			for(int i=1; i<=n; i++)
				num[i] = Long.parseLong(st.nextToken());
			fTree = new FenwickTree(n);
			fTree.init(num);
			// 최대 직사각형 넓이 구하기
			sb.append(max(1, n)).append('\n');
		}
		// 출력
		System.out.print(sb.toString().trim());
	}

	// 펜윅 트리 클래스
	public static class FenwickTree {
		private int[] tree;

		public FenwickTree(int n) {
			tree = new int[n+1];
		}

		// 펜윅 트리 초기화 메소드
		public void init(long[] num) {
			int n = tree.length - 1;
			for(int i=1; i<=n; i++)
				tree[i] = i;
			// 높이가 최소인 사각형의 인덱스 미리 구하기
			for(int i=1; i<=n; i++) {
				int j = i + (i & -i);
				if(j<=n) {
					if(num[tree[i]] < num[tree[j]])							// 더 작은거
						tree[j] = tree[i];
					else if(num[tree[i]]==num[tree[j]] && tree[i]<tree[j])	// 값이 같으면 더 앞쪽거
						tree[j] = tree[i];
				}
			}
		}

		// 구간에서 최소인 높이를 가진 사각형의 인덱스를 구하는 메소드
		public int query(long[] num, int l, int r) {
			int output = -1;
			long min = Long.MAX_VALUE;
			int i = r;
			while(i>=l) {
				int start = i - (i & -i) + 1;								// 시작 인덱스
				if(start>=l) {												// 구간 안이면
					int tmp = tree[i];										// 이 구간의 최소 사각형 인덱스
					if(output==-1 || num[tmp]<min ||
							(num[tmp]==min && tmp<output)) {
						min = num[tmp];
						output = tmp;
					}
					i = start - 1;											// 구간 처리했으므로 뛰어넘기
				}
				else {														// 구간 밖이면 하나하나 처리
					if(output==-1 || num[i]<min ||
							(num[i]==min && i<output)) {
						min = num[i];
						output = i;
					}
					i--;
				}
			}
			return output;
		}
	}

	// 구간 내 직사각형의 최대 넓이를 구하는 메소드 - 분할정복
	private static long max(int start, int end) {
		if(start>end)
			return 0;
		int min = fTree.query(num, start, end);								// 구간 내 최소 사각형 인덱스
		long tmp = (end - start + 1) * num[min];							// 큰 직사각형
		long left = max(start, min-1);										// 최소값 기준 왼쪽으로 넓이 최댓값 계산
		long right = max(min+1, end);										// 오른쪽으로 넓이 최댓값 계산
		return Math.max(tmp, Math.max(left, right));
	}
}