import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr30455 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		// 출력
		if(n%2 == 1)
			System.out.print("Goose");
		else
			System.out.print("Duck");
	}
}