import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr29725 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int output = 0;
		for(int i=0; i<8; i++) {
			// 입력
			String input = br.readLine();
			// 점수 계산
			for(int j=0; j<8; j++) {
				char tmp = input.charAt(j);
				// 백 기물
				if(tmp == 'K')
					output += 0;
				else if(tmp == 'P')
					output += 1;
				else if(tmp=='N' || tmp=='B')
					output += 3;
				else if(tmp == 'R')
					output += 5;
				else if(tmp == 'Q')
					output += 9;
				// 흑 기물
				else if(tmp == 'k')
					output += 0;
				else if(tmp == 'p')
					output -= 1;
				else if(tmp == 'n' || tmp == 'b')
					output -= 3;
				else if(tmp == 'r')
					output -= 5;
				else if(tmp == 'q')
					output -= 9;
			}
		}
		// 출력
		System.out.print(output);
	}
}