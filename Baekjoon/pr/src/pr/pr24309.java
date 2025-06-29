import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class pr24309 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		BigInteger a = new BigInteger(br.readLine());
		BigInteger b = new BigInteger(br.readLine());
		BigInteger c = new BigInteger(br.readLine());
		// 계산
		b = b.subtract(c);
		b = b.divide(a);
		// 출력
		System.out.print(b);
	}
}