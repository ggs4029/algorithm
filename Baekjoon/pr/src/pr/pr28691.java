import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr28691 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String input = br.readLine();
		// 출력
		if(input.equals("M"))
			System.out.print("MatKor");
		else if(input.equals("W"))
			System.out.print("WiCys");
		else if(input.equals("C"))
			System.out.print("CyKor");
		else if(input.equals("A"))
			System.out.print("AlKor");
		else
			System.out.print("$clear");
	}
}