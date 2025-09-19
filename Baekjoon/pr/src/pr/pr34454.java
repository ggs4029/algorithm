import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr34454 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());
		int p = Integer.parseInt(br.readLine());
		// 출력
		if(c*p >= n)
			System.out.print("yes");
		else
			System.out.print("no");
	}
}