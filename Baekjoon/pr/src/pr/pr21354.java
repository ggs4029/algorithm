import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr21354 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		// 매출 비교하고 출력
		if(a*7 < p*13)
			System.out.print("Petra");
		else if(a*7 == p*13)
			System.out.print("lika");
		else
			System.out.print("Axel");
	}
}