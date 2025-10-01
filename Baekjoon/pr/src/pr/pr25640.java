import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr25640 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String input = br.readLine();
		int n = Integer.parseInt(br.readLine());
		int output = 0;
		for(int i=0; i<n; i++) {
			if(input.equals(br.readLine()))
				output++;
		}
		// 출력
		System.out.print(output);
	}
}