import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr34362 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		double n = Double.parseDouble(br.readLine());
		// 출력
		System.out.print(n - 0.3);
	}
}