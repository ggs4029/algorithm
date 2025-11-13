import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr10480 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			// 입력
			int a = Integer.parseInt(br.readLine());
			// 출력
			if(a%2 == 0)
				System.out.println(a + " is even");
			else
				System.out.println(a + " is odd");
		}
	}
}