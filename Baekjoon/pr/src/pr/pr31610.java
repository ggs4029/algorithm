import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr31610 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int x = Integer.parseInt(br.readLine());
		int y = Integer.parseInt(br.readLine());
		int z = Integer.parseInt(br.readLine());
		// 출력
		System.out.print(x*y+z);
	}
}