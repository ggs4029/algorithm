import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr20540 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		String input = br.readLine();
		// 이상형 구하기
		for(int i=0; i<4; i++) {
			char tmp = input.charAt(i);
			if(tmp == 'I')
				sb.append("E");
			else if(tmp == 'E')
				sb.append("I");
			else if(tmp == 'N')
				sb.append("S");
			else if(tmp == 'S')
				sb.append("N");
			else if(tmp == 'T')
				sb.append("F");
			else if(tmp == 'F')
				sb.append("T");
			else if(tmp == 'J')
				sb.append("P");
			else
				sb.append("J");
		}
		// 출력
		System.out.print(sb.toString().trim());
	}
}