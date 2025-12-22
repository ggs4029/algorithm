import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr34935 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		long tmp = Long.parseLong(st.nextToken());
		boolean output = true;
		// 같은지 비교
		for(int i=1; i<n; i++) {
			long next = Long.parseLong(st.nextToken());
			if(next == tmp) {
				output = false;
				break;
			}
			tmp = next;
		}
		// 출력
		if(output)
			System.out.print(1);
		else
			System.out.print(0);
	}
}