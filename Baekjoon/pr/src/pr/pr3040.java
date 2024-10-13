// 백준 3040번
// 9마리 난쟁이 중에서 7마리 난쟁이를 찾는 문제
// 7마리 난쟁이의 모자에 쓰여 있는 수의 합이 100
// 방법---------------------
// 아홉줄에 걸쳐 9마리 난쟁이들 숫자 입력 받고 sum에 합을 저장.
// 2중 for문을 돌며 sum에서 둘을 빼가며 100이 되면
// 걔네 둘을 제외한 나머지 숫자들을 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr3040 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] p = new int[9];
		int sum = 0;
		for(int i=0; i<9; i++) {
			// 입력
			p[i] = Integer.parseInt(br.readLine());
			sum += p[i];
		}
		// 두 난쟁이 검거하기
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				if(i!=j) {
					if(sum-p[i]-p[j]==100) {
						// 출력
						for(int k=0; k<9; k++) {
							if(k==i || k==j)
								continue;
							else
								System.out.println(p[k]);
						}
					}
				}

			}
		}
	}
}