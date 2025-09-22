// 백준 1310번
// n개의 기둥의 좌표가 주어지면
// 가장 멀리 떨어진 두 기둥 사이의 거리의 제곱을 출력하는 문제.
// 방법---------------------
// 첫 줄에 기둥 수 n을 입력 받고
// 그 다음 줄부터 n줄에 걸쳐 박힌 점의 좌표들을 입력 받는다.
// 모노톤 체인 알고리즘으로 볼록껍질 만들고
// 점들 루프 돌면서 거리를 비교해 최대 길이를 구한다.
// 구한 길이의 제곱을 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class pr1310 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
        long len = 0;
		int tmp = 1;
		for(int i=0; i<ballLock.size(); i++) {
			int j = (i + 1) % ballLock.size();
			while(true) {
				int tmp2 = (tmp + 1) % ballLock.size();
				long tmp_area = Math.abs(ccw(ballLock.get(i), ballLock.get(j), ballLock.get(tmp)));
				long tmp2_area = Math.abs(ccw(ballLock.get(i), ballLock.get(j), ballLock.get(tmp2)));
				if(tmp2_area > tmp_area)
					tmp = tmp2;
				else
					break;
			}
			// 두 점 사이 거리 구하기
			long dx = ballLock.get(i).x - ballLock.get(tmp).x;
			long dy = ballLock.get(i).y - ballLock.get(tmp).y;
			len = Math.max(len, dx * dx + dy * dy);
			long dx2 = ballLock.get(j).x - ballLock.get(tmp).x;
			long dy2 = ballLock.get(j).y - ballLock.get(tmp).y;
			len = Math.max(len, dx2 * dx2 + dy2 * dy2);
		}
		// 출력
		System.out.print(len);
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
		// 중복 제거하고 합치기
		upper.remove(upper.size()-1);
		lower.remove(lower.size()-1);
		ArrayList<Point> ballLock = new ArrayList<>();
		ballLock.addAll(upper);
		ballLock.addAll(lower);
		return ballLock;
	}
}