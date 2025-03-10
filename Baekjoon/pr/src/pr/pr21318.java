// 백준 21318번
// n개의 악보를 가지고 있고 각 악보는 난이도를 가지고 있음.
// 순서대로 악보들을 피아노로 칠 때, 지금 연주하는 악보가 바로 다음에 연주할 악보보다 어려우면 실수를 함.
// 마지막 악보에서는 실수를 안 할 때, 오늘 할 피아노 연주에서 실수를 몇번하는지 세는 문제.
// 방법---------------------
// 첫 줄에 악보 개수 n 입력 받고
// 두번째 줄에 악보들의 난이도가 한 줄에 주어짐.
// 세번째 줄에 질문 개수 q가 주어지고
// 다음 q줄에 걸쳐 연주를 할 악보의 범위 x, y가 한줄씩 주어짐.
// 실수할지 안할지 판별해서 실수 누적합 배열 구하고
// 질문 받은 범위 실수 개수 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr21318 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] piano = new int[n+1];
		for(int i=1; i<=n; i++)
			piano[i] = Integer.parseInt(st.nextToken());
		int[] mistake = new int[n+1];
		for(int i=1; i<=n-1; i++) {
			if(piano[i] > piano[i+1])
				mistake[i] = 1;									// 1 = 실수
			else
				mistake[i] = 0;									// 0 = 실수안함
		}
		// 실수 누적합 구하기
		int[] sum = new int[n+1];
		sum[1] = mistake[1];
		for(int i=2; i<=n-1; i++)
			sum[i] = sum[i-1] + mistake[i];
		// 질문 받고 답 구하기
		int q = Integer.parseInt(br.readLine());
		for(int i=0; i<q; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if (x == y)
				sb.append("0").append("\n");
			else {
                if(x > 1)
                	sb.append(sum[y-1] - sum[x-1]).append("\n");
                else
                	sb.append(sum[y-1]).append("\n");
			}
		}
		// 출력
		System.out.print(sb.toString().trim());
	}
}