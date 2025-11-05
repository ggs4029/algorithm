import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr30501 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			String input = br.readLine();
			// 출력
			if(input.contains("S"))
				System.out.print(input);
		}
	}
}