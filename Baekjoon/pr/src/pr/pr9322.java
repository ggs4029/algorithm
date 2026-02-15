// 백준 9322번
// 철벽 보안 알고리즘을 사용해
// 주어진 2개의 공개키와 암호문으로 평문을 복구하는 문제.
// 철벽 보안 알고리즘의 자세한 내용은 문제 참조.
// 방법---------------------
// 첫 줄에 테스트 케이스의 개수 t를 입력 받음.
// 각 테스트 케이스는 첫 줄에 한 문장의 단어 수 n을 입력 받고
// 그 다음 줄에 제 1 공개키를 입력 받음.
// 그 다음 줄에 제 2 공개키를 입력 받고
// 마지막으로 암호문을 입력 받는다.
// 제1 공개키의 단어들의 원래 위치를 해시맵에 저장하고 제2 공개키랑 비교해서
// 알아낸 규칙을 암호문에 대입해 평문 구하고 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class pr9322 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			// 입력
			int n = Integer.parseInt(br.readLine());
			HashMap<String, Integer> map = new HashMap<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++)
				map.put(st.nextToken(), j);					// 제 1 공개키 해시맵에 위치랑 저장
			int[] location = new int[n];					// 위치 규칙 저장할 배열
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++)
				location[j] = map.get(st.nextToken());		// 제 2 공개키 재배치된 경로 저장
			String[] original = new String[n];				// 평문 저장할 배열
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++)
				original[location[j]] = st.nextToken();		// 재배치해서 평문 만들기
			for(int j=0; j<n; j++)
				sb.append(original[j]).append(" ");
			sb.append("\n");
		}
		// 출력
		System.out.print(sb.toString().trim());
	}
}