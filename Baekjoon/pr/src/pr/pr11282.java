import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr11282 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		// n번째 글자 구하기
		n += 44031;
		// 출력
		System.out.print((char) n);
	}
}