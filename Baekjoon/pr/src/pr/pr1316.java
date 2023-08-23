// 백준 1316번
// 그룹 단어 체커
// 첫째 줄에 단어의 개수 N이 들어오면
// N개의 단어를 입력받고
// 그룹 단어의 개수를 출력
// 방법------------------------
// 지금 검사하는 알파벳의 앞전 알파벳이 같은지 확인하여
// 그룹 단어인지 체크한다

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr1316 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력 받기
		int num = Integer.parseInt(br.readLine());
		int sum = num;
		for(int x=0; x<num; x++) {
			String word = br.readLine();
			boolean[] wordTest = new boolean[26]; // 알파벳은 총 26개
			int past = 0; // 그 전 알파벳을 저장할 변수
			for(int y=0; y<word.length(); y++) {
				int present = word.charAt(y); // 현재의 알파벳을 저장할 변수
				// past != present 면
				if(past != present) {
					// 알파벳이 처음 나옴
					if(wordTest[present - 97] == false) {
						wordTest[present - 97] = true; // 나왔다고 표시
						past = present; // 다음 알파벳으로 넘어감
					}
					else { // 알파벳이 이미 나온적이 있는 경우
						sum--;
						break; // 그룹 단어가 아님
					}
				}
			}
		}
		// 최종출력
		System.out.print(sum);
	}
}