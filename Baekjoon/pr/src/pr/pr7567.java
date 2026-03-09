import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr7567 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String bowl = br.readLine();
		// 그릇 높이 구하기
		int output = 10;
		char tmp = bowl.charAt(0);
		for(int i=1; i<bowl.length(); i++){
			if(tmp != bowl.charAt(i)){				// 전꺼랑 방향 다르면
				tmp = bowl.charAt(i);
				output += 10;
			}
			else									// 전꺼랑 똑같은 방향이면
				output += 5;
		}
		// 출력
		System.out.print(output);
	}
}