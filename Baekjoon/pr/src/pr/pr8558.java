import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr8558 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		// 1의 자릿수 구하기
		int output = 1;
		for(int i=1; i<=n; i++) {
			output *= i;
			output %= 10;
		}
		// 출력
		System.out.print(output);
	}
}