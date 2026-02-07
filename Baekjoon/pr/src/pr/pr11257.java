import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr11257 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String code = st.nextToken();
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			// 총점 구하기
			int sum = 0;
			sum = x + y + z;
			System.out.print(code + " " + sum + " ");
			// 시험 결과 구하기
			if(sum >= 55) {
				if(x>=35*0.3 && y>=25*0.3 && z>=40*0.3)
					System.out.println("PASS");
				else
					System.out.println("FAIL");
			}
			else
				System.out.println("FAIL");
		}
	}
}