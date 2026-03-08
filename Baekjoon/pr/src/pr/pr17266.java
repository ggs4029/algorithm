// 백준 17266번
// 인하대 후문에 어두운 굴다리가 있음.
// 굴다리로 가면 최단거리로 집에 가지만 길이 조금이라도 어두우면 안 감.
// 그래서 인천시에 굴다리의 모든 길 0 ~ n을 밝히게 가로등 설치해 달라고 민원 넣음.
// 높이만큼 주위를 비출 수 있는 가로등을 설치하려고 가로등 개수 m과 가로등의 위치 x를 다 정한 상태에서
// 갑자기 예산이 부족해져 가로등을 최소한의 높이로 해서 모든 길을 밝히고자 함.
// 굴다리의 길이 n을 모두 비추기 위한 가로등의 최소 높이를 구하는 문제.
// 방법---------------------
// 첫 줄에 굴다리 길이 n이 주어지고
// 다음 줄에 가로등 개수 m이 주어짐.
// 세번째 줄에 가로등 설치할 위치 x가 m개 주어짐. ( x는 오름차순으로 입력 받음)
// 첫번쨰 가로등(0부터 첫 가로등까지), 마지막 가로등, 가운데 있는 가로등(마지막 가로등부터 n까지)
// 비출수 있는지 세가지에 대해 높이 구하고 가장 큰 값 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr17266 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[] x = new int[m];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++)
			x[i] = Integer.parseInt(st.nextToken());
		// 가로등 최소 높이 구하기
		int output = x[0];
		for(int i=1; i<m; i++) {
			int tmp = x[i] - x[i-1];			// 다음 가로등과의 거리
			int mid = (tmp + 1) / 2;
			if(output < mid)
				output = mid;
		}
		int tmp2 = n - x[m-1];					// 마지막 가로등 처리
		if(output < tmp2)
			output = tmp2;
		// 출력
		System.out.print(output);
	}
}