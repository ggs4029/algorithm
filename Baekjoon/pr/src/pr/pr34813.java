import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr34813 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String input = br.readLine();
		// 출력
		if(input.charAt(0) == 'F')
			System.out.print("Foundation");
		else if(input.charAt(0) == 'C')
			System.out.print("Claves");
		else if(input.charAt(0) == 'V')
			System.out.print("Veritas");
		else
			System.out.print("Exploration");
	}
}