import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr24883 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String input = br.readLine();
		// 출력
		if(input.equals("N") || input.equals("n"))
			System.out.print("Naver D2");
		else
			System.out.print("Naver Whale");
	}
}