// 백준 1259번
// 펠린드롬수
// 방법----------------
// 입력 받은 값을 앞에서 n번째, 뒤에서 n번째 인덱스끼리 for문으로 비교한다.
// 다른게 있으면 no 모두true면 yes를 출력한다.
// 0을 입력 받을 때만 종료

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr1259 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		while (true) {
			String[] input = br.readLine().split("");
			if (input[0].equals("0")) // 0 입력시 종료
				break;
			for (int x = 0; x <= input.length / 2; x++) {
				if (!input[x].equals(input[input.length - x - 1])) { // 앞뒤가 다르면 no출력 and break
					System.out.println("no");
					break;
				} else if (x == input.length / 2) { // 끝까지 같으면 yes출력
					System.out.println("yes");
				}
			}
		}
	}
}