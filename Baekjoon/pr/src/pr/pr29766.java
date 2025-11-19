import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr29766 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String input = br.readLine();
		// 출력
		System.out.print((input.length() - input.replace("DKSH", "").length()) / 4);
	}
}