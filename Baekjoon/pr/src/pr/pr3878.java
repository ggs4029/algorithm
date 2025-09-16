// 백준 3878번
// 평면 위에 여러 개의 검정 점과 흰 점이 있음.
// 직선 하나를 그어 나눠지는 두 그룹을 검은 점, 흰점들의 그룹으로만 만들려고 할 때
// 흰 점과 검은 점의 좌표가 주어졌을 때, 직선으로 점을 분리할 수 있는지 없는지를 알아내야 하는 문제.
// 방법---------------------
// 첫 줄에 테스트 케이스의 개수 t가 주어짐.
// 각 테스트 케이스의 첫 줄은 검은 점 개수 n과 흰 점 개수 m을 입력 받음.
// 그 다음 줄부터 n줄에 걸쳐 검은 점들의 좌표를 입력 받고
// 그 다음  m줄에 걸쳐 흰 점들의 좌표를 입력 받는다.
// 모노톤 체인 알고리즘을 사용해
// 검은 점들로 이루어진 볼록껍질과 흰색 점들로 이루어진 볼록껍질을 구하고
// 두 볼록껍질이 만나거나 한쪽이 한쪽을 포함하는 경우가 아님을 확인해야함.
// 이를 위해 두 볼록껍질의 모든 선분 쌍을 비교해가며 교차하는지 확인
// 이 때 필요한 메소드를 구현
// 1. 볼록껍질 만드는 메소드들
// 2. 선분 두개가 교차하는지 검사하는 메소드
// 3. 2번메소드를 바탕으로 두 볼록껍질이 교차하는지 검사하는 메소드
// 4. 한쪽이 한쪽을 포함하는지 검사하는 메소드
// 이를 구현하고 결과를 출력.
// 오답노트-------------------
// 선분 교차 검사 메소드에서
// 네 점이 다 한 직선에 있을 경우에 대해 따로 예외를 둬야함.
// 네 점이 다 한 직선에 있어도 두 직선이 만날 경우 or 안 만날 경우 둘다 존재함.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class pr3878 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0) {
			// 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			Point[] black_p = new Point[n];
			Point[] white_p = new Point[m];
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				black_p[i] = new Point(x, y);
			}
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				white_p[i] = new Point(x, y);
			}
			ArrayList<Point> black = monotone(black_p, n);
			ArrayList<Point> white = monotone(white_p, m);
			// 두 볼록껍질이 교차하는지 검사
			boolean tmp = true;
			if(ballLock_check(black, white))
				tmp = false;
			// 한쪽이 한쪽 안에 포함되어 었는지 검사
			if(tmp) {
				// 검은색이 더 크고 흰색이 안에 포함되는 경우
				if(!black.isEmpty() && in_check(white, black.get(0)))
					tmp = false;
				// 흰색이 더 크고 검으색이 안에 포함되는 경우
				if(tmp && !white.isEmpty() && in_check(black, white.get(0)))
					tmp = false;
			}
			// 출력
			if(tmp)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}

	// 모노톤 체인 알고리즘을 이용한 볼록껍질 만드는 메소드
	public static ArrayList<Point> monotone(Point[] p, int size) {
		ArrayList<Point> ballLock = new ArrayList<>();
		if(size <= 2) {
			for(int i=0; i<size; i++) {
				ballLock.add(p[i]);
			}
			return ballLock;
		}
		// 정렬
		Arrays.sort(p, 0, size);
		// 윗 껍질 구하기
		Stack<Point> upper = new Stack<>();
		for(int i=size-1; i>=0; i--) {
			while(upper.size()>=2 && ccw(upper.get(upper.size()-2), upper.peek(), p[i])<=0)
				upper.pop();
			upper.add(p[i]);
		}
		// 아래 껍질 구하기
		Stack<Point> lower = new Stack<>();
		for(int i=0; i<size; i++) {
			while(lower.size()>=2 && ccw(lower.get(lower.size()-2), lower.peek(), p[i])<=0)
				lower.pop();
			lower.add(p[i]);
		}
		// 중복 제거
		upper.pop();
		lower.pop();
		for(Point pts : upper)
			ballLock.add(pts);
		for(Point pts : lower)
			ballLock.add(pts);
		// 완성하고 리턴
		return ballLock;
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

	// 선분 두개가 교차하는지 검사하는 메소드
	public static boolean line_check(Point a, Point b, Point c, Point d) {
		long ab = ccw(a, b, c) * ccw(a, b, d);
		long cd = ccw(c, d, a) * ccw(c, d, b);
		// 네 점다 한 직선에 있는 예외 사항
		if(ab==0 && cd==0) {
			Point tmp;
			if(a.compareTo(b) > 0) {
				tmp = a;
				a = b;
				b = tmp;
			}
			if(c.compareTo(d) > 0) {
				tmp = c;
				c = d;
				d = tmp;
			}
			return b.compareTo(c)>=0 && d.compareTo(a)>=0;
		}
		return ab <= 0 && cd <= 0;
	}

	// 두 볼록껍질이 교차하는지 검사하는 메서드
	public static boolean ballLock_check(ArrayList<Point> ballLock1, ArrayList<Point> ballLock2) {
		if(ballLock1.isEmpty() || ballLock2.isEmpty())
			return false;
		for(int i=0; i<ballLock1.size(); i++) {
			Point p1 = ballLock1.get(i);
			Point p2 = ballLock1.get((i+1) % ballLock1.size());
			for(int j=0; j<ballLock2.size(); j++) {
				Point p3 = ballLock2.get(j);
				Point p4 = ballLock2.get((j+1) % ballLock2.size());
				if(line_check(p1, p2, p3, p4))
					return true;
			}
		}
		return false;
	}

	// 한 점이 볼록 껍질 내부에 있는지 확인
	public static boolean in_check(ArrayList<Point> ballLock, Point p) {
		if(ballLock.isEmpty())
			return false;
		if(ballLock.size() == 1)
			return ballLock.get(0).x==p.x && ballLock.get(0).y==p.y;
		// 점이 두개밖에 없으면(선분인 경우)
		if(ballLock.size() == 2) {
			Point a = ballLock.get(0);
			Point b = ballLock.get(1);
			return ccw(a, b, p)==0 && p.x>=Math.min(a.x, b.x) && p.x<=Math.max(a.x, b.x) &&
					p.y>=Math.min(a.y, b.y) && p.y<=Math.max(a.y, b.y);
		}
		// 점 세개이상
		long direction = 0;																			// 방향 부호
		for(int i=0; i<ballLock.size(); i++) {
			Point p1 = ballLock.get(i);
			Point p2 = ballLock.get((i+1) % ballLock.size());
			long tmp = ccw(p1, p2, p);
			if(tmp == 0)
				continue;
			if(direction == 0)
				direction = tmp;
			else if(direction * tmp < 0)															// 방향 바뀌면
			return false;																			// 점은 밖에 존재
		}
		return true;
	}
}