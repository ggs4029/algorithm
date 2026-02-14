import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr6784 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		char[] student = new char[n];
		for(int i=0; i<n; i++)
			student[i] = br.readLine().charAt(0);
		int output = 0;
		for(int i=0; i<n; i++) {
			char answer = br.readLine().charAt(0);
			// 정답 비교
			if (student[i] == answer)
				output++;
		}
		// 출력
		System.out.print(output);
	}
}