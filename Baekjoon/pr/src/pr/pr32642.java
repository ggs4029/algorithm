import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr32642 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		long rage = 0;
		long output = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			// 분노의 합 구하기
			if(tmp == 1)
				rage++;
			else
				rage--;
			output += rage;
		}
		// 출력
		System.out.print(output);
	}
}