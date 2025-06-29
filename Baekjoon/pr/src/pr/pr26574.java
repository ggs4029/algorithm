import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr26574 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			int tmp = Integer.parseInt(br.readLine());
			sb.append(tmp + " " + tmp).append("\n");
		}
		// 출력
		System.out.print(sb.toString().trim());
	}
}