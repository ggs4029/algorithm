// 백준 1790번
// 1부터 N까지의 수를 이어서 쓴 새로운 하나의 수에서
// 앞에서 k번째 자리 숫자가 어떤 숫자인지 구하는 문제.
// 방법---------------------
// 첫 줄에 n과 k를 입력 받음.
// for문으로 자릿수를 늘려가며 k번째 숫자를 찾는다.
// k가 범위 안인지 확인하고 숫자를 찾아 k번째 숫자만 출력.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr1790 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		// k번째 자리 숫자 구하기
		int digits = 1;								// 현재 자릿수
		int sum = 0;								// 계산한 자릿수의 총합
		for(int i=1; i<=8; i++) {
			int tmp = 9 * digits;					// 현재 자릿수의 숫자가 몇개인지
			if(sum+tmp*i < k) {						// k가 현재 자릿수 구간에 없는지
				sum += tmp * i;
				digits *= 10;
				continue;							// 없으면 다음 자릿수로
			}
			int tmp2 = digits + (k - sum - 1) / i;	// k번째 자리가 포함된 숫자
			// 출력
			if(tmp2 > n)							// 이 숫자가 n보다 크면 범위 초과
				System.out.print(-1);
			else {
				char output = String.valueOf(tmp2).charAt((k - sum - 1)%i);
				System.out.print(output);
			}
			return;
		}
		// k<=9인 경우
		if(k-sum <= 9) {
		    if(k-sum == 0)
		        System.out.print(1);
		    else
		        System.out.print(0);
		}
		else
		    System.out.print(-1);
	}
}