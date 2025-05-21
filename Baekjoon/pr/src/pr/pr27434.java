import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class pr27434 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		// 출력
		if(n == 1) {
			System.out.print(1);
			return;
		}
		System.out.print(fac(1, n));
	}

	// 팩토리얼 계산 메소드
	public static BigInteger fac(int tmp, int n) {
		BigInteger num = BigInteger.valueOf(tmp);
		if(tmp < n) {
			int tmp2 = (tmp + n) / 2;
			num = fac(tmp, tmp2).multiply(fac(tmp2 + 1, n));
		}
		return num;
	}
}