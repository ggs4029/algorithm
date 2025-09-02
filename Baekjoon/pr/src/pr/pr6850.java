// 백준 6850번
// 점의 집합이 주어졌을 때, 볼록 껍질의 넓이를 구하고
// 50으로 나누어 목초지에 소가 몇마리나 살 수 있는지 구하는 문제.
// 방법---------------------
// 첫 줄에 점 개수 n이 주어진다.
// 다음 줄부터 n줄에 걸쳐 x, y좌표가 한 줄에 주어진다.
// 모노톤 체인 알고리즘 사용해 스택으로
// upper 껍질과 lower 껍질을 구하고
// 중복 점 제거해 볼록껍질 합치고 시작점부터 순회하며
// 볼록껍질의 넓이를 구하고 50으로 나눠 소가 몇마리나 살 수 있는지 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class pr6850 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
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
		// 중복 방지 제거
		upper.pop();
		lower.pop();
		ArrayList<Point> ballLock = new ArrayList<>();
		for(Point i : lower)
			ballLock.add(i);
		for(Point i : upper)
			ballLock.add(i);
		// 시작점 찾기
		int tmp = 0;
		for(int i=1; i<ballLock.size(); i++) {
			if(ballLock.get(i).x<ballLock.get(tmp).x ||													// x좌표 먼저 비교하고
					(ballLock.get(i).x==ballLock.get(tmp).x && ballLock.get(i).y<ballLock.get(tmp).y)) {	// 같으면 y좌표로 비교
				tmp = i;
			}
		}
		// 찾은 시작점
		ArrayList<Point> output = new ArrayList<>();
		for(int i=0; i<ballLock.size(); i++)
			output.add(ballLock.get((tmp + i) % ballLock.size()));
		// 볼록껍질의 넓이 구하기
		long extent = 0;
		for(int i=0; i<output.size(); i++) {
			Point tmp2 = output.get(i);
			Point tmp3 = output.get((i+1) % output.size());
			extent += (long) tmp2.x * tmp3.y - (long) tmp2.y * tmp3.x;
		}
		// 출력
		System.out.print(Math.abs(extent) / 2 / 50);
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