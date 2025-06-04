import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr27889 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String input = br.readLine();
		// 약칭 판별
		String output = "";
		if(input.equals("NLCS"))
			output = "North London Collegiate School";
		else if(input.equals("BHA"))
			output = "Branksome Hall Asia";
		else if(input.equals("KIS"))
			output = "Korea International School";
		else
			output = "St. Johnsbury Academy";
		// 출력
		System.out.print(output);
	}
}