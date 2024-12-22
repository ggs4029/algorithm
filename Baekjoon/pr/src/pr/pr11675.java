// 백준 11675번
//  x ^ (x << 1) 연산을 모든 전송 바이트에 적용하여 데이터를 암호화하는데
// 암호화된 데이터를 복호화 해내면 됨.
// 방법---------------------
// 첫 줄에 전송한 바이트 수 n을 입력 받음.
// 둘째 줄에 n개의 암호화된 메시지가 주어짐.
// 복호화 해서 n개의 바이트 값을 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr11675 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		for(int i=0; i<n; i++) {
			int tmp = Integer.parseInt(input[i]);
			for(int j=0; j<=255; j++) {
				if((j ^ (j << 1) & 255)==tmp) {
					System.out.print(j + " ");
					break;
				}
			}
		}
	}
}