import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr8545 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		String input = br.readLine();
		sb.append(input);
		sb = sb.reverse();
		// 출력
		System.out.print(sb.toString().trim());
	}
}