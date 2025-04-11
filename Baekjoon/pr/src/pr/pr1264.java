import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr1264 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		String input;
		while(!(input = br.readLine()).equals("#")) {
			int sum = 0;
			for(int i=0; i<input.length(); i++) {
				char tmp = input.charAt(i);
				// 소문자 혹은 대문자인 모음일 경우 개수를 증가
				if(tmp=='a' || tmp=='e' || tmp=='i' || tmp=='o' || tmp=='u' ||
						tmp=='A' || tmp=='E' || tmp=='I' || tmp=='O' || tmp=='U')
					sum++;
			}
			sb.append(sum).append("\n");
		}
		// 출력
		System.out.print(sb.toString().trim());
	}
}