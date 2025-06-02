import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr21300 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		long output = 0;
		for(int i=0; i<6; i++)
			output += Long.parseLong(st.nextToken());
		// 출력
		System.out.print(output * 5);
	}
}