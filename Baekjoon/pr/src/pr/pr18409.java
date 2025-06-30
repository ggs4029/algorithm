import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr18409 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		String input = br.readLine();
		int sum = 0;
		for(int i=0; i<n; i++) {
			switch(input.charAt(i)) {
			case 'a': case 'i': case 'u': case 'e': case 'o':
				sum++;
			}
		}
		// 출력
		System.out.print(sum);
	}
}