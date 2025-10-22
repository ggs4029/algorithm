import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class pr18411 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int[] exam = new int[3];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<3; i++)
			exam[i] = Integer.parseInt(st.nextToken());
		// 정렬
		Arrays.sort(exam);
		// 출력
		System.out.print(exam[2] + exam[1]);
	}
}