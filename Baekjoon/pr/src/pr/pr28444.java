import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr28444 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input = br.readLine().split(" ");
		int h = Integer.parseInt(input[0]);
		int i = Integer.parseInt(input[1]);
		int a = Integer.parseInt(input[2]);
		int r = Integer.parseInt(input[3]);
		int c = Integer.parseInt(input[4]);
		// 출력
		System.out.print(h*i - a*r*c);
	}
}