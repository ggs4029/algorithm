// 백준 28215번
// 마을에 대피소를 설치할 때
// 대피소를 설치하는 모든 방법 중
// 가장 가까운 대피소와 집 사이의 거리 중 가장 큰 값이 가장 작을 때의 거리를 구하는 문제.
// 방법---------------------
// 첫 줄에 집의 수 n이 주어지고 설치할 대피소의 개수 k가 주어짐.
// 다음 줄부터 n줄에 걸쳐 집의 위치 (x, y)가 주어짐.
// 대피소가 될 집 조합 구해 조합마다
// 가장 가까운 대피소와 집 사이의 거리 구해서 답 갱신해가며 집 순회.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr28215 {
	public static int n, k, output;
	public static int[][] house;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		house = new int[n][2];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			house[i][0] = Integer.parseInt(st.nextToken());
			house[i][1] = Integer.parseInt(st.nextToken());
		}
		// 메소드 호출과 출력
		int[] daePso = new int[k];
		output = Integer.MAX_VALUE;
		cal(0, 0, daePso);
		System.out.print(output);
	}

	// 가장 가까운 대피소와 집 사이의 거리 중 가장 큰 값이 가장 작을 때의 거리를 구하는 메소드
	public static void cal(int start, int count, int[] daePso) {
		if(count == k) {
			int tmp = 0;												// 거리 중 가장 큰 값을 저장할 변수
			for(int i=0; i<n; i++) {
				int min = Integer.MAX_VALUE;
				for(int j : daePso) {									// 대피소 순회하며 집과의 거리 구하기
					int distance = Math.abs(house[i][0] - house[j][0])
							+ Math.abs(house[i][1] - house[j][1]);
					min = Math.min(min, distance);
				}
				tmp = Math.max(tmp, min);
			}
			output = Math.min(output, tmp);								// 답 갱신
			return;
		}
		// 대피소 조합 생성
		for(int i=start; i<n; i++) {
			daePso[count] = i;
			cal(i+1, count+1, daePso);
		}
	}
}