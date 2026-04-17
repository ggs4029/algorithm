import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr33964 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		// 레퓨닛 구하기
		long repu_x = 0;
		long repu_y = 0;
		for(int i=0; i<x; i++)
			repu_x = repu_x * 10 + 1;
		for(int i=0; i<y; i++)
			repu_y = repu_y * 10 + 1;
		// 출력
		System.out.print(repu_x + repu_y);
	}
}