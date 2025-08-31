import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr5524 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
            String tmp = br.readLine();
            sb.append(tmp.toLowerCase()).append("\n");
        }
		// 출력
        System.out.print(sb.toString().trim());
	}
}