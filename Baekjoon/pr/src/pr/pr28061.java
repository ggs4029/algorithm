import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr28061 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		int lemon = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			int tmp = Integer.parseInt(st.nextToken()) - n + i;
			if(lemon < tmp)
				lemon = tmp;
		}
		// 출력
		System.out.print(lemon);
	}
}