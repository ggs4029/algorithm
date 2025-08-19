import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr10987 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int sum = 0;
		String input = br.readLine();
		for(int i=0; i<input.length(); i++) {
			char tmp = input.charAt(i);
			if(tmp=='a' || tmp=='e' || tmp=='i' || tmp=='o' || tmp=='u')
				sum++;
		}
		// 출력
		System.out.print(sum);
	}
}