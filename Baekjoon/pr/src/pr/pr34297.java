import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr34297 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int m = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());
		// 출력
		System.out.print(m*c);
	}
}