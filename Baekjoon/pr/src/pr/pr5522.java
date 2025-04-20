import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr5522 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;
		for(int i=0; i<5; i++) {
			// 입력
			int n = Integer.parseInt(br.readLine());
			sum += n;
		}
		// 출력
		System.out.print(sum);
	}
}