import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr27331 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String a = br.readLine();
		String b = br.readLine();
		// 출력
		System.out.print(a+b);
	}
}