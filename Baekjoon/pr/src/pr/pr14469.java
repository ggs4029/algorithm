// 백준 14469번
// 동하가 상점 1에서 a개의 물건을, 지원이가 상점 2에서 b개의 물건을 구입해서
// n종류의 물건을 모두 구매하는 데 필요한 최소 비용을 구하는 문제.
// 방법---------------------
// 첫 줄에 소의 수 n을 입력 받고
// 다음 줄부터 n줄에 걸쳐 소들의 도착 시간과 검문 시간을 한줄에 입력 받음.
// 도착 시간 기준으로 이차원 배열 정렬하고 검문 시간 생각해서 답 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class pr14469 {
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		int cow[][] = new int[n][2];
		for(int i=0; i<n; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			cow[i][0] = Integer.parseInt(st.nextToken());				// 도착 시간
			cow[i][1] = Integer.parseInt(st.nextToken());				// 검문 시간
		}
		// 정렬
		Arrays.sort(cow, (x, y)-> x[0] - y[0]);
		// 최소시간 구하기
		int output = 0;
		for(int i=0; i<n; i++){
			if(output<cow[i][0])
				output = cow[i][0] + cow[i][1];
			else
				output += cow[i][1];
		}
		// 출력
		System.out.print(output);
	}
}