// 백준 1077번
// 두 개의 볼록 다각형이 주어지면 ( 두 볼록 다각형 둘 다 넓이가 0이 아님)
// 두 볼록 다각형의 겹쳐진 부분의 넓이를 구하는 문제.
// 볼록 다각형 1의 꼭짓점은 볼록 다각형 2의 변 위에 있지 않고, 그 반대도 마찬가지임.
// 방법---------------------
// 첫 줄에 볼록 다각형 1의 꼭짓점 개수 n, 볼록 다각형 2의 꼭짓점 개수 m을 한 줄에 입력 받음.
// 입력 받은 점들은 각각의 다각형을 포인트 배열로 만들어서 거기에 저장하고
// 두 다각형끼리 겹치는 부분을 구해야함.
// 두 다각형이 만나서 생기는 교점 - crossing 메소드를 사용해 교점 구해서 검사
// 한 다각형의 꼭짓점이 다른 다각형 안에 있음 - check 메소드 사용해 ccw로 검사
// 그렇게 구한 겹치는 부분들 모아 놓은 배열 리스트 ballLock3에서
// 중복 제거 해주고 넓이 구하기 전에 반시계 방향으로 점들 정렬.
// 정렬은 모노톤 체인 알고리즘으로 볼록껍질 만들어서.
// 만들어진 걸로 신발끈 공식 사용해 넓이 구하고 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class pr1077 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Point[] ballLock1 = new Point[n];							// 볼록 다각형 1
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			ballLock1[i] = new Point(x, y);
		}
		Point[] ballLock2 = new Point[m];							// 볼록 다각형 2
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			ballLock2[i] = new Point(x, y);
		}
		// 다각형끼리 겹치는 부분 구하기
		ArrayList<Point> ballLock3 = new ArrayList<>();
		for(Point i : ballLock1)
			if(check(i, ballLock2))
				ballLock3.add(i);
		for(Point i : ballLock2)
			if(check(i, ballLock1))
				ballLock3.add(i);
		// 선분끼리 교점 찾기
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++)
				crossing(ballLock1[i], ballLock1[(i + 1) % n], ballLock2[j],
						ballLock2[(j + 1) % m], ballLock3);
		}
		if(ballLock3.isEmpty()) {									// 겹치는 부분 하나도 없으면
			System.out.print(0);
			return;
		}
		// 중복 제거
		ArrayList<Point> ballLock4 = new ArrayList<>();
		for(Point i : ballLock3) {
			boolean tmp = true;
			for(Point j : ballLock4) {
				if(j.x==i.x && j.y==i.y) {
					tmp = false;
					break;
				}
			}
			if(tmp)
				ballLock4.add(i);
		}
		// 점들 정렬
		ArrayList<Point> output = monotone(ballLock4);
		// 출력
		System.out.print(extent(output));
	}

	// Point 클래스
	public static class Point implements Comparable<Point> {
		double x, y;

		Point(double x, double y) {
			this.x = x;
			this.y = y;
		}

		// x좌표 우선 정렬, x좌표 같으면 y좌표 기준 정렬
		@Override
		public int compareTo(Point p) {
			if(this.x == p.x)
				return Double.compare(this.y, p.y);
			return Double.compare(this.x, p.x);
		}
	}

	// ccw 메소드
	public static double ccw(Point a, Point b, Point c) {
		// 반시계 방향 = 양수
		// 일직선 = 0
		// 시계 방향 = 음수
		double output = (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
		// 부호만 리턴
		if(output > 0)
			return 1;
		if(output < 0)
			return -1;
		return 0;
	}

	// 점이 볼록 다각형 내부에 있는지 검사하는 메소드
	public static boolean check(Point p, Point[] ballLock) {
		for(int i=0; i<ballLock.length; i++) {
			if(ccw(ballLock[i], ballLock[(i + 1) % ballLock.length], p) < 0)
				return false;
		}
		return true;
	}

	// 선분교차 판별 메소드
	public static void crossing(Point p1, Point p2, Point p3, Point p4, List<Point> ballLock) {
		double den = (p1.x - p2.x) * (p3.y - p4.y) - 				// 분모
				(p1.y - p2.y) * (p3.x - p4.x);
		if(den == 0)												// 평행하면
			return;
		// 교점 좌표 공식을 이용해 교점 좌표 구하기
		double px = ((p1.x * p2.y - p1.y * p2.x) * (p3.x - p4.x) -
				(p1.x - p2.x) * (p3.x * p4.y - p3.y * p4.x)) / den;
		double py = ((p1.x * p2.y - p1.y * p2.x) * (p3.y - p4.y) -
				(p1.y - p2.y) * (p3.x * p4.y - p3.y * p4.x)) / den;
		Point p = new Point(px, py);
		// 교점 범위 안에 있는지 확인하기
		if(Math.min(p1.x, p2.x)<=p.x && p.x<=Math.max(p1.x, p2.x) &&
				Math.min(p1.y, p2.y)<=p.y && p.y<=Math.max(p1.y, p2.y) &&
				Math.min(p3.x, p4.x)<=p.x && p.x<=Math.max(p3.x, p4.x) &&
				Math.min(p3.y, p4.y)<=p.y && p.y<=Math.max(p3.y, p4.y))
			ballLock.add(p);
	}

	// 볼록껍질로 점들 반시계 정렬하기 - 모노톤 체인 알고리즘
	public static ArrayList<Point> monotone(ArrayList<Point> p) {
		int n = p.size();
		if(n <= 2)
			return p;
		// 정렬
		Collections.sort(p);
		// 아래쪽 볼록껍질 구하기
		Stack<Point> lower = new Stack<>();
		for(int i=0; i<n; i++) {
			while(lower.size()>=2 && ccw(lower.get(lower.size()-2), lower.peek(), p.get(i))<=0)
				lower.pop();
			lower.add(p.get(i));
		}
		// 위쪽 볼록껍질 구하기
		Stack<Point> upper = new Stack<>();
		for(int i=n-1; i>=0; i--) {
			while(upper.size()>=2 && ccw(upper.get(upper.size()-2), upper.peek(), p.get(i))<=0)
				upper.pop();
			upper.add(p.get(i));
		}
		// 중복 제거하고 합치기
		lower.pop();
		upper.pop();
		ArrayList<Point> ballLock = new ArrayList<>();
		for(Point i : lower)
			ballLock.add(i);
		for(Point i : upper)
			ballLock.add(i);
		return ballLock;
	}

	// 다각형 넓이 구하는 메소드 - 신발끈 공식
	public static double extent(ArrayList<Point> p) {
		double output = 0;
		int size = p.size();
		for(int i=0; i<size; i++) {
			Point p1 = p.get(i);
			Point p2 = p.get((i + 1) % size);
			output += (p1.x * p2.y) - (p2.x * p1.y);
		}
		return Math.abs(output) / 2.0;
	}
}