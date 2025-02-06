// 백준 10025번
// 앨버트가 가장 적은 거리만 움직이고도 최대한 많은 얼음으로 더위를 식힐 수 있도록 도와주는 문제.
// 우리 안은 1차원 배열로 생각.
// 총 n개의 얼음 양동이들이 좌표에 늘어져있고, 각 양동이안에 g씩 얼음이 들어 있음.
// 앨버트가 최적의 자리를 골랐을 때 얼음의 합을 구하기.
// 즉, 얼음들의 합의 최댓값을 구해야 한다.
// 앨버트는 자기 자리에서 좌우 k 범위안에 있는 양동이 회수 가능.
// 방법---------------------
// 첫 줄에 얼음 양동이의 개수 n과 앨버트의 사정거리 k가 주어짐.
// 다음 줄부터 각 양동이의 얼음의 양 g와 양동이의 좌표 x가 주어짐.
// 누적합 구하고 슬라이딩 윈도우로 탐색해서 얼음 양 최댓값 구하고 출력.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr10025 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] ice = new int[1_000_000+1];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int g = Integer.parseInt(st.nextToken());			// 얼음 양
			int x = Integer.parseInt(st.nextToken());			// 양동이 좌표
			ice[x] = g;
		}
		// 회수 가능한 얼음 양 최대값 구하기
		long output = 0;
		long[] add = new long[1_000_000+1];						// 누적합 저장할 배열
		add[0] = ice[0];
		for(int i=1; i<=1_000_000; i++)
			add[i] = add[i-1] + ice[i];
		if(k>500_000)
			output = add[1_000_000];
		else
			output = add[2*k] - add[0] + ice[0];
		for(int i=k+1; i<=1_000_000-k; i++)
			output = Math.max(output, add[i+k] - add[i-k-1]);
		// 출력
		System.out.print(output);
	}
}