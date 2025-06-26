import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr10808 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		String input = br.readLine();
		int[] num = new int[26];
		for(int i=0; i<input.length(); i++) {
			char tmp = input.charAt(i);
			num[tmp - 97]++;
		}
		// 출력
		for(int i=0; i<26; i++)
			sb.append(num[i]).append("\n");
		System.out.print(sb.toString().trim());
	}
}