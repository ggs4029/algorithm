// 백준 24408번
// 숫자들을 차례로 부르며, 첫 번째 숫자의 정수 배수를 찾았을 때 그 정수를 출력하는 문제
// 한번 정수를 출력하면 그 다음 숫자부터 다음 라운드가 이어지고
// 여러 라운드로 이루어지므로 정수를 여러개 출력할 수도 있음.
// 방법---------------------
// 첫 줄에 숫자 시퀀스의 길이 n을 입력 받고
// 다음 줄부터 n줄에 걸쳐 숫자가 주어짐.
// for문을 돌며 정수를 찾아 출력하고 다음 라운드를 배열이 끝날때까지 진행.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr24408 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		int[] num = new int[n+1];
		for(int i=0; i<n; i++)
			num[i] = Integer.parseInt(br.readLine());
		// 정수 찾기
		StringBuilder sb = new StringBuilder();
		int tmp = num[0];
		for(int i=1; i<n; i++) {
			if(num[i]%tmp==0) {
				sb.append(num[i]).append("\n");
				tmp = num[i+1];
				i++;
			}
		}
		// 출력
		System.out.print(sb.toString());
	}
}