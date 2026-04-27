import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr29807 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] num = new int[n];
		for(int i=0; i<n; i++)
			num[i] = Integer.parseInt(st.nextToken());
		// 학번 찾기
		int output = 0;
		if(n == 1)
			output += num[0] * 508;
		else if(n == 2) {
			output += num[0] * 508;
			output += num[1] * 212;
		}
		else if(n == 3) {
			if(num[0] > num[2])
				output += (num[0] - num[2]) * 508;
				else
				output += (num[2] - num[0]) * 108;
			output += num[1] * 212;
		}
		else if(n == 4) {
			if(num[0] > num[2])
				output += (num[0] - num[2]) * 508;
			else
				output += (num[2] - num[0]) * 108;
			if(num[1] > num[3])
				output += (num[1] - num[3]) * 212;
			else
				output += (num[3] - num[1]) * 305;
		}
		else if(n == 5) {
			if(num[0] > num[2])
				output += (num[0] - num[2]) * 508;
			else
				output += (num[2] - num[0]) * 108;
			if(num[1] > num[3])
				output += (num[1] - num[3]) * 212;
			else
				output += (num[3] - num[1]) * 305;

			output += num[4] * 707;
		}
		output = output * 4763;
		// 출력
		System.out.print(output);
	}
}