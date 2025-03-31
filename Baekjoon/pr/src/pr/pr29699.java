import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr29699 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		// 출력
		String s = "WelcomeToSMUPC";
		System.out.print(s.charAt((n-1) % 14));
	}
}