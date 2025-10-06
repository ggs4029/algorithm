import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class pr29731 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		boolean tmp = true;
		Map<String, Integer> rick = new HashMap<>();
		rick.put("Never gonna give you up", 1);
		rick.put("Never gonna let you down", 1);
		rick.put("Never gonna run around and desert you", 1);
		rick.put("Never gonna make you cry", 1);
		rick.put("Never gonna say goodbye", 1);
		rick.put("Never gonna tell a lie and hurt you", 1);
		rick.put("Never gonna stop", 1);
		for(int i=0; i<n; i++) {
			String input = br.readLine();
			if(rick.get(input) == null) {
				tmp = false;
				break;
			}
		}
		// 출력
		if(!tmp)
			System.out.print("Yes");
		else
			System.out.print("No");
	}
}