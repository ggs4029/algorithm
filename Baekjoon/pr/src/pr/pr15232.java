import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr15232 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		int r = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());
		// 사각형 만들기
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++)
				sb.append('*');
			sb.append('\n');
		}
		// 출력
		System.out.print(sb.toString().trim());
	}
}