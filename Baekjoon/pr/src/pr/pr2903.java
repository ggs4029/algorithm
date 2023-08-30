// 백준 2903번
// 중앙 이동 알고리즘 ( 점 개수 구하기)
// 문제에서 주어진 법칙에 따라
// N번 실행시의 점의 개수를 출력하는 문제
// 방법--------------------------
// 초기 상태 - 점 4개이고 문제에서 주어진 법칙으로
// 일반항을 구하면 점의 개수는 (2^N+1)^2개 이다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr2903 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 문자열 입력받기
		int N = Integer.parseInt(br.readLine());
		// 최종 출력
		int result = (int)((Math.pow(2, N)+1)*(Math.pow(2, N)+1));
		System.out.print(result);
	}
}