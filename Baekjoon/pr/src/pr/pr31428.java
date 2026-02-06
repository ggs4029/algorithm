import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr31428 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		String[] s = new String[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			s[i] = st.nextToken();
		String h = br.readLine();
		// 지원자 수 구하기
		int output = 0;
		for(int i=0; i<n; i++) {
			if(s[i].equals(h))
				output++;
		}
		// 출력
		System.out.print(output);
	}
}