import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr4564 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			// 입력
			String s = br.readLine();
			if(s.equals("0"))
				break;
			// 숫자 카드놀이 시작
			sb.append(s + " ");
			while(s.length() > 1) {
				long tmp = 1;
				for(int i=0; i<s.length(); i++)
					tmp = tmp * (s.charAt(i) - '0');		// 각 자리수끼리 곱하기
				s = String.valueOf(tmp);
				sb.append(s + " ");
			}
			sb.append("\n");
		}
		// 출력
		System.out.print(sb.toString().trim());
	}
}