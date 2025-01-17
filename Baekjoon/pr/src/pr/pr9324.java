// 백준 9324번
// 알고리즘대로 정확하게 변형된 메시지는 각 문자가 세 번째 등장할 때 한 번 더 문자가 삽입된다.
// 예를 들면 요원이 "HELLOTHEREWELLBEFINE" 라는 메시지를 보내고 싶어 했다면
// "HELLOTHEREEWELLLBEFINEE" 는 정확한 변형이다.
// 이 작업을 자동으로 처리해주는 코드를 짜고 판별하기.
// 방법---------------------
// 첫 줄에 테스트 케이스의 개수 t가 주어짐.
// 그 다음 줄부터 t줄에 걸쳐 문자열이 주어짐.
// 알파벳 세가면서 순회 똑같은 알파벳 세번 올 때 마다
// 뒤가 똑같은 알파벳인지 판별하고 결과를 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr9324 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			String input = br.readLine();
			int[] num = new int[26];				// 순서대로 ABCDE ... 저장
			// 진짜 메시지인지 판별하기
			boolean output = true;
			for(int j=0; j<input.length(); j++) {
				int tmp = input.charAt(j)-65;
				num[tmp]++;
				if(num[tmp]==3) {
					if(j==input.length()-1 || input.charAt(j+1)!=input.charAt(j))
						output = false;
					num[tmp] = 0;
					j++;
				}
				if(!output)
					break;
			}
			if(output)
				sb.append("OK").append("\n");
			else
				sb.append("FAKE").append("\n");
		}
		// 출력
		System.out.print(sb.toString().trim());
	}
}