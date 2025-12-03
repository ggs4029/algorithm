import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class pr34071 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		int[] num = new int[n];
		for(int i=0; i<n; i++)
			num[i] = Integer.parseInt(br.readLine());
		// 문제 난이도 찾기
		int first = num[0];
		// 정렬
		Arrays.sort(num);
		// 출력
		if(num[0] == first)
			System.out.print("ez");
		else if(num[n-1] == first)
			System.out.print("hard");
		else
			System.out.print("?");
	}
}