import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr32776 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int sab = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ma = Integer.parseInt(st.nextToken());
		int f = Integer.parseInt(st.nextToken());
		int mb = Integer.parseInt(st.nextToken());
		// 출력
		if(sab<=ma+f+mb || sab<=240)
			System.out.print("high speed rail");
		else
			System.out.print("flight");
	}
}