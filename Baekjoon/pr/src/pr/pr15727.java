import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr15727 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int l = Integer.parseInt(br.readLine());
		// 출력
		if(l%5 > 0)
			System.out.print(l / 5 + 1);
		else
			System.out.print(l / 5);
	}
}