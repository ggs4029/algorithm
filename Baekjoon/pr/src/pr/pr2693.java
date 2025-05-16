import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class pr2693 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		int num[] = new int[10];
		for(int i=0; i<t; i++) {
			// 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<10; j++)
				num[j] = Integer.parseInt(st.nextToken());
			// 정렬
			Arrays.sort(num);
			sb.append(num[7]).append("\n");
		}
		// 출력
		System.out.print(sb.toString().trim());
	}
}