import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr11800 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] name = {"", "Yakk", "Doh", "Seh", "Ghar", "Bang", "Sheesh"};
		int t = Integer.parseInt(br.readLine());
		for(int i=1; i<=t; i++) {
			// 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			// 별칭 구하기
			String output = "";
			// 두 수가 같으면
			if(a == b) {
				if(a == 1)
					output = "Habb Yakk";
				else if(a == 2)
					output = "Dobara";
				else if(a == 3)
					output = "Dousa";
				else if(a == 4)
					output = "Dorgy";
				else if(a == 5)
					output = "Dabash";
				else if(a == 6)
					output = "Dosh";
			}
			// 6-5 or 5-6이면
			else if((a==6 && b==5) || (a==5 && b==6))
				output = "Sheesh Beesh";
			else {
				int first = Math.max(a, b);
				int second = Math.min(a, b);
				output = name[first] + " " + name[second];
			}
			// 출력
			System.out.println("Case " + i + ": " + output);
		}
	}
}