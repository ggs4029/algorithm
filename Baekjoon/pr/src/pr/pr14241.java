// 백준 14241번
// 두 슬라임 x와 y를 합쳤을 때, 합친 슬라임의 크기는 x+y가 된다.
// 또한, 슬라임을 합칠 때 마다 두 사람은 x*y 점수를 얻게 된다.
// 영선이와 효빈이가 얻을 수 있는 점수의 최댓값을 구하는 프로그램을 작성.
// 방법---------------------
// 첫 줄에 슬라임 개수 n 주어짐.
// 다음 줄에 슬라임의 크기들이 주어진다.
// 정렬 후 앞부터 슬라임 더해 나가면 최댓값.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class pr14241 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		long[] slime = new long[n];
		for(int i=0; i<n; i++)
			slime[i] = Long.parseLong(st.nextToken());
		// 정렬
		Arrays.sort(slime);
		// 점수 최댓값 구하기
		long tmp = slime[0] + slime[1];					// 합쳐진 슬라임
		long output = slime[0] * slime[1];
		for(int i=2; i<n; i++) {
			output += tmp * slime[i];
			tmp += slime[i];
		}
		// 출력
		System.out.print(output);
	}
}