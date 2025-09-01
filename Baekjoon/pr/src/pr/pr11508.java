// 백준 11508번
// 유제품 2+1 행사를 하고 있음.
// 3개를 사면 가장 싼거는 무료고 나머지 두개 가격만 지불하면 되는 방식.
// 3개 안사면 정가내야함.
// 친구들과 같이 먹을 총 n개의 유제품을 구입해야 함.
// n개의 유제품의 가격이 주어지면 구입할 때 최소비용을 출력.
// 방법---------------------
// 첫 줄에 유제품의 개수 n을 입력 받고
// 그 다음 줄부터 n줄에 걸쳐 유제품들의 가격을 입력 받음.
// 입력 받은 유제품들 가격순으로 정렬하고
// 맨 뒤부터 제일비싼거 두개씩 계산하고 그 다음꺼는 건너뛰는 식으로 순회.
// 최소비용 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class pr11508 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		int[] num = new int[n];
		for(int i=0; i<n; i++)
			num[i] = Integer.parseInt(br.readLine());
		// 정렬
		Arrays.sort(num);
		// 최소비용 구하기
		int output = 0;
		for(int i=n-1; i>=0; i-=3) {
			// 비싼거 두개만 계산
			output += num[i];					// 제일비싸너
			if(i-1 >= 0)
				output += num[i-1];				// 그다음꺼
		}
		// 출력
		System.out.print(output);
	}
}