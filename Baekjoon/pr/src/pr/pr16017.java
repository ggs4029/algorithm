import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr16017 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		boolean tmp = true;
		int[] num = new int[4];
		for(int i=0; i<4; i++) {
			num[i] = Integer.parseInt(br.readLine());
			if((i==0 || i==3) && !(8<=num[i]))
				tmp = false;
			if(i==2 && num[i]!=num[i-1])
				tmp = false;
		}
		// 출력
		if(tmp)
			System.out.print("ignore");
		else
			System.out.print("answer");
	}
}