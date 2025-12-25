import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr19572 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int z = Integer.parseInt(st.nextToken());
		double a = (x + y - z) / 2.0;
		double b = (x + z - y) / 2.0;
		double c = (y + z - x) / 2.0;
		// 비를 내릴수 있는지 구하기
		if(a<=0 || b<=0 || c<=0)						// 비 못내리면
			sb.append(-1);
		else {											// 비 내릴수 있으면
			sb.append(1).append("\n");
			sb.append(a + " " + b + " " + c);
		}
		// 출력
		System.out.print(sb.toString().trim());
	}
}