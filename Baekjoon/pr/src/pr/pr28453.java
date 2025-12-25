import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr28453 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			int level = Integer.parseInt(st.nextToken());
			// 구간 판별하고 출력
			if(level >= 300)
				System.out.print("1 ");
			else if(level>=275 && level<300)
				System.out.print("2 ");
			else if(level>=250 && level<275)
				System.out.print("3 ");
			else
				System.out.print("4 ");
		}
	}
}