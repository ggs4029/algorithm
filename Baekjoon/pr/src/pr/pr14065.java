import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr14065 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		double n = Double.parseDouble(br.readLine());
		// 출력
		System.out.print(100 / (1.609344 / 3.785411784 * n));
	}
}