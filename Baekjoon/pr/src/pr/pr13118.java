import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr13118 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] man = new int[4];
		man[0] = Integer.parseInt(st.nextToken());
		man[1] = Integer.parseInt(st.nextToken());
		man[2] = Integer.parseInt(st.nextToken());
		man[3] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		// 사과 맞을 사람 수 구하고 출력
		int output = 0;
		for(int i=0; i<4; i++) {
			if(man[i] == x) {
				System.out.print(i + 1);
				output++;
				break;
			}
		}
		if(output == 0)
			System.out.print(output);
	}
}