import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr34691 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			// 입력
			String input = br.readLine();
			// 상징 판정
			if(input.equals("end"))
				break;
			else if(input.equals("animal"))
				sb.append("Panthera tigris").append("\n");
			else if(input.equals("tree"))
				sb.append("Pinus densiflora").append("\n");
			else if(input.equals("flower"))
				sb.append("Forsythia koreana").append("\n");
		}
		// 출력
		System.out.print(sb.toString().trim());
	}
}