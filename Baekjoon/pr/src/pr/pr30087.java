import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr30087 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		// 출력
		for(int i=0; i<n; i++) {
			String a = br.readLine();
			if(a.equals("Algorithm"))
				System.out.println("204");
			else if(a.equals("DataAnalysis"))
				System.out.println("207");
			else if(a.equals("ArtificialIntelligence"))
				System.out.println("302");
			else if(a.equals("CyberSecurity"))
				System.out.println("B101");
			else if(a.equals("Network"))
				System.out.println("303");
			else if(a.equals("Startup"))
				System.out.println("501");
			else if(a.equals("TestStrategy"))
				System.out.println("105");
		}
	}
}