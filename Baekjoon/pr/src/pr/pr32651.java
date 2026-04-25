import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr32651 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		// 출력
		if(n<100000 && n%2024==0)
			System.out.print("Yes");
		else
			System.out.print("No");
	}
}