// 백준 2304번
// 창고 주인은 창고 다각형의 면적이 가장 작은 창고를 만들기를 원한다.
// 기둥들의 위치와 높이가 주어질 때, 가장 작은 창고 다각형의 면적을 구하는 문제.
// 지붕을 만드는 방법(조건)은 문제에 나와있음.
// 방법---------------------
// 첫 줄에 기둥 개수 n이 주어짐.
// 그 다음 n줄에 걸쳐 기둥의 위치 l과 높이 h가 주어짐.
// 왼, 오른쪽에서부터 한번 for문으로 훑어가면서 지붕 만들고
// 넓이 구해서 출력.
// 스택 사용해 배열 값을 기록.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class pr2304 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		int[] roof = new int[1001];
		int l = 888484;
		int r = -1557;
		for(int i=0; i<n; i++) {
			String[] input = br.readLine().split(" ");
			int x = Integer.parseInt(input[0]);
			int y = Integer.parseInt(input[1]);
			roof[x] = y;
			l = Math.min(x, l);								// 왼쪽 끝 기둥 시작점
			r = Math.max(x, r);								// 오른쪽 끝 기둥 시작점
		}
		// 지붕 만들기
		// 왼편
		Stack<Integer> s = new Stack<>();
		int tmp = roof[l];									// 왼쪽 끝 기둥의 높이
		for(int i=l+1; i<=r; i++) {
			if(roof[i]<tmp)									// 지금 높이보다 낮으면
				s.push(i);									// push
			else {
				while(!s.isEmpty()) {
					int tmp2 = s.pop();						// 전의 배열값 가져와서
					roof[tmp2] = tmp;						// 이번 값 넣기
				}
				tmp = roof[i];
			}
		}
		// 오른편
		s = new Stack<>();
		tmp=roof[r];										// 오른쪽 끝 기둥 높이
		for(int i=r-1; i>=l; i--){
			if(roof[i]<tmp)
				s.push(i);
			else {
				while(!s.isEmpty()) {
					int tmp2 = s.pop();
					roof[tmp2]=tmp;
				}
				tmp=roof[i];
			}
		}
		// 창고 넓이 구하기
		int output = 0;
		for(int i=l; i<=r; i++)
			output += roof[i];								// 1칸의 넓이는 1이므로
		// 출력
		System.out.print(output);
	}
}