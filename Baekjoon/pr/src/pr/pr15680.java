// 백준 15680번
// 연세대학교의 영문명은 YONSEI, 슬로건은 Leading the Way to the Future이다.
// 이를 출력하는 프로그램을 작성
// 방법---------------------
// 첫 줄에 n이 입력으로 주어짐.
// n이 0 이면 연세대 영문명 출력.
// 1이면 슬로건 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr15680 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		long n = Long.parseLong(br.readLine());
		// 출력
		if(n==0)
			System.out.print("YONSEI");
		else
			System.out.print("Leading the Way to the Future");
	}

}