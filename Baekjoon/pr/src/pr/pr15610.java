import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr15610 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		long a = Long.parseLong(br.readLine());
		// 출력
		System.out.print(Math.sqrt(a) * 4);
	}
}