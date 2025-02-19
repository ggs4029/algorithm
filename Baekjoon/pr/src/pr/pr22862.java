// 백준 22862번
// 길이 n인 수열 s가 있음.
// 수열 s에서 원하는 위치에 있는 수를 최대 k번 지울수 있음.
// 수열 s에서 최대 k번 원소를 삭제한 수열에서 짝수로 이루어져 있는 연속한 부분 수열 중 가장 긴 길이를 구하는 문제.
// 방법---------------------
// 첫 줄에 수열 s의 길이 n과 삭제 최대 회수 k를 입력 받음.
// 다음 줄에 수열 s를 구성하고 있는 n개의 수를 입력 받음.
// 두 포인터로 슬라이딩 윈도우 움직이면서 k번 삭제해가며
// 짝수로만 이루어져 있는 연속한 부분 수열 중 가장 긴 길이를 구한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr22862 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		boolean[] num = new boolean[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			int input = Integer.parseInt(st.nextToken()) % 2;
			num[i] = input == 0;								// 짝수 true 홀수 false
		}
		// 짝수 부분 수열 중 가장 긴 기링 찾기
		int l = 0, r = 0;
		int output = 0;
		int tmp = 0;
		while(n > r) {
			if(tmp < k) {
				if(!num[r])										// 홀수면
					tmp++;										// 삭제 카운트
				r++;
				output = Math.max(output, r-l-tmp);
			}
			else if(num[r]) {									// 삭제된 값이 k개 이상이고 짝수면
				r++;
				output = Math.max(output, r-l-tmp);
			}
			else {
				if(!num[l])
					tmp--;
				l++;
			}
		}
		// 출력
		System.out.print(output);
	}
}