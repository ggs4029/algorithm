// 백준 17939번
// 주식 최대 수익 구하는 그리디 알고리즘 문제.
// 구매는 1분에 하나만 가능하고 판매는 몇 개든 할수 있음.
// 거래 수수료x.
// 방법---------------------
// 첫 줄에 제한 시간 n이 주어지고
// 다음 줄에 매 분마다의 코인 가격이 한 줄에 주어진다.
// 끝에서부터 순회하면서 코인의 최대값 업뎃해가며
// 차액 더해 출력.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr17939 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		int[] num = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			num[i] = Integer.parseInt(st.nextToken());
		// 최대 수익 구하기
		long output = 0;
		int tmp = 0;							// 최대값 업뎃할 변수
		for(int i=n-1; i>=0; i--) {
			if(num[i] > tmp)
				tmp = num[i];
			else
				output += tmp - num[i];
		}
		// 출력
		System.out.print(output);
	}
}