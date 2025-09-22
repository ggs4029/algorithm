// 백준 14916번
// 동전의 개수가 최소가 되도록 손님에게 거스름돈을 주는 방법.
// 2원짜리와 5원짜리 동전만 있을 때 최소 동전의 개수를 출력.
// 거스름돈 액수 n이 주어짐.
// 방법---------------------
// 거스름돈 액수 n을 입력 받고
// 5원 먼저 계산하고 2원 계산해 출력.
// 5로 나눠떨어지지 않으면 2원 빼보고 다시 계산.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr14916 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		// 동전 최소 개수 구하기
		int output = 0;
		while(true){
			if(n%5 == 0){							// 5로 나눠떨어지면
				output += n/5;
				System.out.print(output);
				break;
			}
			else{									// 아니면 2빼고 다시
				n -= 2;
				output++;
			}
			if(n < 0){								// 거슬러 줄 수 없으면
				System.out.print(-1);
				break;
			}
		}
	}
}