import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr20528 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		String p1 = st.nextToken();
		// 글자 비교
		char first = p1.charAt(0);									// 첫 단어의 첫 문자
		boolean output = true;
		for(int i=1; i<n; i++) {
			String tmp = st.nextToken();
			if(tmp.charAt(0) != first) {
				output = false;
				break;
			}
		}
		// 출력
		if(output)
			System.out.print(1);
		else
			System.out.print(0);
	}
}