// 백준 1708번
// 점의 집합이 주어졌을 때, 볼록 껍질을 이루는 점의 개수를 구하는 문제.
// 방법---------------------
// 첫 줄에 점 개수 n이 주어진다.
// 다음 줄부터 n줄에 걸쳐 x와 y좌표가 한 줄에 주어짐.
// 모노톤 체인 알고리즘 사용해 스택으로
// upper 껍질과 lower 껍질을 구하고
// 중복 점 제거하고 점 개수 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class pr1708 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Point[] p = new Point[n];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			p[i] = new Point(x, y);
		}
		// 정렬
		Arrays.sort(p);
		// 위쪽 볼록 껍질 구하기
		Stack<Point> upper = new Stack<>();
		for(int i=n-1; i>=0; i--) {
			// 시계방향인 경우 스택의 맨 위를 지우기
			while(upper.size()>=2 && ccw(upper.get(upper.size()-2), upper.get(upper.size()-1), p[i])<=0)
				upper.pop();
			upper.add(p[i]);
		}
		// 아래쪽 볼록 껍질 구하기
		Stack<Point> lower = new Stack<>();
		for(int i=0; i<n; i++) {
			// 시계방향인 경우 스택의 맨 위를 지우기
			while(lower.size()>=2 && ccw(lower.get(lower.size()-2), lower.get(lower.size()-1), p[i])<=0)
				lower.pop();
			lower.add(p[i]);
		}
		// 중복 방지 제거하고 출력 - 끝 값 제거
		upper.pop();
		lower.pop();
		System.out.print(upper.size() + lower.size());
	}

	// 좌표 클래스 + 정렬 메소드
	public static class Point implements Comparable<Point> {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
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