// 백준 1620번
// 나는야 포켓몬 마스터 이다솜
// 도감에 수록되어 있는 포켓몬의 이름들을 입력 받고
// 문제를 내면 도감 번호나 포켓몬의 이름을 말하는 문제
// 방법-----------------------
// 도감의 수록되어 있는 포켓몬의 개수 n
// 문제의 개수 m을 한줄에 입력 받고
// Map과 String배열을 이용해 관리한다.
// 그다음 m개의 문제를 입력 받으며
// 문자가 들어오면 도감 번호를
// 숫자가 들어오면 포켓몬의 이름을 출력
// --------------------------
// 시간 줄이기 위해 문자열 하나하나 charAt()으로 바꿔 0~9인지 검사하는 코드에서
// try catch문 사용으로 바꿈

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class pr1620 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 도감 입력
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Map<String, Integer> pokemon = new HashMap<>();
		String[] pokemon_Name = new String[n+1];
		for(int x=0; x<n; x++) {
			String name = br.readLine();
			pokemon.put(name, x+1);
			pokemon_Name[x+1] = name;
		}
		// 문제 입력과 출력
		StringBuilder sb = new StringBuilder();
		for(int x=0; x<m; x++) {
			st = new StringTokenizer(br.readLine());
			String problem = st.nextToken();
			// 출력
			if(isNum(problem)) { 		// 숫자입력이면
				sb.append(pokemon_Name[Integer.parseInt(problem)]).append('\n');
			}
			else { 						// 문자입력이면
				sb.append(pokemon.get(problem)).append('\n');

			}
		}
		System.out.print(sb.toString());
	}

	public static boolean isNum(String s) {
		if(s == null)
			return false;
		try {
			int i = Integer.parseInt(s);
		}
		catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}
}