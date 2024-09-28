// 백준 31403번
// 세 정수를 입력 받고 정수 계산과 문자열 계산을 출력하는 문제
// 방법---------------------
// 세줄에 걸쳐 정수 a, b, c를 입력 받고
// 출력 첫 줄에는 a+b-c 출력
// 출력 둘째 줄에는 a, b, c를 문자열로 생각했을 때의 a+b-c 출력

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr31403 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String a = br.readLine();
		String b = br.readLine();
		String c = br.readLine();
		int x = Integer.parseInt(a);
		int y = Integer.parseInt(b);
		int z = Integer.parseInt(c);
		// 출력
		System.out.println(x+y-z);
		System.out.print(Integer.parseInt(a+b)-z);
	}
}