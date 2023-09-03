// 백준 11653번
// N을 소인수분해하는 문제
// 방법-----------------
// N을 입력 받고
// 2부터 시작해 소인수분해를 시작한다.
// 소인수 분해 결과를 한줄에 하나씩 출력하기위해 while문을 사용한다.
// N이 1이될때까지 반복하고 1이되면 출력을 멈춘다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr11653 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		// 소인수분해
		while(true) {
			if(n==1) // n이 1이 되면 출력을 멈춤
				break;
			for(int x=2; x<=n; x++) {
				if(n%x==0) { // 나눈 나머지가 0이면
					System.out.println(x);
					n = n/x;
					break;
				}
			}
		}

	}
}