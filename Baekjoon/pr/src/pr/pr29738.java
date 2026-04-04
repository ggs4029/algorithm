import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr29738 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			int n = Integer.parseInt(br.readLine());
			// 출력
			System.out.print("Case #" + (i + 1) + ": ");
			if(n > 4500)
				System.out.println("Round 1");
			else if(n > 1000)
				System.out.println("Round 2");
			else if(n > 25)
				System.out.println("Round 3");
			else
				System.out.println("World Finals");
		}
	}
}