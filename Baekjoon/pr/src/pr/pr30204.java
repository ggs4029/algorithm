import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr30204 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		// 피자 배급
		st = new StringTokenizer(br.readLine());
		long sum = 0;
		for(int i=0; i<n; i++)
			sum += Long.parseLong(st.nextToken());
		// 출력
		if(sum%x == 0)
			System.out.print(1);
		else
			System.out.print(0);
	}
}