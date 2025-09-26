import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class pr2959 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] num = new int[4];
		for(int i=0; i<4; i++)
			num[i] = Integer.parseInt(st.nextToken());
		// 정렬
		Arrays.sort(num);
		// 출력
		System.out.print(num[0] * num[2]);
	}
}