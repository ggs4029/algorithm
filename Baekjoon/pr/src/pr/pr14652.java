import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr14652 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		// 자리 찾기
		int output = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				// 출력
				if(k == output)
					System.out.print(i+ " " + j);
				output++;
			}
		}
	}
}