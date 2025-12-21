import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr31495 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String input = br.readLine();
		// 출력
		if(input.charAt(0)=='"' && input.charAt(input.length()-1)=='"' && input.length()>2)
			System.out.print(input.substring(1, input.length()-1));
		else
			System.out.print("CE");
	}
}