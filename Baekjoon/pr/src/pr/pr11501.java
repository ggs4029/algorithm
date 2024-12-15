// 백준 11501번
// 미래를 내다보는 눈을 가진 홍준이를 도와 최대 이익 출력하기.
// 홍준이가 매일 세가지 행동 중 하나를 함.
// 주식 사거나, 원하는 만큼 가지고 있는 주식 팔거나, 아무것도 안하거나.
// 날 별 주식 가격을 알려주면 최대 이익을 출력.
// 방법---------------------
// 첫 줄에 테스트 케이스의 수 t가 주어짐.
// 테스트 케이스는 두 줄로 이루어져 있음.
// 첫 줄은 날의 수 n과 그 다음 줄에 n개의 주가를 입력 받음.
// 주의 - 최대 이익 구하는 과정에서 앞에서부터 탐색하면 최적의 판매 시점을 알 수 없음.
// 뒤에서부터 탐색해서 최대 이익 구해 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr11501 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t;  i++) {
			// 입력
			int n = Integer.parseInt(br.readLine());
			String[] input = br.readLine().split(" ");
			int[] stock = new int[n];
			for(int j=0; j<n; j++)
				stock[j] = Integer.parseInt(input[j]);
			// 최대 이익 구하기
			long output = 0;
			int tmp = stock[n-1];							// 팔 가격
			for(int j=n-2; j>=0; j--) {
				if(stock[j]<tmp)							// tmp보다 작으면
					output += (tmp - stock[j]);				// 차액 더하기
				else										// 크면
					tmp = stock[j];							// tmp 갱신
			}
			sb.append(output).append("\n");
		}
		// 출력
		System.out.print(sb.toString());
	}
}