import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr15873 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		String input = st.nextToken();
		if(input.charAt(1) == '0')
			System.out.print(Integer.parseInt(input.substring(2)) + 10);
		else
			System.out.print(Character.getNumericValue(input.charAt(0)) + Integer.parseInt(input.substring(1)));
	}
}