import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr24083 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		// 시침 위치 구하기
		int output = (a+b) % 12;
		// 출력
		if(output%12 == 0)
			System.out.print(12);
		else
			System.out.print(output);
	}
}