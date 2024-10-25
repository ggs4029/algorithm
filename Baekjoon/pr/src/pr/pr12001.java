// 백준 12001번
// 최적의 울타리 위치를 설정해 네 개의 영역 중 하나에 나타나는 소의 최대 수인 M을 최솟값으로 만드는 문제
// 방법---------------------
// 첫 줄에 소의 마리수 N과 최대 좌표값인 B가 주어짐.
// 다음줄부터 N줄에 걸쳐 각 소의 위치를 입력 받음.
// 3중 for문을 돌며 울타리 위치에 따라
// 각 사분면에 있는 소의 마리 수를 구하고 M을 구해 최솟값을 업데이트 한다.
// 최소인 M 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class pr12001 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int B = Integer.parseInt(input[1]);
		ArrayList<int[]> cow = new ArrayList<>();
		for(int i=0; i<N; i++) {
			String[] input2 = br.readLine().split(" ");
			cow.add(new int[] {Integer.parseInt(input2[0]), Integer.parseInt(input2[1])});
		}
		// 울타리 위치에 따른 계산
		int tmp = Integer.MAX_VALUE;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				int x = cow.get(i)[0] + 1;								// 울타리 x좌표
				int y = cow.get(j)[1] + 1;								// 울타리 y좌표
				// 사분면에 소가 몇마리인지
				int a=0; int b=0; int c=0; int d=0;
				for(int k=0; k<N; k++) {
					if(cow.get(k)[0] > x && cow.get(k)[1] > y)
						a++;
					else if(cow.get(k)[0] < x && cow.get(k)[1] > y)
						b++;
					else if(cow.get(k)[0] > x && cow.get(k)[1] < y)
						c++;
					else
						d++;
				}
				// M 구하기
				int M = Math.max(a, Math.max(d, Math.max(b, c)));
				tmp = Math.min(tmp, M);
			}
		}
		// 출력
		System.out.print(tmp);
	}
}