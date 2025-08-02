import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class pr30664 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		BigInteger a = new BigInteger(st.nextToken());
		while(a.compareTo(BigInteger.valueOf(0)) != 0) {
			// 출력
			if(a.remainder(BigInteger.valueOf(42)).compareTo(BigInteger.valueOf(0)) == 0)
				System.out.println("PREMIADO");
			else
				System.out.println("TENTE NOVAMENTE");
			st = new StringTokenizer(br.readLine());
			a = new BigInteger(st.nextToken());
		}
	}
}