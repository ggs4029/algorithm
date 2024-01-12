// 백준 1764번
// 듣보잡
// 듣도 못한 사람의 명단, 보도 못한 사람의 명단에서
// 듣도 보도 못한 사람(중복인 사람) 수 구하기
// 방법-----------------------------------
// 듣도 못한 사람 수 n, 보도 못한 사람의 수 m을 한줄에 입력 받고
// n줄에 걸쳐 듣도 못한 사람의 이름을 입력 받고 set에 저장.
// m줄에 걸쳐 보도 못한 사람의 이름을 입력 받으면서
// 동시에 setA에 있는 이름인지 검사하고 중복이면
// ArrayList에 add한다.
// 정렬 후 듣보잡의 수와 같이 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class pr1764 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		// 입력
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Set<String> set = new HashSet<>();
		for(int x=0; x<n; x++) {
			set.add(br.readLine());
		}
		// 중복인원 세기
		ArrayList<String> output = new ArrayList<>();
		for(int x=0; x<m; x++) {
			String input = br.readLine();
			if(set.contains(input)) {
				output.add(input);
			}
		}
		// 정렬
		Collections.sort(output);
		// 출력
		sb.append(output.size()).append('\n');
		for(int x=0; x<output.size(); x++) {
			sb.append(output.get(x)).append('\n');
		}
		System.out.print(sb.toString());
	}
}