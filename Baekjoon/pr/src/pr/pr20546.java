// 백준 20546번
// 준현이와 성민이의 주식 매매법에 의거하여
// 어떤 방법이 수익률이 높은지 맞히는 문제.
// 준현이는 BNP 전략, 성민이는 33매매법 전략 사용.
// 각각의 전략에 대한 자세한 내용은 문제 참조.
// 방법---------------------
// 첫 줄에 둘에게 주어진 현금 money가 주어짐.
// 다음 줄에 14일간의 주가가 한 줄에 주어짐.
// 각자의 전략대로 매수 or 매도하고 수익률을 비교해 결과를 출력.
// 오답노트------------------
// 결과 출력을 성민이 매매법 for문 안에서 하고 있었음.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr20546 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		int[] stock = new int[14];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0 ; i<14 ; i++)
			stock[i] = Integer.parseInt(st.nextToken());
		// 준현이의 전략 - BNP
		int money1 = n;
		int sum1 = 0;
		for(int i=0 ; i<14 ; i++) {
			// 최대한 많이 사기
			if(money1/stock[i] > 0) {
				int tmp = money1 / stock[i];
				sum1 += tmp;
				money1 = money1 - stock[i] * tmp;
			}
		}
		// 성민이의 전략 - 33매매법
		int money2 = n;
		int sum2 = 0;
		for(int i=0 ; i<11 ; i++) {
			// 3일 연속 상승하면 -> 전량 매도
			if((stock[i]<stock[i+1]) && (stock[i+1]<stock[i+2])) {
				if(sum2 != 0) {
					money2 += stock[i+3] * sum2;
					sum2 = 0;
				}
				else
					continue;
			}
			// 3일 연속 하락하면 -> 전량 매수
			else if((stock[i]>stock[i+1]) && (stock[i+1]>stock[i+2])) {
				if(money2/stock[i+3] > 0) {
					int tmp = money2 / stock[i+3];
					sum2 += tmp;
					money2 -= stock[i+3] * tmp;
				}
			}
		}
		// 수익률 비교하고 출력
		int output1 = money1 + stock[13] * sum1;
		int output2 = money2 + stock[13] * sum2;
		if(output1 > output2)
			System.out.print("BNP");
		else if(output1 < output2)
			System.out.print("TIMING");
		else
			System.out.print("SAMESAME");
	}
}