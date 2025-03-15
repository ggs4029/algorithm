import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr3733 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		while(true) {
			String input = br.readLine();
            if(input == null)
            	break;
			StringTokenizer st = new StringTokenizer(input);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(b/(a+1)).append("\n");
		}
		// 출력
		System.out.print(sb.toString().trim());
	}
}