// 백준 16435번
// 스네이크버드는 자신의 길이보다 작거나 같은 높이에 있는 과일들을 먹을 수 있다.
// 스네이크버드가 과일 하나를 먹으면 길이가 1만큼 늘어날 때,
// 처음 길이가 l인 스네이크버드가 과일들을 먹어 늘릴 수 있는 최대 길이를 구하는 문제.
// 방법---------------------
// 첫 줄에 과일 개수 n과 스네이크버드의 초기 길이 l을 입력 받음.
// 다음 줄에 사과의 높이들을 입력 받는다.
// 사과 높이들 정렬하고 스네이크버드가 제일 낮은 사과부터 먹게하면
// 스네이크버드의 최대 길이를 구할수 있다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class pr16435 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int[] apple = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			apple[i] = Integer.parseInt(st.nextToken());
		// 정렬
		Arrays.sort(apple);
		// 스네이크버드 최대 길이 구하기
		for(int i=0; i<n; i++) {
			if(l >= apple[i])
				l++;
		}
		// 출력
		System.out.print(l);
	}
}