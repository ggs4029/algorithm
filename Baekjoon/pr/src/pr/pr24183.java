import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr24183 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = 229 * 324 * Integer.parseInt(st.nextToken()) * 2;
		int b = 297 * 420 * Integer.parseInt(st.nextToken()) * 2;
		int c = 210 * 297 * Integer.parseInt(st.nextToken());
		// 출력
		System.out.print((a + b + c) * 0.000_001);
	}
}