import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr14581 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String input = br.readLine();
		// 출력
		System.out.println(":fan::fan::fan:");
		System.out.println(":fan::"+ input + "::fan:");
		System.out.print(":fan::fan::fan:");
	}
}