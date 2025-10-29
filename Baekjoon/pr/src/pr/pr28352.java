import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr28352 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		long n = Long.parseLong(br.readLine());
		// n! 구하기
		long output = 1;
		for(int i=1; i<=n; i++)
			output *= i;
		// 출력
		System.out.print(output / (7 * 24 * 60 * 60));
	}
}