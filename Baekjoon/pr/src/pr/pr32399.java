// 백준 32399번
// 문자열 이동 문제 - 햄버거 정렬
// 방법--------------------
// if문으로 0 1 2 출력

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr32399 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String input = br.readLine();
		// 출력
		if (input.equals("(1)")) {
            System.out.print(0);
        } else if (input.equals("1)(") || input.equals(")(1") || input.equals("()1") || input.equals("1()")) {
            System.out.print(1);
        } else {
            System.out.print(2);
        }
	}
}

