import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr34665 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String a = br.readLine();
		String b = br.readLine();
		// 출력
		if(a.equals(b))
			System.out.print(0);
		else
			System.out.print(1550);
	}
}