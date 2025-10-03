// 백준 2343번
// 블루레이에 총 n개의 동영상이 들어갈 수 있음.
// 녹화할 때 강의 순서가 바뀌면 안됨.
// 즉 i번 강의와 j번 강의를 같은 블루레이에 녹화하려면 i와 j 사이의 모든 강의도 같은 블루레이에 녹화해야함.
// m개의 블루레이에 강의 동영상을 녹화하려고함.
// 블루레이 크기를 최소로 하려고 할 때, 가능한 블루레이 크기 중 최소를 구하는 문제.
// 방법---------------------
// 첫 줄에 n, m이 주어짐.
// 다음 줄에는 강의 길이가 순서대로 한 줄에 n개 주어짐.
// 블루레이 크기 이분 탐색하면서
// 나눠서 담아보고 필요한 블루레이 수 센 다음
// 입력 받은 조건과 만족하는지 확인하고 답을 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr2343 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] num = new int[n];
		int min = 0;
		int max = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			if(min < num[i])
				min = num[i];
			max += num[i];
		}
		// 이분 탐색
		while(min <= max) {
			int sum = 0;								// 지금 블루레이에 담긴 강의 크기 합
			int tmp = 0;								// 필요한 블루레이 개수
			int mid = (min + max) / 2;
			for(int i=0; i<n; i++) {
				if(mid < sum+num[i]) {
					tmp++;
					sum = 0;
				}
				sum += num[i];
			}
			if(sum != 0)
				tmp++;
			if(tmp > m)
				min = mid + 1;
			else
				max = mid - 1;
		}
		// 출력
		System.out.print(min);
	}
}