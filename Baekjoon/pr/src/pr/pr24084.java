import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr24084 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		int n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		// j인지 검사
		for(int i=0; i<n-1; i++) {
			if(s.charAt(i+1) == 'J')
				sb.append(s.charAt(i)).append("\n");
		}
		// 출력
		System.out.print(sb.toString().trim());
	}
}