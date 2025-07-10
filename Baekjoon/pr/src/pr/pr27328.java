import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr27328 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		// 출력
		if(a < b)
			System.out.print(-1);
		else if(a == b)
			System.out.print(0);
		else
			System.out.print(1);
	}
}