import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr30045 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		int output = 0;
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			// 포함되어 있는지 검사
			if(s.contains("01") || s.contains("OI"))
				output++;
		}
		// 출력
		System.out.print(output);
	}
}