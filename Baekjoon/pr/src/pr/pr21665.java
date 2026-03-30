import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr21665 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		char[][] image = new char[101][101];
		for(int i=0; i<n; i++)
			image[i] = br.readLine().toCharArray();
		br.readLine();
		char[][] wrong = new char[101][101];
		for(int i=0; i<n; i++)
			wrong[i] = br.readLine().toCharArray();
		// 잘못 반전된 부분 세기
		int output = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(image[i][j] == wrong[i][j])
					output++;
			}
		}
		// 출력
		System.out.print(output);
	}
}