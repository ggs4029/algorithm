import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr18312 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		// k가 포함되는 시각들의 수 구하기
		int output = 0;
		for(int i=0; i<=n; i++) {
			for(int j=0; j<=59; j++) {
				for(int l=0; l<=59; l++) {
					if(i/10==k || i%10==k || j/10==k || j%10==k || l/10==k || l%10==k)	// k 있으면
						output++;
				}
			}
		}
		// 출력
		System.out.print(output);
	}
}