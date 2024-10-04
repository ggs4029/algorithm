// 백준 5349번
// 번호들이 입력으로 주어지면 중복되어 나온 번호들을 출력하는 문제
// 방법---------------------
// 000-00-0000이 입력될 때까지 매 줄마다 번호들을 입력 받는다.
// 매 줄 입력 받을 때마다 중복인지 체크하고 중복인 번호들만 출력한다.
// 트리셋 디폴트 = 삽입되는 값들을 자동으로 오름차순 정렬
// 주의! - 문자열 비교는 .equals()를 이용 ( == 이용x)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeSet;

public class pr5349 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		ArrayList<String> ssn = new ArrayList<>();
		TreeSet<String> output = new TreeSet<>();
		while(true) {
			String input = br.readLine();
			if(input.equals("000-00-0000"))
				break;
			// 중복이면 트리셋에 추가
			if(ssn.contains(input)) {
				output.add(input);
			}
			else
				ssn.add(input);
		}
		// 출력
		for(String s : output)
			System.out.println(s);
	}
}