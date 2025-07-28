import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr28938 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		int sum = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if(tmp == -1)
				sum--;
			else if(tmp == 1)
				sum++;
		}
		// 출력
		if(sum > 0)
			System.out.print("Right");
		else if(sum < 0)
			System.out.print("Left");
		else
			System.out.print("Stay");
	}
}