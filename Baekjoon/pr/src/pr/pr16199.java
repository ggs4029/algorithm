import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr16199 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int y = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int y2 = Integer.parseInt(st.nextToken());
		int m2 = Integer.parseInt(st.nextToken());
		int d2 = Integer.parseInt(st.nextToken());
		// 나이 구하고 출력
		if(m < m2)
			System.out.println(y2 - y);
		else if(m==m2 && d<=d2)
			System.out.println(y2 - y);
		else
			System.out.println(y2 - y -1);
		System.out.println(y2 - y + 1);
		System.out.print(y2 - y);
	}
}