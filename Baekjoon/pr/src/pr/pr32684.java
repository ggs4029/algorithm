import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr32684 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력 + 점수 계산
		int[] sum = {13, 7, 5, 3, 3, 2};
		double sum1 = 0;
		double sum2 = 1.5;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<6; i++)
			sum1 += Integer.parseInt(st.nextToken()) * sum[i];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<6; i++)
			sum2 += Integer.parseInt(st.nextToken()) * sum[i];
		// 출력
		if(sum1 > sum2)
			System.out.print("cocjr0208");
		else
			System.out.print("ekwoo");
	}
}