import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr15080 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		String[] a = new String[5];
		String[] b = new String[5];
		int s = 0;
		int e = 0;
		for(int i=0; i<5; i++)
			a[i] = st.nextToken();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<5; i++)
			b[i] = st.nextToken();
		// 시작 시간과 끝 시간 구하기
		s = Integer.parseInt(a[4]) + Integer.parseInt(a[2]) * 60 + Integer.parseInt(a[0]) * 3600;
		e = Integer.parseInt(b[4]) + Integer.parseInt(b[2]) * 60 + Integer.parseInt(b[0]) * 3600;
		// 출력
		if(s > e)
			System.out.println(e - s + 3600 * 24);
		else
			System.out.println(e - s);
	}
}