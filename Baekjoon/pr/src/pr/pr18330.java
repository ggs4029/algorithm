import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr18330 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine()) + 60;
		// 출력
		if(n <= k)
			System.out.print(n * 1500);
		else
			System.out.print(k * 1500 + (n - k) * 3000);
	}
}