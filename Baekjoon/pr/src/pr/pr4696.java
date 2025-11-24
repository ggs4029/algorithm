import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr4696 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			// 입력
			double n = Double.parseDouble(br.readLine());
			if(n == 0)
				break;
			double output = 0;
			output += n;
			output += n * n;
			output += n * n * n;
			output += n * n * n * n;
			output += 1;
			// 출력
			System.out.println(String.format("%.2f", output));
		}
	}
}