import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr11121 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s1 = st.nextToken();
			String s2 = st.nextToken();
			// 문자열 비교
			if(s1.equals(s2))
				sb.append("OK").append("\n");
			else
				sb.append("ERROR").append("\n");
		}
		// 출력
		System.out.print(sb.toString().trim());
	}
}