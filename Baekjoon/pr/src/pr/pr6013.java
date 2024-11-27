// 백준 6013번
// 이차원 평면에 소들이 있을 때 제일 멀리 떨어져 있는 소 두마리의 인덱스를 구하는 문제.
// 방법---------------------
// 첫 줄에 n이 입력으로 주어짐.
// 그 다음 n줄에 걸쳐 소들의 좌표가 주어짐.
// 이중 for문으로 소들의 거리의 제곱을 구해 비교하고
// 제일 큰 값일 때의 소들의 인덱스를 오름차순으로 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr6013 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		int[][] cow = new int[n][2];
		for(int i=0; i<n; i++) {
			String[] input = br.readLine().split(" ");
			cow[i][0] = Integer.parseInt(input[0]);
			cow[i][1] = Integer.parseInt(input[1]);
		}
		// 제일 멀리 떨어진 소 쌍 찾기
		double max = 0;
		int cow1 = 0, cow2 = 0;
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				// 거리 구하기
				double tmp = Math.pow(cow[j][0]-cow[i][0], 2) + Math.pow(cow[j][1]-cow[i][1], 2);
				if(tmp>max) {
					max = tmp;
					cow1 = i + 1;
					cow2 = j + 1;
				}
			}
		}
		// 출력 (오름차순으로)
		if(cow1>cow2)
			System.out.print(cow2 + " " + cow1);
		else
			System.out.print(cow1 + " " + cow2);
	}
}