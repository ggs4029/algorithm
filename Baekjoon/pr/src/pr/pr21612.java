import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr21612 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int b = Integer.parseInt(br.readLine());
		int output = (5 * b) - 400;
		// 출력
		System.out.println(output);
		if(output == 100)
			System.out.print("0");
		else if(output < 100)
			System.out.print("1");
		else if(output > 100)
			System.out.print("-1");
	}
}