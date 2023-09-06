// 백준 14215번
// 세 막대의 길이를 입력 받아
// 삼각형의 둘레가 최대인 삼각형의 둘레를 출력
// 세 막대의 길이는 양이 정수이며 각 막대의 길이를 마음대로 줄일 수 있음.
// 방법------------------------
// 첫째 줄에 세 막대의 길이를 한 줄로 입력 받는다
// 삼각형의 조건을 만족하며 둘레를 가장 크게 하려면
// 제일 큰 막대의 길이를 나머지 두 막대의 길이에 따라 줄이는 것이 둘레가 제일 큼

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class pr14215 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input = br.readLine().split(" ");
		if (input != null) {
			int[] tri = new int[3];
			tri[0] = Integer.parseInt(input[0]);
			tri[1] = Integer.parseInt(input[1]);
			tri[2] = Integer.parseInt(input[2]);
			Arrays.sort(tri); // 정렬
			// 출력
			if (tri[0] + tri[1] <= tri[2]) { // 입력으로 받은 막대의 길이들이 삼각형의 조건을 충족하지 않으면
				tri[2] = tri[0] + tri[1] - 1; // 제일 긴 막대기를 삼각형의 조건을 충족하되 최대한 길게
				System.out.print(tri[0] + tri[1] + tri[2]);
			} else {
				System.out.print(tri[0] + tri[1] + tri[2]);
			}
		}
	}
}
