// 백준 9240번
// 화살을 총 c발 쏘았을 때, 화살의 좌표가 주어지면 가장 먼 화살의 거리를 구하는 문제.
// 가장 먼 두 화살의 거리를 구하면 된다.
// 방법---------------------
// 첫 줄에 발사한 화살 수 c를 입력 받고
// 그 다음 줄부터 c줄에 걸쳐 박힌 화살들의 좌표들을 입력 받음. (x, y)
// 볼록 껍질 구하기 - 모노톤 체인 알고리즘 사용.
// 볼록 껍질 만들고 점들 루프 돌면서 거리 비교해 최대 길이를 구한다.
// 최대 길이 소수점 여섯째 자리까ㅣㅈ 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class pr9240 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int c = Integer.parseInt(br.readLine());
		Point[] p = new Point[c];
		for(int i=0; i<c; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long x = Long.parseLong(st.nextToken());
			long y = Long.parseLong(st.nextToken());
			p[i] = new Point(x, y);
		}
		// 볼록 껍질 만들기
		ArrayList<Point> ballLock = monotone(p);
		// 점들 돌며 최대 너비 구하기
		double arrow = Double.MIN_VALUE;
		int tmp = 1;												// 시작 점(지금 점)
		for(int i=0; i<ballLock.size(); i++) {
			int j = (i + 1) % ballLock.size();						// i 다음에 오는 점
			while(true) {
				int tmp2 = (tmp + 1) % ballLock.size();				// tmp 다음에 오는 점
				long tmp_area = Math.abs(ccw(ballLock.get(i), ballLock.get(j), ballLock.get(tmp)));
				long tmp2_area = Math.abs(ccw(ballLock.get(i), ballLock.get(j), ballLock.get(tmp2)));
				if(tmp2_area > tmp_area)
					tmp = tmp2;
				else
					break;
			}
			// 두 점 사이 거리 구하기
			Point pt  = ballLock.get(tmp);
			Point p1  = ballLock.get(i);
			Point p2 = ballLock.get(j);
			double len1 = Math.hypot(p1.x  - pt.x,  p1.y  - pt.y);
			double len2 = Math.hypot(p2.x - pt.x, p2.y - pt.y);
			arrow = Math.max(arrow, Math.max(len1, len2));
		}
		// 출력
		System.out.print(String.format("%.6f\n", arrow));
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