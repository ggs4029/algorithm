import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr9610 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		int q1 = 0;
		int q2 = 0;
		int q3 = 0;
		int q4 = 0;
		int output = 0;
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			// 사분면 판별
			if(x==0 || y==0)				// 축에 있는 경우
				output++;
			else if(x > 0) {
				if(y > 0)					// 1사분면
					q1++;
				else						// 4사분면
					q4++;
			}
			else if(x < 0) {
				if(y > 0)					// 2사분면
					q2++;
				else						// 3사분면
					q3++;
			}
		}
		// 출력
		System.out.println("Q1: " + q1);
		System.out.println("Q2: " + q2);
		System.out.println("Q3: " + q3);
		System.out.println("Q4: " + q4);
		System.out.print("AXIS: " + output);
	}
}