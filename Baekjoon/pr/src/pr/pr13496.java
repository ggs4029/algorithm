import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr13496 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int k = Integer.parseInt(br.readLine());
		for(int i=1; i<=k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			// 이동 가능한 최댓값 구하기
			int max = s * d;
			long output = 0;
			for(int j=0; j<n; j++) {
				st = new StringTokenizer(br.readLine());
				int dist = Integer.parseInt(st.nextToken());
				int value = Integer.parseInt(st.nextToken());
				if(dist <= max)
					output += value;
			}
			// 출력
			System.out.println("Data Set " + i + ":");
			System.out.println(output);
			System.out.println();
		}
	}
}