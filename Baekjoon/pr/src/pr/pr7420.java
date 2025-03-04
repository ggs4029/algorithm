// 백준 7420번
// 볼록껍질을 감싸는 맹독 방벽의 최소 길이 구하기.
// 모든 건물들로 부터 l이상의 거리를 유지하도록.
// 방법---------------------
// 건물 수 n과 거리 l이 한 줄에 주어짐.
// 다음 n개 줄에 건물 좌표 x, y가 주어진다.
// 입력 받은거 토대로 모노톤 체인 알고리즘으로 볼록껍질 구하고
// 볼록껍질 둘레 + 곡선 부분 ( = 반지름 l인 원의 둘레) 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class pr7420 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		Point[] p = new Point[n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
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
		// 중복 제거하고 합치기
		upper.pop();
		lower.pop();
		ArrayList<Point> ballLock = new ArrayList<>();
        ballLock.addAll(upper);
        ballLock.addAll(lower);
		// 맹독 방벽 둘레 구하고 출력
		double output = 0;
		for(int i=0; i<ballLock.size(); i++) {
			Point tmp = ballLock.get(i);
			Point tmp2 = ballLock.get((i+1) % ballLock.size());
			output += Math.sqrt((tmp.x - tmp2.x)*(tmp.x - tmp2.x) + (tmp.y - tmp2.y)*(tmp.y - tmp2.y));
		}
		System.out.print(Math.round(2*Math.PI*l + output));
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