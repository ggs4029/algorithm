import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class pr8437 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		BigInteger sum = new BigInteger(br.readLine());
		BigInteger diff = new BigInteger(br.readLine());
		BigInteger tmp = BigInteger.valueOf(2);
        BigInteger a = sum.add(diff).divide(tmp);
        BigInteger b = sum.subtract(diff).divide(tmp);
		// 출력
		System.out.println(a);
		System.out.print(b);
	}
}