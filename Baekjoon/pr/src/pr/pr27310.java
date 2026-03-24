import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr27310 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String input = br.readLine();
		// 입력 난이도 계산
		int n = 0, m = 0;								// 콜론, 언더바 개수
		for(int i=0; i<input.length(); i++) {
			if(input.charAt(i) == ':')
				n++;
			if(input.charAt(i) == '_')
				m++;
		}
		int level = input.length() + n + m * 5;
		// 출력
		System.out.print(level);
	}
}