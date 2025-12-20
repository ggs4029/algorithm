import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr28290 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String input = br.readLine();
		// 출력
		if(input.equals("fdsajkl;") || input.equals("jkl;fdsa"))
			System.out.print("in-out");
		else if(input.equals("asdf;lkj") || input.equals(";lkjasdf"))
			System.out.print("out-in");
		else if(input.equals("asdfjkl;"))
			System.out.print("stairs");
		else if(input.equals(";lkjfdsa"))
			System.out.print("reverse");
		else
			System.out.print("molu");
	}
}