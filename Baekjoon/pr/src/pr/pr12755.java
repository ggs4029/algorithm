// 백준 12755번
// 1부터 숫자를 쭉 이어 붙일 때 그 문자열의 n번째 숫자를 구하는 문제.
// 방법---------------------
// 첫 줄에 n을 입력 받음.
// n까지 숫자들 자릿수 더해가며 순회.
// 초과된 길이 조심해서 뒷자리수 제거하고 마지막 숫자 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr12755 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		// n번째 숫자 구하기
		int sum = 0;									// 현재 문자열 길이
		int i = 0;
		for(i=1; sum<n; i++) {
			int len = 0;								// 자릿수 더해 저장할 변수
			for(int j=i; j>0; j/=10)
				len++;									// 자릿수 더하기
			sum += len;
		}
		sum -= n;
		i--;
		for(int j=0; j<sum; j++)						// 초과된 길이만큼 자릿수 빼기
			i /= 10;
		// 출력
		System.out.print(i%10);
	}
}