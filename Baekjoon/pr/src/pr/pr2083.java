import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr2083 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			// 입력
			String tmp = br.readLine();
			if(tmp.equals("# 0 0"))
				break;
			StringTokenizer st = new StringTokenizer(tmp);
			String name = st.nextToken();
			int age = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			sb.append(name).append(' ').append(age>17 || weight>=80 ? "Senior" : "Junior").append("\n");
		}
		// 출력
		System.out.print(sb.toString().trim());
	}
}