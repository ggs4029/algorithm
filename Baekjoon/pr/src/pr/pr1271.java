// 백준 1271번

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class pr1271 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input = br.readLine().split(" ");
		BigInteger n = new BigInteger(input[0]);
		BigInteger m = new BigInteger(input[1]);
		// 몫나머지 구하기
		BigInteger output1 = n.divide(m);
		BigInteger output2 = n.remainder(m);
		// 결과 출력
		System.out.println(output1);
		System.out.print(output2);
	}
}