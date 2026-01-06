import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr16727 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int p1 = Integer.parseInt(st.nextToken());
		int s1 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int s2 = Integer.parseInt(st.nextToken());
		int p2 = Integer.parseInt(st.nextToken());
		// 골 수 비교해서 출력
		int p = p1 + p2;
		int s = s1 + s2;
		if(p > s)
			System.out.print("Persepolis");
		else if(s > p)
			System.out.print("Esteghlal");
		else {
			if(p2 > s1)
				System.out.print("Persepolis");
			else if(s1 > p2)
				System.out.print("Esteghlal");
			else
				System.out.print("Penalty");
		}
	}
}