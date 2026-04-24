import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr30008 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int [] grade = new int[k];
		int [] d = new int[k];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<k; i++) {
			grade[i] = Integer.parseInt(st.nextToken());
			// 준영이 등급 구하기
			d[i] = grade[i] * 100 / n;
			if(d[i] <= 4)
				sb.append(1).append(" ");
			else if(d[i] <= 11)
				sb.append(2).append(" ");
			else if (d[i] <= 23)
				sb.append(3).append(" ");
			else if(d[i] <= 40)
				sb.append(4).append(" ");
			else if(d[i] <= 60)
				sb.append(5).append(" ");
			else if(d[i] <= 77)
				sb.append(6).append(" ");
			else if(d[i] <= 89)
				sb.append(7).append(" ");
			else if(d[i] <= 96)
				sb.append(8).append(" ");
			else
				sb.append(9).append(" ");
		}
		// 출력
		System.out.print(sb.toString().trim());
	}
}