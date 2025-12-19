import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr6841 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			// 입력
			String input = br.readLine();
			// 출력
			if(input.equals("CU"))
				System.out.println("see you");
            else if(input.equals(":-)"))
            	System.out.println("I’m happy");
            else if(input.equals(":-("))
            	System.out.println("I’m unhappy");
            else if(input.equals(";-)"))
            	System.out.println("wink");
            else if(input.equals(":-P"))
            	System.out.println("stick out my tongue");
            else if(input.equals("(~.~)"))
            	System.out.println("sleepy");
            else if(input.equals("TA"))
            	System.out.println("totally awesome");
            else if(input.equals("CCC"))
            	System.out.println("Canadian Computing Competition");
            else if(input.equals("CUZ"))
            	System.out.println("because");
            else if(input.equals("TY"))
            	System.out.println("thank-you");
            else if(input.equals("YW"))
            	System.out.println("you’re welcome");
            else if(input.equals("TTYL")) {
                System.out.println("talk to you later");
                return;
            }
            else
            	System.out.println(input);
		}
	}
}