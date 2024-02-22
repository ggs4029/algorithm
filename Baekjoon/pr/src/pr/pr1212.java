// 백준 1212번
// 8진수 2진수
// 8진수를 입력 받아 2진수로 바꿔 출력하기
// 방법---------------------
// 8진수를 입력 받고 2진수로 변환해 출력
// 8진수 한자리 = 2진수 세자리 이므로
// 8진수(0~7)에 맞는 2진수를 if문을 이용해 출력
// 시간초과에 유의해 StringBuilder를 사용
// 출력할때 수가 0인 경우를 제외하고는 반드시 1이되도록 주의

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr1212 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		String input = br.readLine();
		// 8진수 -> 2진수로 변환
		for(int x=0; x<input.length(); x++) {
			int n = input.charAt(x)-'0';
			if(n==0)
				sb.append("000");
			else if(n==1)
				sb.append("001");
			else if(n==2)
				sb.append("010");
			else if(n==3)
				sb.append("011");
			else if(n==4)
				sb.append("100");
			else if(n==5)
				sb.append("101");
			else if(n==6)
				sb.append("110");
			else if(n==7)
				sb.append("111");
		}
		// 출력
		if(input.equals("0"))						// 입력이 0인 경우
			System.out.print("0");
		else {
			for(int x=0; x<sb.length(); x++) {
				if(sb.charAt(x)=='0')				// 1이 나올때까지 출력x
					continue;
				else {								// 1이 나오면 출력하고 break
					System.out.print(sb.substring(x));
					break;
				}
			}
		}
	}
}