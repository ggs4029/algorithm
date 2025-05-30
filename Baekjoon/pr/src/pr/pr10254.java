// 백준 10254번
// n개의 도시 중 유클리드 거리가 가장 먼 두 도시의 좌표들을 출력하는 문제.
// 방법---------------------
// 입력은 여러 개의 테스트 케이스로 이루어져 있음.
// 각 테스트 케이스의 입력 첫 줄은 도시의 개수 n을 입력 받고
// 그 다음 줄부터 n줄에 걸쳐 도시의 좌표들을 입력 받음.
// 볼록 껍질은 모노톤 체인 알고리즘으로 구하고
// 점들 루프 돌면서 서로 거리 비교해 최대 길이일 떄의 도시 좌표들을 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class pr10254 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for(int k=0; k<t; k++) {
			// 입력
			int n = Integer.parseInt(br.readLine());
			Point[] p = new Point[n];
			for(int i=0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				long x = Long.parseLong(st.nextToken());
				long y = Long.parseLong(st.nextToken());
				p[i] = new Point(x, y);
			}
			// 볼록 껍질 만들기
			ArrayList<Point> ballLock = monotone(p);
			// 점들 돌며 최대 너비 구하기
			double distance = 0;
			long x1 = 0, y1 = 0;
			long x2 = 0, y2 = 0;
			int tmp = 1;												// 시작 점(지금 점)
			for(int i=0; i<ballLock.size(); i++) {
				int j = (i + 1) % ballLock.size();						// i 다음에 오는 점
				while (true) {
					int tmp2 = (tmp + 1) % ballLock.size();
					long tmp_area = Math.abs(ccw(ballLock.get(i), ballLock.get(j), ballLock.get(tmp)));
					long tmp2_area = Math.abs(ccw(ballLock.get(i), ballLock.get(j), ballLock.get(tmp2)));
					if(tmp2_area > tmp_area)
						tmp = tmp2;
					else
						break;
				}
				// 거리 구하고 비교하기
				Point p1 = ballLock.get(i);
				Point p2 = ballLock.get(j);
				Point pt = ballLock.get(tmp);
				double len1 = Math.hypot(p1.x - pt.x, p1.y - pt.y);
				if(len1 > distance) {
					distance = len1;
					x1 = p1.x;
					y1 = p1.y;
					x2 = pt.x;
					y2 = pt.y;
				}
				double len2 = Math.hypot(p2.x - pt.x, p2.y - pt.y);
				if(len2 > distance) {
					distance = len2;
					x1 = p2.x;
					y1 = p2.y;
					x2 = pt.x;
					y2 = pt.y;
				}
			}
			sb.append(x1 + " " + y1 + " " + x2 + " " + y2).append('\n');
		}
		// 출력
		System.out.print(sb.toString().trim());
	}

	// 좌표 클래스 + 정렬 메소드
	public static class Point implements Comparable<Point> {
		long x;
		long y;

		public Point(long x, long y) {
			this.x = x;
			this.y = y;
		}

		// x좌표 우선 정렬, x좌표 같으면 y좌표 기준 정렬
		@Override
		public int compareTo(Point p) {
			if(this.x == p.x)
				return Long.compare(this.y, p.y);
			return Long.compare(this.x, p.x);
		}
	}

	// ccw 메소드
	public static long ccw(Point a, Point b, Point c) {
		// 반시계 방향 = 양수
		// 일직선 = 0
		// 시계 방향 = 음수
		long output = (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
		return output;
	}

	// 볼록 껍질 - 모노톤 체인
	public static ArrayList<Point> monotone(Point[] p) {
		Arrays.sort(p);
		int n = p.length;
		// 위쪽 볼록 껍질
		ArrayList<Point> upper = new ArrayList<>();
		for(int i=n-1; i>=0; i--) {
			// 시계방향인 경우 스택의 맨 위를 지우기
			while(upper.size()>=2 && ccw(upper.get(upper.size()-2), upper.get(upper.size()-1), p[i])<=0)
				upper.remove(upper.size()-1);
			upper.add(p[i]);
		}
		// 아래쪽 볼록 껍질
		ArrayList<Point> lower = new ArrayList<>();
		for(int i=0; i<n; i++) {
			// 시계방향인 경우 스택의 맨 위를 지우기
			while(lower.size()>=2 && ccw(lower.get(lower.size()-2), lower.get(lower.size()-1), p[i])<=0)
				lower.remove(lower.size()-1);
			lower.add(p[i]);
		}
		// 중복 제거
		upper.remove(upper.size()-1);
		lower.remove(lower.size()-1);
		// 위아래 합치기
		ArrayList<Point> ballLock = new ArrayList<>();
		ballLock.addAll(upper);
		ballLock.addAll(lower);
		return ballLock;
	}
}