import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr17598 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력 + 투표
		int tiger = 0;
		int lion = 0;
		for(int i=0; i<9; i++) {
			String input = br.readLine();
			if(input.equals("Tiger"))
				tiger++;
			else if(input.equals("Lion"))
				lion++;
		}
		// 출력
		if(tiger > lion)
			System.out.print("Tiger");
		else
			System.out.print("Lion");
	}
}