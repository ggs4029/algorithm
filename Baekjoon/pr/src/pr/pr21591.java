import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr21591 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int wc = Integer.parseInt(st.nextToken());
		int hc = Integer.parseInt(st.nextToken());
		int ws = Integer.parseInt(st.nextToken());
		int hs = Integer.parseInt(st.nextToken());
		// 출력
		if(wc-1>ws && hc-1>hs)
			System.out.print("1");
		else
			System.out.print("0");
	}
}