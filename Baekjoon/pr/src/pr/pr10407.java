// 백준 10407번
// 2 타워
// 방법---------------------
// 2를 짝수번 거듭 제곱한 값을 나누면 무조건 나머지가 1
// 높이 h를 입력 받고 1을 출력 (h==1이면 2출력)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr10407 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String h = br.readLine();
		//출력
		if(h.equals("1"))
			System.out.print(2);
		else
			System.out.print(1);
	}
}