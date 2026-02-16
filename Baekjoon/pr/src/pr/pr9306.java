import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr9306 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			// 입력
			String first = br.readLine();
			String last = br.readLine();
			// 출력
			System.out.println("Case " + (i + 1) + ": " + last + ", " + first);
		}
	}
}