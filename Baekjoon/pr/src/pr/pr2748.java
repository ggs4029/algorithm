import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr2748 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		// 피보나치 수 구하기
		long[] fibo = new long[n+1];
		fibo[0] = 0;
		fibo[1] = 1;
		for(int i=2; i<=n; i++)
			fibo[i] = fibo[i-1] + fibo[i-2];
		// 출력
		System.out.print(fibo[n]);
	}
}