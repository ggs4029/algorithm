// 백준 2503번
// 숫자 야구 게임 함. (세 자리 수로)
// 민혁이의 물음들과 각각의 물음에 대한 영수의 답이 입력으로 주어질 때
// 영수가 생각하고 있을 가능성이 있는 답의 총 개수를 출력하는 문제.
// 방법---------------------
// 첫 줄에 질문의 개수 n이 주어지고
// 그 다음 줄부터 n줄에 걸쳐 질문한 세자리 수와 스트라이크, 볼 개수가 한 줄에 주어짐.
// 규칙에 따라 나올 수 없는 수들은 배제하고, 받은 입력에 따라 스트라이크와 볼 개수를 구해
// 입력과 비교해가며 가능성이 있는 답인지 구하고 총 개수를 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr2503 {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		boolean[] baseball = new boolean[999];
		// 숫자 야구 규칙1 - 나올 수 있는 수의 범위는 123 ~ 987
		for(int i=123; i<=987; i++) {
			String tmp = i + "";
			// 숫자 야구 규칙2 - 세 자리 중복x
			if(tmp.charAt(0)==tmp.charAt(1) || tmp.charAt(0)==tmp.charAt(2) || tmp.charAt(1)==tmp.charAt(2))
				continue;
			// 숫자 야구 규칙3 - 0 안나옴
			if(tmp.charAt(0)=='0' || tmp.charAt(1)=='0' || tmp.charAt(2)=='0')
				continue;
			baseball[i] = true;
		}
		for(int i=0; i<n; i++) {
			// 입력
			String[] input = br.readLine().split(" ");
			int tmp = Integer.parseInt(input[0]);
			int s = Integer.parseInt(input[1]);
			int b = Integer.parseInt(input[2]);
			// 가능성 있는 답 찾기
			for(int j=123; j<=987; j++) {
				if(baseball[j]) {
					int strike = 0;
					int ball = 0;
					for(int k=0; k<3; k++) {
						char tmp2 = Integer.toString(tmp).charAt(k);
						for(int l=0; l<3; l++) {
							char tmp3 = Integer.toString(j).charAt(l);
							if(tmp2==tmp3 && k==l)							// 숫자 같고 위치 같으면 스트라이크
								strike++;
							else if(tmp2==tmp3 && k!=l)						// 숫자 같은데 위치 다르면 볼
								ball++;
						}
					}
					if(strike==s && ball==b)
						baseball[j] = true;
					else
						baseball[j] = false;
				}
			}
		}
		int output = 0;
		for(int i=123; i<=987; i++) {
			if(baseball[i])
				output++;
		}
		// 출력
		System.out.print(output);
	}
}