import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr12813 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		String a = br.readLine();
		String b = br.readLine();
		// 비트 연산
		int len = a.length();
		for(int i=0; i<len; i++) {
			boolean boolA = a.charAt(i) == '1';
			boolean boolB = b.charAt(i) == '1';
			if(boolA & boolB)
				sb.append("1");
			else
				sb.append("0");
		}
		sb.append("\n");
		for(int i=0; i<len; i++) {
			boolean boolA = a.charAt(i) == '1';
			boolean boolB = b.charAt(i) == '1';
			if(boolA | boolB)
				sb.append("1");
			else
				sb.append("0");
		}
		sb.append("\n");
		for(int i=0; i<len; i++) {
			boolean boolA = a.charAt(i) == '1';
			boolean boolB = b.charAt(i) == '1';
			if(boolA != boolB)
				sb.append("1");
			else
				sb.append("0");
		}
		sb.append("\n");
		for(int i=0; i<len; i++) {
			boolean boolA = a.charAt(i) == '1';
			if(!boolA)
				sb.append("1");
			else
				sb.append("0");
		}
		sb.append("\n");
		for(int i=0; i<len; i++) {
			boolean boolB = b.charAt(i) == '1';
			if(!boolB)
				sb.append("1");
			else
				sb.append("0");
		}
		// 출력
		System.out.print(sb.toString().trim());
	}
}