// 백준 4225번
// 어떤 물체가 주어지면 이 물체가 통과할 수 있는 가장 작은 쓰레기 슈트의 너비를 구하는 문제.
// 방법---------------------
// 입력은 여러 개의 테스트 케이스로 이루어져 있음.
// 각 테스트 케이스의 입력 첫 줄은 물체의 꼭짓점의 개수 n이고
// 그 다음 줄부터 n줄에 걸쳐 꼭짓점의 좌표들을 입력 받음. (x, y)
// 마지막 테스트 케이스의 다음 줄에 0을 입력 받는다.
// 볼록 껍질 구하기 - 모노톤 체인 알고리즘 이용.
// 볼록 껍질 만들고 점들 루프로 순회 돌며 수직 거리 구해 ㅊ최소 슈트 너비 구해 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class pr4225 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = 1;														// 테스트 케이스 넘버
		int n = 0;
		while((n = Integer.parseInt(br.readLine())) != 0) {
			// 입력
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
			double suit = Double.MAX_VALUE;
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
				double len = Math.hypot(ballLock.get(j).x - ballLock.get(i).x, ballLock.get(j).y - ballLock.get(i).y);
				// 수직 거리 구하기
				double width = Math.abs(ccw(ballLock.get(i), ballLock.get(j), ballLock.get(tmp))) / len;
				if(width < suit)
					suit = width;
			}
			double output = Math.ceil(suit * 100.0) / 100.0;
			sb.append(String.format("Case %d: %.2f", t, output)).append("\n");
			t++;
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

	// 볼록 껍질 만드는 메소드 - 모노톤 체인
	public static ArrayList<Point> monotone(Point[] p) {
		Arrays.sort(p);
		int n = p.length;
		// 위쪽 볼록 껍질 구하기
		ArrayList<Point> upper = new ArrayList<>();
		for(int i=n-1; i>=0; i--) {
			// 시계방향인 경우 스택의 맨 위를 지우기
			while(upper.size()>=2 && ccw(upper.get(upper.size()-2), upper.get(upper.size()-1), p[i])<=0)
				upper.remove(upper.size()-1);
			upper.add(p[i]);
		}
		// 아래쪽 볼록 껍질 구하기
		ArrayList<Point> lower = new ArrayList<>();
		for(int i=0; i<n; i++) {
			// 시계방향인 경우 스택의 맨 위를 지우기
			while(lower.size()>=2 && ccw(lower.get(lower.size()-2), lower.get(lower.size()-1), p[i])<=0)
				lower.remove(lower.size()-1);
			lower.add(p[i]);
		}
		// 중복 방지 제거
		upper.remove(upper.size()-1);
		lower.remove(lower.size()-1);
		// 하단 껍질과 상단 껍질을 합쳐서 볼록 껍질 완성
		ArrayList<Point> ballLock = new ArrayList<>();
		ballLock.addAll(upper);
		ballLock.addAll(lower);
		return ballLock;
	}
}