// 백준 1895번
// 이차원 배열에서 필터링된 이미지를 구하고
// 값이 t보다 크거나 같은 픽셀의 수를 구하는 문제.
// 필터 크기는 3x3.
// 방법---------------------
// 첫 줄에 이차원 배열의 크기 r, c를 입력 받음.
// 다음 r개의 각 줄에는 c개의 픽셀 값이 주어지고
// 마지막 줄에 t값이 주어짐.
// 3x3 필터 움직이며 필터링된 이미지 구하고 중앙값이 t보다 큰지 검사.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class pr1895 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int image[][] = new int[r][c];
		for(int i=0; i<r; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<c; j++)
				image[i][j] = Integer.parseInt(st.nextToken());
		}
		int t = Integer.parseInt(br.readLine());
		// 필터링된 이미지 구하기
		int output = 0;
		ArrayList<Integer> filter = new ArrayList<>();
		for(int i=0; i<=r-3; i++) {
			for(int j=0; j<=c-3; j++) {
				for(int k=i; k<i+3; k++) {
					for(int l=j; l<j+3; l++)
						filter.add(image[k][l]);
				}
				// 정렬
				Collections.sort(filter);
				if(filter.get(4) >= t)							// 중앙값이 t보다 크면
					output++;
				filter.clear();
			}
		}
		// 출력
		System.out.print(output);
	}
}