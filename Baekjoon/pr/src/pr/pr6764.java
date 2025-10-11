import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr6764 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int[] num = new int[4];
		for(int i=0; i<num.length; i++)
			num[i] = Integer.parseInt(br.readLine());
		// 출력
		if(num[0]<num[1] && num[1]<num[2] && num[2]<num[3])
			System.out.print("Fish Rising");
		else if(num[0]>num[1] && num[1]>num[2] && num[2]>num[3])
			System.out.print("Fish Diving");
		else if(num[0]==num[1] && num[1]==num[2] && num[2]==num[3])
			System.out.print("Fish At Constant Depth");
		else
			System.out.print("No Fish");

	}
}