import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr34346 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		// 출력
		if(n%2 != 0)
			System.out.print(1);
		else
			System.out.print(2);
	}
}