// 백준 9698번
// 출제자가 라마단 기간에 새벽기도 하기 전에 아침식사를 할건데.
// 이 시간을 새벽기도 45분 전으로 할거라는 말.
// 출제자는 세계 여행을 하니까 도시마다 시간이 다르므로 각 도시 시간에 45분 뺀 시간을 구하는 문제임.
// 방법---------------------
// 첫 줄에 테스트 케이스의 개수 t가 주어짐.
// 그 후 t줄에 걸쳐 각 줄마다 시간,분인 h, m이 주어짐.
// 45분 뺀 시간 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr9698 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for(int x=1; x<=t; x++) {
			// 입력
			String[] input = br.readLine().split(" ");
			int h = Integer.parseInt(input[0]);
			int m = Integer.parseInt(input[1]);
			if(m>=45)
				m -= 45;
			else {
				if(h>=1)
					h -= 1;
				else
					h = 23;
				m += 15;
			}
			// 출력
			if(m==0)
				System.out.println("Case #"+x+": "+h+" 0");
			else
				System.out.println("Case #"+x+": "+h+" "+m);
		}
	}
}