import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr19602 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());
		// 출력
		if(a + b*2 + c*3 >= 10)
			System.out.print("happy");
		else
			System.out.print("sad");
	}
}