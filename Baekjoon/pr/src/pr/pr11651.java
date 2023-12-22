// 백준 11651번
// 좌표 정렬하기2
// 방법--------------
// 좌표 n개를 입력 받고 2차원 배열에 저장
// 저장된 좌표들을 y좌표가 증가하는 순으로 정렬
// y좌표가 같을 때는 x좌표가 증가하는 순으로 정렬한 후
// 정렬 결과를 출력한다.
// 정렬은 람다식을 이용

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class pr11651 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		int[][] coordinate = new int[n][2];
		for(int i=0; i<n; i++) {
			String[] input = br.readLine().split(" ");
			int x = Integer.parseInt(input[0]);
			int y = Integer.parseInt(input[1]);
			coordinate[i][0] = x;
			coordinate[i][1] = y;
		}

		// 정렬
		Arrays.sort(coordinate, (a,b) -> {
			if(a[1] == b[1]) {			// y값이 같으면
				return a[0] - b[0];		// x값끼리 비교
			}
			else {						// y값이 다르면
				return a[1] - b[1];		// y값끼리 비교
			}
		});

		// 출력
		for(int i=0; i<n; i++) {
			System.out.println(coordinate[i][0]+" "+coordinate[i][1]);
		}
	}
}