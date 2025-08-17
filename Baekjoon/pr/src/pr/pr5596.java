import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr5596 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int sum = 0;
		int sum2 = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++)
			sum += Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++)
			sum2 += Integer.parseInt(st.nextToken());
		// 출력
		if(sum >= sum2)
			System.out.print(sum);
		else
			System.out.print(sum2);
	}
}