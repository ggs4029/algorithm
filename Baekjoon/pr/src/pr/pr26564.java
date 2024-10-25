// 백준 26564번
// 표준 52장 카드에서 다섯 장의 카드가 주어짐.
// 각 카드는 랭크(즉, A, 2, 3, ..., 9, T, J, Q, K 중 하나)와
// 슈트(즉, C, D, H, S 중 하나)로 구성되어있음.
// 내 손의 강도는 같은 랭크를 가진 카드의 최대 개수 k로 정의될때, 강도를 출력하는 문제.
// 방법---------------------
// 첫 줄에 데이터 세트의 수를 나타내는 정수 n이 주어짐.
// 다음줄부터 n줄에 걸쳐 데이터 세트(카드 다섯개)들을 입력 받음.
// 해시맵을 사용해 강도를 계산, 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class pr26564 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			// 입력
			String[] input = br.readLine().split(" ");
			HashMap<Character, Integer> card = new HashMap<>();
			// 랭크 구하기
			for(String s : input) {
				char tmp = s.charAt(0); 							// 앞글자만 따오기
				card.put(tmp, card.getOrDefault(tmp, 0)+1);			// 앞글자만 저장 + 랭크 세기
			}
			// 출력
			int output = 0;
			for(int j : card.values())
				output = Math.max(output, j);
			System.out.println(output);
		}
	}
}