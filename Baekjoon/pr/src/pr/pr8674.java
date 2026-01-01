import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr8674 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		long[] chocolate = new long[2];
		StringTokenizer st = new StringTokenizer(br.readLine());
		chocolate[0] = Long.parseLong(st.nextToken());
		chocolate[1] = Long.parseLong(st.nextToken());
		// 출력
		if(chocolate[0]%2==0 || chocolate[1]%2==0)					// 둘 중 하나라도 짝수면
			System.out.print(0);
		else														// 둘 다 홀수면
			System.out.print(Math.min(chocolate[0], chocolate[1]));
	}
}