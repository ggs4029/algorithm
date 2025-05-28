import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr30979 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int t = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sum = 0;
		for(int i=0; i<n; i++)
			sum += Integer.parseInt(st.nextToken());
		// 출력
		if(sum >= t)
			System.out.print("Padaeng_i Happy");
		else
			System.out.print("Padaeng_i Cry");
	}
}