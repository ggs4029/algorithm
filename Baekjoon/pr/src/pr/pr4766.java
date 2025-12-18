import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr4766 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double t = Double.parseDouble(br.readLine());
		while(true) {
			// 입력
			double input = Double.parseDouble(br.readLine());
			if(input == 999)
				break;
			// 출력
			System.out.println(String.format("%.2f", input - t));
			t = input;
		}
	}
}