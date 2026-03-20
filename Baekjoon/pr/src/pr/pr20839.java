import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr20839 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 성적 기준
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int z = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		// 애들 점수
		int x1 = Integer.parseInt(st.nextToken());
		int y1 = Integer.parseInt(st.nextToken());
		int z1 = Integer.parseInt(st.nextToken());
		// 출력
		if(x1==x && y1==y && z1==z)
			System.out.print("A");
		else if(x1>=(x+1)/2 && y1==y && z1==z)
			System.out.print("B");
		else if(y1==y && z1==z)
			System.out.print("C");
		else if(y1>=(y+1)/2 && z1==z)
			System.out.print("D");
		else
			System.out.print("E");
	}
}