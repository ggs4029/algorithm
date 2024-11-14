import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr26074 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input = br.readLine().split(" ");
		// 출력
		if(Integer.parseInt(input[0])*Integer.parseInt(input[1])==2)
			System.out.print("ChongChong");
		else
			System.out.print("GomGom");
	}
}