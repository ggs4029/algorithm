import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr15059 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ca = Integer.parseInt(st.nextToken());
		int ba = Integer.parseInt(st.nextToken());
		int pa = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int cr = Integer.parseInt(st.nextToken());
		int Br = Integer.parseInt(st.nextToken());
		int pr = Integer.parseInt(st.nextToken());
		// 못먹는 사람 계산하기
		int output = 0;
		if(ca-cr < 0)
			output += cr - ca;
		if(ba-Br < 0)
			output += Br - ba;
		if(pa-pr < 0)
			output += pr - pa;
		// 출력
		System.out.print(output);
	}
}