import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr13416 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int[] num = new int[3];
		for(int i=0; i<t; i++) {
			// 입력
			int n = Integer.parseInt(br.readLine());
			int output = 0;
			for(int j=0; j<n; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				num[0] = Integer.parseInt(st.nextToken());
				num[1] = Integer.parseInt(st.nextToken());
				num[2] = Integer.parseInt(st.nextToken());
				// 최대 이윤 구하기
				if(num[0]<0 && num[1]<0 & num[2]<0)
					continue;
				output += Math.max(Math.max(num[0], num[1]), num[2]);
			}
			// 출력
			System.out.println(output);
		}
	}
}