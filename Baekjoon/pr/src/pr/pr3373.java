// 백준 3373번
// 문제에서 주어진 표현식에 숫자가 써진 카드들을 배치해서
// 얻을 수 있는 값 중 최솟값 구하기
// 방법---------------------
// 첫 줄에 카드의 개수 n을 입력 받음
// 다음 줄부터 n줄에 걸쳐 카드의 앞, 뒤면에 적힌 숫자들을 입력 받음
// 표현식에서 최솟값을 얻게 카드를 배치하기 위해
// 카드들을 두 면의 합을 기준으로 정렬

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class pr3373 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		int[][] card = new int[n][2];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			card[i][0] = Integer.parseInt(st.nextToken());
			card[i][1] = Integer.parseInt(st.nextToken());
		}
		// 정렬
		Arrays.sort(card, (a, b) -> (b[0] + b[1]) - (a[0] + a[1]));
		// 최솟값 계산
		int sum = 0;
		for(int i=n/2; i<n; i++) {
				sum += Math.min(card[i][0], card[i][1]);
		}
		for(int i=0; i<n/2; i++) {
			sum -= Math.max(card[i][0], card[i][1]);
		}
		//출력
		System.out.print(sum);
	}
}