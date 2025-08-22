import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr30822 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		String input = br.readLine();
		// 알파벳 개수 세기
		int[] sum = new int[5];					// 순서대로 u o s p c 개수 저장
		for(int i=0; i<n; i++) {
			if(input.charAt(i) == 'u')
				sum[0]++;
			if(input.charAt(i) == 'o')
				sum[1]++;
			if(input.charAt(i) == 's')
				sum[2]++;
			if(input.charAt(i) == 'p')
				sum[3]++;
			if(input.charAt(i) == 'c')
				sum[4]++;
		}
		// 출력
		System.out.print(Math.min(sum[0], Math.min(sum[1], Math.min(sum[2], Math.min(sum[3], sum[4])))));
	}
}