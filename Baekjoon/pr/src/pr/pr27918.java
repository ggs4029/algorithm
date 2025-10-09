import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr27918 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		int sumD = 0;
		int sumP = 0;
		String[] input = new String[n];
		int d = 0;
		for(int i=0; i<n; i++)
			input[i] = br.readLine();
		// 점수 계산
		for(int i=0; i<n; i++) {
			if(input[i].equals("D"))
				sumD++;
			else if(input[i].equals("P"))
				sumP++;
			if(sumD > sumP)
				d = sumD - sumP;
			else
				d = sumP - sumD;
			if(d >= 2)
				break;
		}
		// 출력
		System.out.print(sumD + ":" + sumP);
	}
}