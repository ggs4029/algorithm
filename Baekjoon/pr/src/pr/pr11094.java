// 백준 11094번
// 정확히 "Simon says"가 나오는 문장에 대해서만
// "Simon says" 이후에 나오는 나머지 부분을 각 줄에 출력하는 문제
// 방법---------------------
// 첫 줄에 입력 받을 명령의 수 n이 주어짐.
// 그 다음 n줄에 걸쳐 명령들이 들어온다.
// 명령 앞이 Simon says인지 확인하고 맞으면 뒤의 명령들만 한줄씩 출력

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr11094 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		String[] input = new String[n];
		for(int i=0; i<n; i++)
			input[i] = br.readLine();
		// 명령 처리
		StringBuilder sb = new StringBuilder();
		String tmp = "Simon says";
		for(int i=0; i<n; i++) {
			if(input[i].startsWith(tmp))
				sb.append(input[i].substring(10, input[i].length())).append("\n");
		}
		// 출력
		System.out.print(sb.toString());
	}
}