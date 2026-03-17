import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr17912 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int output = 0;
		int min = Integer.MAX_VALUE;
		for(int i=0; i<n; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			// 최솟값 갯ㅇ신하기
			if(tmp < min) {
				min = tmp;
				output = i;
			}
		}
		// 출력
		System.out.print(output);
	}
}