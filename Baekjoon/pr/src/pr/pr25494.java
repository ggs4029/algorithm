import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr25494 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			// 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			// 조건 만족하는 정수쌍 찾기
			int output = 0;
			for(int j=1; j<=a; j++) {
				for(int k=1; k<=b; k++) {
					for(int l=1; l<=c; l++) {
						if((j%k)==(k%l) && (k%l)==(l%j))
							output++;
					}
				}
			}
			sb.append(output).append("\n");
		}
		// 출력
		System.out.println(sb.toString().trim());
	}
}