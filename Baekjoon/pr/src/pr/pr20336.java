import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr20336 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int d = Integer.parseInt(st.nextToken());
		// 요리 개수랑 이름 추가
		sb.append(d).append("\n");
		for(int i=0; i<d; i++)
			sb.append(st.nextToken()).append("\n");
		// 출력
		System.out.print(sb.toString().trim());
	}
}