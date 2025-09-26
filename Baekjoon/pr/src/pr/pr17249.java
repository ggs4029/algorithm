import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr17249 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String input = br.readLine();
		// 왼 오 잔상 개수 구하기
		int left = 0;
		int right = 0;
		boolean dir = false;
		for(int i=0; i<input.length(); i++) {
			char tmp = input.charAt(i);
			if(tmp == '0')						// 중간
				dir = true;
			if(!dir) {
				if(tmp == '@')
					right++;
			}
			else {
				if(tmp == '@')
					left++;
			}
		}
		// 출력
		System.out.print(right + " " + left);
	}
}