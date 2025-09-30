// 백준 2110번
// 도현이 집 n개가 수직선 위에 있음. (집 여러개가 같은 좌표를 가지는 일은 없음)
// 언제 어디서나 와이파이 쓰려고 공유기 c개 설치할거임.
// 최대한 많은 곳에서 와이파이를 사용하려고 하기 때문에, 한 집에는 공유기를 하나만 설치할 수 있고,
// 가장 인접한 두 공유기 사이의 거리를 가능한 크게 하여 설치하려고 함.
// c개의 공유기를 n개의 집에 적당히 설치해 가장 인접한 두 공유기 사이의 거리를 최대로 만드는 문제.
// 방법---------------------
// 첫 줄에 집 개수 n과 공유기 개수 c를 한 줄에 입력 받음.
// 다음 줄부터 n줄에 걸쳐 집들의 좌표가 주어짐.
// 설치되는 집들 사이의 거리를 최대로 벌려야 함.
// 일단 입력 받은 집 좌표들 정렬하고
// 이분 탐색하면서 왼쪽은 집 사이 최소거리들 중에서 최솟값
// 오른쪽은 집 사이 최소거리들 중에서 최댓값으로 잡고
// 공유기 개수 세면서 설치한 공유기 개수랑 c 비교해가며
// 좌우 조절해주고 min - 1 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class pr2110 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] num = new int[n];
		for(int i=0; i<n; i++)
			num[i] = Integer.parseInt(br.readLine());
		// 정렬
		Arrays.sort(num);
		// 이분 탐색
		long min = 1;									// 집 사이의 최소거리 중에서 최솟값
		long max = num[n-1] - num[0] + 1 ;				// 집 사이의 최소거리 중에서 최댓값
		while(min <= max) {
			long mid = (min + max) / 2;
			int x = 0;									// 공유기 설치할 좌표
			int tmp = 1;								// 설치할 수 있는 공유기 개수
			for(int i=1; i<n; i++) {
				if(mid <= num[i]-num[x]) {				// 집 사이 거리 mid 이상이면
					x = i;								// 공유기 설치
					tmp++;
				}
			}
			if(tmp < c)									// 설치한 공유기 개수가 c보다 작으면
				max = mid - 1;
			else										// c보다 크거나 같으면
				min = mid + 1;
		}
		// 출력
		System.out.print(min - 1);
	}
}