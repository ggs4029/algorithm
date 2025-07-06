import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr9316 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		// 문자열 구성
		for(int i=0; i<n; i++)
			sb.append("Hello World, Judge " +(i+1) + "!").append("\n");
		// 출력
		System.out.print(sb.toString().trim());
	}
}