import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr34412 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int x = Integer.parseInt(br.readLine());
		// 출력
		if(x >= 13)
			System.out.print(x + 1);
		else
			System.out.print(x);
	}
}