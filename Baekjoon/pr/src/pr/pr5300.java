import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr5300 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		for(int i=1; i<=n; i++) {
			System.out.print(i + " ");
			if(i%6 == 0)
				System.out.print("Go! ");
		}
		if(n%6 != 0)
			System.out.println("Go!");
	}
}