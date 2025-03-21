import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr15780 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		// 멀티탭에 몇명 꽂을수 있는지
		long sum = 0;
		for(int i=0; i<k; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if(tmp%2 == 1)
				sum += (tmp+1)/2;
			else
				sum += tmp/2;
		}
		// 출력
		if(sum >= n)
			System.out.print("YES");
		else
			System.out.print("NO");
	}
}