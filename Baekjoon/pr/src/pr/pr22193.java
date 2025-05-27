import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class pr22193 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		String input1 = br.readLine();
		String input2 = br.readLine();
		// 곱하기
		BigInteger a = new BigInteger(input1);
		BigInteger b = new BigInteger(input2);
		// 출력
		System.out.print(a.multiply(b));
	}
}