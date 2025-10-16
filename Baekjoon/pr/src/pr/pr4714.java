import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr4714 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		double x = Double.parseDouble(br.readLine());
		while(x != -1) {
			double y = x * 0.167;
			// 출력
			System.out.println("Objects weighing " + String.format("%.2f", x) + " on Earth will weigh " + String.format("%.2f", y) + " on the moon.");
			x = Double.parseDouble(br.readLine());
		}
	}
}