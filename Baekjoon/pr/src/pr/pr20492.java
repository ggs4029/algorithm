import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr20492 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		// 출력
		int output1 = (int)(n * 0.78);
		int output2 = n - (int)((n * 0.2) * 0.22);
		System.out.println(output1);
		System.out.print(output2);
	}
}