// 백준 11977번
// 주어진 건초더미들의 위치에서 소를 발사하여 가능한 많은 건초더미를 폭발시키는 문제.
// 소가 건초더미 x에 발사되면, 그 건초더미는 폭발합니다.
// 폭발 반경은 1로, 즉, 거리가 1 이하인 건초더미들이 폭발에 영향을 받습니다.
// 이로 인해 주변의 건초더미들도 폭발하게 되고, 이들은 다음 단계에서 반경이 2인 폭발을 일으킵니다.
// 이후 폭발은 점차 강해지며, t번째 폭발은 반경이 t인 폭발을 일으킵니다.
// 방법---------------------
// 첫 줄에 n이 입력으로 주어짐.
// 그 다음 n줄에 걸쳐 건초더미의 좌표를 입력 받음.
// 입력 받은 좌표 배열에 넣고 정렬.
// for문 안에서 while문을 돌며 모든 좌표에서 건초더미들이 폭발했을 때의 max값을 구해 비교하고 제일 큰 값을 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class pr11977 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		int[] num = new int[n];
		for(int i=0; i<n; i++)
        	num[i] = Integer.parseInt(br.readLine());
		// 정렬
		Arrays.sort(num);
		// max 구하기
		int max = 0;
		for(int i=0; i<n; i++) {
			int tmp = i, tmp1 = 1, tmp2 = 1;					// tmp1 = 폭발한 건초 수, tmp2 = 폭발 반경
			int l = tmp - 1;
			while(true) {
				if(l < 0 || num[tmp] - num[l] > tmp2)
					break;
				while(l >= 0 && num[tmp] - num[l] <= tmp2) {
					tmp1++;
					l--;
				}
				tmp = l + 1;
				tmp2++;
			}
			tmp = i;
			tmp2 = 1;
			int r = tmp + 1;
			while(true) {
				if(r >= n || num[r] - num[tmp] > tmp2)
					break;
				while(r < n && num[r] - num[tmp] <= tmp2) {
					tmp1++;
					r++;
				}
				tmp = r - 1;
				tmp2++;
			}

			// 최대 폭발 건초더미 수 업데이트
			max = Math.max(max, tmp1);
		}
		// 출력
		System.out.print(max);
	}
}