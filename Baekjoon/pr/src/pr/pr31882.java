// 백준 31882번
// 문자열이 주어지면 근수 점수를 출력하는 문제
// 방법---------------------
// 첫번째 줄에 문자열의 길이 n을 입력 받고
// 다음 줄에 길이 n인 문자열 s를 입력 받는다.
// for문을 돌며 문자열에서 근수 점수를 계산해 출력
// 2가 늘어남에 따라 늘어나는 근수 점수를 일반화하여 풀었음.
// 주의! - for문을 나왔어도 마지막에 sum에 한번 더해줘야함 (마지막이 2로 끝난경우때문)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr31882 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		long n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		// 근수 점수 계산
		long sum = 0;
		long count = 0;
		for(int i=0; i<n; i++) {
			if(s.charAt(i)=='2') {									// 2면 count
				count++;
			}
			else {													// 2가 끊기면 점수 계산
				if(count>0) {
					sum = sum + (count * (count+1) * (count+2))/6;	// 근수 점수 일반화
					count = 0;										// 초기화
				}
			}
		}
		// 마지막이 2인 경우
		if(count>0) {
			sum = sum + (count * (count+1) * (count+2))/6;
			count = 0;
		}
		// 출력
		System.out.print(sum);
	}
}