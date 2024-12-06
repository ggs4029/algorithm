// 백준 2246번
// 각 콘도의 바닷가에서의 거리와 숙박비에 대한 정보가 주어졌을 때, 후보 콘도의 개수를 구해내는 문제
// 1. X보다 바닷가에 더 가까운 콘도들은 모두 X보다 숙박비가 더 비싸다.
// 2. X보다 숙박비가 더 싼 콘도들은 모두 X보다 바닷가에서 더 멀다.
// 방법---------------------
// 첫 줄에 콘도의 개수 n이 입력으로 주어짐.
// 다음 줄부터 n줄에 걸쳐 콘도와 바닷가로부터의 거리 d와 숙박비 c가 매 줄마다 주어짐.
// 주어진 조건을 for문으로 비교해가며 후보 콘도인지 검사하고 결과를 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr2246 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		int[][] condo = new int[n][2];
		for(int i=0; i<n; i++) {
			String[] input = br.readLine().split(" ");
			condo[i][0] = Integer.parseInt(input[0]);
			condo[i][1] = Integer.parseInt(input[1]);
		}
		// 후보 콘도 개수 구하기
		int output = 0;
		boolean tmp = true;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(i==j)
					continue;
				if(condo[i][0]>=condo[j][0] && condo[i][1]>=condo[j][1])
					tmp = false;
			}
			if(tmp)
				output++;
			else
				tmp = true;
		}
		// 출력
		System.out.print(output);
	}
}