import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr32652 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		int k = Integer.parseInt(br.readLine());
		// 부분 문자열 추가
		for(int i=0; i<k; i++) {
			sb.append("AKA");
			sb.append("R");
		}
		sb.append("AKA");
		// 출력
		System.out.print(sb.toString().trim());
	}
}