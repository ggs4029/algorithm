// 백준 2776번
// 동규가 연종이를 따라 다니며, 걔가 하루 동안 본 정수들을 모두 ‘수첩1’에 적음.
// 그리고 동규가 연종이에게 질문 m개를 함.
// X라는 정수 오늘 봤는지.
// 연종이가 모두 대답을 했고, 동규는 연종이 봤다고 주장하는 수 들을 ‘수첩2’에 적어 둠.
// 집에 돌아온 동규는 답이 맞는지 확인하려 하지만, 연종을 따라다니느라 힘들다고 나한테 헬프침.
// 동규를 도와주기 위해 ‘수첩2’에 적혀있는 순서대로, 각각의 수에 대해 ‘수첩1’에 있으면 1을, 없으면 0을 출력하는 문제.
// 방법---------------------
// 첫 줄에 테스트 케이스의 개수 t가 주어짐.
// 각 테스트 케이스의 첫줄은 수첩 1에 적은 정수의 개수 n을 입력 받고
// 다음 줄에 정수 n개를 한줄에 입력 받음.
// 그 다음 줄에 수첩 2에 적은 정수의 개수 m을 입력 받고
// 다음 줄에 정수 m개를 한줄에 입력 받는다.
// 해시셋으로 수첩2에 있는 숫자가 수첩1에도 있는지
// 확인하고 결과를 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class pr2776 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			// 입력
			int n = Integer.parseInt(br.readLine());
			Set<Integer> hs = new HashSet<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++)
				hs.add(Integer.parseInt(st.nextToken()));
			int m = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			// 적혀있는지
			for(int j=0; j<m; j++) {
				if(hs.contains(Integer.parseInt(st.nextToken())))
					sb.append("1").append("\n");
				else
					sb.append("0").append("\n");
			}
		}
		// 출력
		System.out.print(sb.toString().trim());
	}
}