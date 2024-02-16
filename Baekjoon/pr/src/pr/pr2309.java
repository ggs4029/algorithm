// 백준 2309번
// 일곱 난쟁이
// 9명의 난쟁이들의 키가 주어지면
// 거기서 키의 합이 100이되는 7명을 뽑는 문제
// 방법----------------------
// 9줄에 걸쳐 키들을 입력 받고 배열에 저장.
// 합이 100이 되는 7명을 구하기 위해
// 입력 받은 9명의 키를 모두 더하고
// 거기서 아무나 두명의 키를 빼 100이 되는 그 값들을 찾는다. (이중 for문 이용)
// 그 값들을 제외하고 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class pr2309 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int[] input = new int[9];
		int sum = 0;
		for(int x=0; x<9; x++) {
			input[x] = Integer.parseInt(br.readLine());
			sum += input[x];
		}
		// 정렬
		Arrays.sort(input);
		// 합이 100이되는 7명 구하기
		int n1 = 0;
		int n2 = 0;
		for(int x=0; x<8; x++) {
			for(int y=x+1; y<9; y++) {
				if(sum-input[x]-input[y] == 100) {
					//input[x] = 0;				// 0으로 만들고 출력x
					//input[y] = 0;				// 0으로 만들고 출력x
					// 오류남 - 정답이 여러 가지인 경우
					// 인덱스 이용으로 해결
					n1 = x;
					n2 = y;
					break;
				}
			}
		}
		// 출력
		for(int x=0; x<9; x++) {
			if(x!=n1 && x!=n2)
			//if(input[x]!=0)					// 0이 아니면 출력
				System.out.println(input[x]);
		}
	}
}