import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr17863 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String input = br.readLine();
		// 출력
		if(input.indexOf("555") == 0)
			System.out.print("YES");
		else
			System.out.print("NO");
	}
}