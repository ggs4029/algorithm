import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr27219 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		// 출력
		for(int i=0; i<n/5 ; i++)
			System.out.print("V");
		for(int i=0; i<n%5; i++)
			System.out.print("I");
	}
}