// 백준 3679번
// 평면 위의 점의 집합이 주어졌을 때, 다각형을 만드는 문제.
// 가능한 다각형이 여러 가지인 경우에는 아무거나 출력.
// 방법---------------------
// 첫 줄에 테스트 케이스의 개수 c가 주어짐.
// 테스트 케이스의 첫 번째 숫자는 점의 개수 n이고
// 다음 숫자는 점의 좌표 x와 y임.
// 모노톤 체인 알고리즘으로 볼록껍질 구하고
// 인덱스 순열 출력.
// 오답노트------------------
// 볼록껍질 구하는 문제가 아니라 단순 다각형 구하는 문제임을 깨닫기
// 위나 아래 볼록껍질만 모노톤 체인으로 먼저 구하고
// 그 껍질에 포함되지 않는 점들만 정렬순으로 이어주면됨.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class pr3679 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int c = Integer.parseInt(br.readLine());
		for(int i=0; i<c; i++) {
			// 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			Point[] p = new Point[n];
			for(int j=0; j<n; j++) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				p[j] = new Point(x, y, j);
			}
			// 정렬
			Arrays.sort(p);
			// 아래쪽 볼록 껍질 구하기
			boolean[] used = new boolean[n];
			Stack<Point> lower = new Stack<>();
			for(int j=0; j<n; j++) {
				// 시계방향인 경우 스택의 맨 위를 지우기
				while(lower.size()>=2 && ccw(lower.get(lower.size()-2), lower.get(lower.size()-1), p[j])<0) {
					Point tmp = lower.pop();		// lower에 사용되지 않은 점
                    used[tmp.index] = false;
				}
				lower.push(p[j]);					// lower에 사용된 점
                used[p[j].index] = true;
			}
			// sb에 점 추가
			ArrayList<Integer> output = new ArrayList<>();
			for(int j=lower.size()-1; j>=0; j--)	// lower에 사용된 점 추가
				output.add(lower.get(j).index);
			for(Point j : p) {						// lower에 사용되지 않은 점 추가
				if(!used[j.index])
					output.add(j.index);
			}
			for(int j : output)
				sb.append(j).append(" ");
			sb.append("\n");
		}
		// 출력
		System.out.print(sb.toString().trim());
	}

	// 좌표 클래스 + 정렬 메소드
	public static class Point implements Comparable<Point> {
		int x;
		int y;
		int index;

		public Point(int x, int y, int index) {
			this.x = x;
			this.y = y;
			this.index = index;
		}

		// x좌표 우선 정렬, x좌표 같으면 y좌표 기준 정렬
		@Override
		public int compareTo(Point p) {
			if(this.x == p.x)
				return this.y - p.y;
			return this.x - p.x;
		}
	}

	// ccw 메소드
	public static long ccw(Point a, Point b, Point c) {
		// 반시계 방향 = 양수
		// 일직선 = 0
		// 시계 방향 = 음수
		long output = (long)(b.x - a.x) * (c.y - a.y) - (long)(b.y - a.y) * (c.x - a.x);
		return output;
	}
}