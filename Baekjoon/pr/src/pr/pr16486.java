import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr16486 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int d1 = Integer.parseInt(br.readLine());
		int d2 = Integer.parseInt(br.readLine());
		double pi = 3.141592;
		// 출력
        System.out.print(d1 * 2 + 2 * pi * d2);
	}
}