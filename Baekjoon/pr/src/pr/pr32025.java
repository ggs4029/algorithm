import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr32025 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int h = Integer.parseInt(br.readLine());
		int w = Integer.parseInt(br.readLine());
		// 출력
		System.out.println(Math.min(h * 100, w * 100) / 2);
	}
}