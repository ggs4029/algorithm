import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class pr11948 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int[] joi = new int[4];
		for(int i=0; i<4; i++)
			joi[i] = Integer.parseInt(br.readLine());
		int e = Integer.parseInt(br.readLine());
		int f = Integer.parseInt(br.readLine());
		// 정렬
		Arrays.sort(joi);
		// 출력
		System.out.print(Math.max(e, f) + joi[3] + joi[2] + joi[1]);
	}
}