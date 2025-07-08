import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr26489 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int sum = 0;
		while(true) {
			String tmp = br.readLine();
			if(tmp == null)
				break;
			sum++;
		}
		// 출력
		System.out.print(sum);
	}
}