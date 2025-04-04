import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class pr13908 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int[] num = new int[3];
		for(int i=0; i<3; i++)
			num[i] = Integer.parseInt(br.readLine());
		// 정렬
		Arrays.sort(num);
		// 출력
		System.out.print(num[1]);
	}
}