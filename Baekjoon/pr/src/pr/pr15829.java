// 백준 15829번
// 문제에서 주어진 해시함수를 이용해 입력 받은 문자열을 해시 값으로 출력하는 문제
// 방법---------------------
// 해시 함수에서 r은 31 M은 1234567891라고 문제에서 주어짐.
// 첫 줄에 문자열의 길이 L을 입력 받음
// 다음 줄에 문자열을 입력 받음(영문 소문자로만 구성)
// 문제에서 주어진대로 해시값을 구하고 출력
// 주의! - L값이 커지는 경우 Math.pow() 사용하기보다 반복문 사용해 매번 r^i값을 갱신하며 계산해야함
//		+ 모듈러 연산을 이용해 모든 계산에서 결과가 항상 M보다 작게

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr15829 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int L = Integer.parseInt(br.readLine());
		int r = 31;
		long M = 1234567891;
		long output = 0;						// 출력할 해시 값
		String input = br.readLine();
		// 해시 계산
		long ri = 1; 							// r^i 값, 초기값은 r^0 = 1 임
		for(int i=0; i<L; i++) {
			int tmp = input.charAt(i)-'0'-48;	// 알파벳 변환
			output = (output + tmp * ri) % M;	// 해시값 계산
			ri = (ri*r)%M;						// r^i값 갱신
		}
		// 출력
		System.out.print(output);
	}
}