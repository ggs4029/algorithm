import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr10203 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			// 입력
			String input = br.readLine();
			// 모음 개수 세기
			int sum = 0;
			for(int j=0; j<input.length(); j++) {
				char tmp = input.charAt(j);
				if(tmp=='a' || tmp=='e' || tmp=='i' || tmp=='o' || tmp=='u')
					sum++;
			}
			// 출력
			System.out.println("The number of vowels in " + input + " is " + sum + ".");
		}
	}
}