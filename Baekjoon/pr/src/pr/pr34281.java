import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr34281 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int w = Integer.parseInt(br.readLine());
		int l = Integer.parseInt(br.readLine());
		// 출력
		System.out.print(w*l);
	}
}