import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr26068 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int output = 0;
		for(int i=0; i<n; i++) {
			// 입력
			String[] input = br.readLine().split("-");
			// 판별
			if(Integer.parseInt(input[1]) <= 90)
				output++;
		}
		// 출력
		System.out.print(output);
	}
}