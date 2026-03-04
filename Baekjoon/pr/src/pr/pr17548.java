import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr17548 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		String input = br.readLine();
		// e 개수 세기
		int sum = 0;
		for(int i=0; i<input.length(); i++) {
			char tmp = input.charAt(i);
			if(tmp == 'e')
				sum += 1;
		}
		sb.append("h");
		for(int i=0; i<2*sum; i++)
			sb.append("e");
		sb.append("y");
		//출력
		System.out.print(sb.toString().trim());
	}
}