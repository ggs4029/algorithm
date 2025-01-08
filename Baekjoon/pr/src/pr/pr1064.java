// 백준 1064번
// 세 개의 다른 점이 주어지면 적절히 점 D를 찾아서 네 점으로 평행사변형을 만들면 된다.
// 이때, D가 여러 개 나올 수도 있다.
// 만들어진 모든 사각형 중 가장 큰 둘레 길이와 가장 작은 둘레 길이의 차이를 출력하는 문제.
// 만약 만들 수 있는 평행사변형이 없다면 -1을 출력.
// 방법---------------------
// 첫 줄에 점 세개의 x, y 좌표들이 주어진다.
// 평행사변형 가능한지 검사하고 통과하면
// 두 점들끼리의 거리 구해 배열에 저장.
// 구한 거리 내림차순 정렬하고 맨뒤에서 맨앞 빼고 2곱해서 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class pr1064 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x1 = Integer.parseInt(st.nextToken());
		int y1 = Integer.parseInt(st.nextToken());
		int x2 = Integer.parseInt(st.nextToken());
		int y2 = Integer.parseInt(st.nextToken());
		int x3 = Integer.parseInt(st.nextToken());
		int y3 = Integer.parseInt(st.nextToken());
		// 평행사변형 가능한지 검사
		if((x2-x1) * (y3-y1) == (y2-y1) * (x3-x1)) {						// 두 벡터 같으면
			System.out.print(-1);
			return;
		}
		// 두 점 사이 거리 구하기
		double tmp1 = Math.sqrt((x2-x1) * (x2-x1) + (y2-y1) * (y2-y1)) +	// 점1에서 점2, 3
				Math.sqrt((x3-x1) * (x3-x1) + (y3-y1) * (y3-y1));
		double tmp2 = Math.sqrt((x1-x2) * (x1-x2) + (y1-y2) * (y1-y2)) +	// 점2에서 점1, 3
				Math.sqrt((x3-x2) * (x3-x2) + (y3-y2) * (y3-y2));
		double tmp3 = Math.sqrt((x1-x3) * (x1-x3) + (y1-y3) * (y1-y3)) +	// 점3에서 점1, 2
				Math.sqrt((x2-x3) * (x2-x3) + (y2-y3) * (y2-y3));
		// 정렬
		double[] tmp = {tmp1, tmp2, tmp3};
		Arrays.sort(tmp);
		// 출력
		System.out.printf("%.16f\n", 2 * (tmp[2]-tmp[0]));
	}
}