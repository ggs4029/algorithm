import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr10870 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		// 피보나치 수 구하기
		long[] fibo = new long[21];
		fibo[0] = 0; fibo[1] = 1;
		for(int i=2; i<fibo.length; i++)
			fibo[i] = fibo[i-1] + fibo[i-2];
		// 출력
		System.out.print(fibo[n]);
	}
}