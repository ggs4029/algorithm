import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class pr9699 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			int[] num = new int[5];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++)
				num[j] = Integer.parseInt(st.nextToken());
			// 정렬
			Arrays.sort(num);
			// 출력
			System.out.print("Case #" + (i+1) + ": ");
			System.out.println(num[4]);
		}
	}
}