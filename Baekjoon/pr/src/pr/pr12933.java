// 백준 12933번
// 오리 녹음한 소리는 문자열로 나타낼 수 있는데, 한 문자는 한 오리가 낸 소리이다.
// 오리의 울음 소리는 연속될 필요는 없지만, 순서는 "quack"이어야 한다.
// "quqacukqauackck"과 같은 경우는 두 오리가 울었다고 볼 수 있다.
// 영선이가 녹음한 소리가 주어졌을 때, 영선이 방에 있을 수 있는 오리의 최소 개수를 구하는 문제.
// 방법---------------------
// 첫 줄에 녹음한 소리가 주어짐.
// 크기가 5인 배열로 알파벳 하나씩 읽어가면서
// 올바른 소리인지 판별하고 필요한 오리의 최솟값을 구하고 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr12933 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String input = br.readLine();
		int[] duck = new int[4];				// 순서대로 q u a c k 저장
		int output =0;
		// 오리 최솟값 구하기
		for(char i : input.toCharArray()){
			int tmp = 888484;
			if(i=='q')
				tmp = 0;
			else if(i=='u')
				tmp = 1;
			else if(i=='a')
				tmp = 2;
			else if(i=='c')
				tmp = 3;
			else if(i=='k')
				tmp = 4;
			if(tmp==0)
				duck[0]++;
			else {
				if(duck[tmp-1]>0) {
					duck[tmp-1]--;
					if(tmp!=4)
						duck[tmp]++;
				}
				else {							// 올바른 울음소리 순서가 아니면
					System.out.print(-1);
					return;
				}
			}
			int tmp2 = 0;						// 지금 울리고 있는 울음 소리의 개수
			for(int j=0; j<4; j++)
				tmp2 += duck[j];
			output = Math.max(output, tmp2);
		}
		// 출력
		int tmp3 = 0;
		for(int j=0; j<4; j++)
			tmp3 += duck[j];
		if(tmp3!=0 || input.length()%5!=0)		// 울음소리가 안끝났거나 input이 5의 배수 길이가 아니면
			System.out.print(-1);				// -1
		else
			System.out.print(output);
	}
}