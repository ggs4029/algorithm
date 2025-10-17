import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr9094 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			// 정수쌍 개수 구하기
			int output = 0;
			for(int i=1; i<n; i++) {
				for(int j=i+1; j<n; j++) {
					if((i * i + j * j + m) % (i * j) == 0)
						output++;
				}
			}
			// 출력
			System.out.println(output);
		}
	}
}