import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr26566 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			// 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a1 = Integer.parseInt(st.nextToken());
			int p1 = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int r1 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			int tmp = a1 / p1;
			int tmp2 = (int) (r1 * r1 * Math.PI / p2);
			// 출력
			if(tmp < tmp2)
				System.out.println("Whole pizza");
			else
				System.out.println("Slice of pizza");
		}
	}
}