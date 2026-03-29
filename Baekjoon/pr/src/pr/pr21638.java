import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr21638 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t1 = Integer.parseInt(st.nextToken());
		int v1 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int t2 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		// 출력
		if(t2<0 && v2>=10)
			System.out.print("A storm warning for tomorrow! Be careful and stay home if possible!");
		else if(t1 > t2)
			System.out.print("MCHS warns! Low temperature is expected tomorrow.");
		else if(v1 < v2)
			System.out.print("MCHS warns! Strong wind is expected tomorrow.");
		else
			System.out.print("No message");
	}
}