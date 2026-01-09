import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr27159 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		int[] num = new int[36];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			num[Integer.parseInt(st.nextToken())] = 1;
		// 점수 계산
		int sum = 0;
		for(int i=3; i<36; i++) {
			if(num[i]!=0 && num[i-1]==0)
				sum += i;
		}
		// 출력
		System.out.print(sum);
	}
}