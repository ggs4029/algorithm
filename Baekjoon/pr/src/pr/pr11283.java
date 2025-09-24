import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr11283 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String input = br.readLine();
		char output = input.charAt(0);
		// 출력
		System.out.print(output - 44031);
	}
}