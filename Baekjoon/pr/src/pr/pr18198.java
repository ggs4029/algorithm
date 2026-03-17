import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr18198 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String input = br.readLine();
		// 승자 출력
		System.out.print(input.charAt(input.length() - 2));
	}
}