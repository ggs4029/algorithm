import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr6778 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int x = Integer.parseInt(br.readLine());
		int y = Integer.parseInt(br.readLine());
		// 출력
		if(x>=3 && y<=4)
			System.out.print("TroyMartian");
		if(x<=6 && y>=2)
			System.out.print("VladSaturnian");
		if(x<=2 && y<=3)
			System.out.print("GraemeMercurian");
	}
}