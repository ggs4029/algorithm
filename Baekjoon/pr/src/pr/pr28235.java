import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr28235 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		String input = st.nextToken();
		// 출력
		if(input.equals("SONGDO"))
				System.out.print("HIGHSCHOOL");
		else if(input.equals("CODE"))
			System.out.print("MASTER");
		else if(input.equals("2023"))
			System.out.print("0611");
		else if(input.equals("ALGORITHM"))
			System.out.print("CONTEST");
	}
}