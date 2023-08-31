// 백준 2869번
// 낮에 A미터 올라가고 밤에 B미터 미끄러지는 달팽이
// V미터인 나무 막대를 며칠만에 올라가는지 구하는 문제
// 방법----------------------------------
// if문을 이용해 낮에 V미터에 도달하는 경우를 조심한다

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr2869 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력받기
		String[] input = br.readLine().split(" ");
		int a = Integer.parseInt(input[0]);
		int b = Integer.parseInt(input[1]);
		int v = Integer.parseInt(input[2]);
		// 계산과 최종 출력
		int day = (v-b)/(a-b);
		if((v-b)%(a-b) != 0) // 나머지가 0이 아니면 다음날 낮에 도착
			++day;
		System.out.print(day);
	}
}