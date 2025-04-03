// 백준 1252번
// 이진수 두 개 입력받아 더하는 문제.
// 방법---------------------
// 첫 줄에 두 개의 이진수가 주어짐.
// 이진수 십진수로 바꾸고 더한 뒤 다시 이진수로 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class pr1252 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		BigInteger a = new BigInteger(st.nextToken(), 2);
		BigInteger b = new BigInteger(st.nextToken(), 2);
		// 출력
		System.out.print(a.add(b).toString(2));
	}
}