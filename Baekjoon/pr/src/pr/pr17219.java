// 백준 17219번
// 메모장에서 비밀번호를 찾아주는 프로그램을 작성하는 문제
// 방법---------------------
// 첫 줄에 저장된 사이트 주소의 수 n, 비밀번호를 찾으려는 사이트 주소의 수 m을 입력 받는다.
// 다음줄부터 n줄에 걸쳐 각 줄에 사이트 주소와 비밀번호를 입력 받는다.
// 해시맵을 사용해 입력 받은 사이트 주소와 비밀번호를 저장하고,
// 비밀번호를 찾으려는 사이트의 비밀번호들만 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class pr17219 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		HashMap<String, String> pw = new HashMap<>();
		for(int i=0; i<n; i++) {
			String[] input2 = br.readLine().split(" ");
			pw.put(input2[0], input2[1]);
		}
		// 출력
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<m; i++) {
			sb.append(pw.get(br.readLine())).append("\n");
		}
		System.out.print(sb.toString());
	}
}