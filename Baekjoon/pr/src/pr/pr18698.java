import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr18698 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			// 입력
			String input = br.readLine();
			int sum = 0;
			for(int j=0; j<input.length(); j++) {
				if(input.charAt(j) == 'D')
					break;
				sum++;
			}
			// 출력
			System.out.println(sum);
		}
	}
}