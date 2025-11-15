import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr30999 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		// 출제 문제 수 구하기
		int output = 0;
		for(int i=0; i<n; i++) {
			String input = br.readLine();
			int sum = 0;
			for(int j=0; j<m; j++) {
				char tmp = input.charAt(j);
				if(tmp == 'O')
					sum++;
			}
			if(sum > (m/2))
				output++;
		}
		sb.append(output).append("\n");
		// 출력
		System.out.print(sb.toString().trim());
	}
}