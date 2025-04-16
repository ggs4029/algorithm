// 백준 1769번
// 큰 수 x가 주어지면 문제에서 설명한 문제 변환의 과정을 몇 번 거쳐야 y가 한 자리 수가 되는지,
// 그 수가 3의 배수인지 아닌지를 구하는 문제.
// 방법---------------------
// 첫 줄에 자연수 x를 입력 받음.
// 문제에서 주어진 변환 과정을 무한루프를 돌며 한자릿수가 될 때까지 반복하고
// 변환 과정을 몇 번 했는지와 그 수가 3의 배수인지 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr1769 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String x = br.readLine();
		// 다른 문제로 바꾸어 풀기
		int output = 0;
		while(true){
			long tmp = 0;
			if(x.length()==1)										// 한자릿수면 탈출
				break;
			for(int i=0; i< x.length(); i++)
				tmp += Long.parseLong(String.valueOf(x.charAt(i)));	// 자릿수 더하기
			output++;
			x = String.valueOf(tmp);								// 더한값 다시 변환
		}
		// 출력
		System.out.println(output);
		if(Long.parseLong((x))%3 == 0)
			System.out.print("YES");
		else
			System.out.print("NO");
	}
}