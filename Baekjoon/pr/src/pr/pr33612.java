import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr33612 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		// 출력
		if(n == 1)
			System.out.print("2024 8");
		else if(n == 2)
			System.out.print("2025 3");
		else if(n == 3)
			System.out.print("2025 10");
		else if(n == 4)
			System.out.print("2026 5");
		else
			System.out.print("2026 12");
	}
}