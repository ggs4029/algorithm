// 백준 13310번
// 밤하늘에 빛나는 별을 찍으면 찍힌 별들이 2차원 평면의 정수 좌표로 항상 표현됨.
// 날마다 찍은 사진을 비교하니까 어떤 별은 가만히 있고 어떤 별은 등속으로 이동함.
// 이때 별의 이동속도를 [dx, dy]로 표시함.
// 각 별의 속도는 다른 별과 무관하고, 별들은 언제든 서로 겹칠 수 있음.
// 별들의 초기 좌표, 속도, 마지막 촬영일이 주어지면
// 가장 멀리 떨어진 두 별의 거리가 최소인 촬영일과 그 때 거리의 제곱값을 구하는 문제.
// 이런 촬영일이 여러 날이면 그 중 가장 처음 찍은 촬영일로.
// 방법---------------------
// 첫 줄에 별 개수 n과 마지막 촬영일 t가 주어짐.
// 다음 줄부터 n줄에 걸쳐 별의 좌표 x, y와 속도 dx, dy가 주어짐.
// 입력 받는 촬영일 범위가 0 ~ 10^7 -> 삼분탐색으로 가장 멀리 떨어진 두 별의 거리를 구하기
// 가장 멀리 떨어진 두 별의 거리를 구하기 -> 모노톤 체인 + 회전하는 캘리퍼스
// 즉 날짜 t를 기준으로 삼분탐색하며 범위 줄이고
// t일 후의 좌표들은 Point 클래스 확장해서 Star 클래스로 만들어 구하기.
// 그 좌표들로 볼록껍질 + 회전하는 캘리퍼스 구하고
// 최종적으로 구한 범위에서 순회하면서 가장 멀리 떨어진 두 별의 거리가 최소인 촬영일과 그 때 거리의 제곱값을 출력.
// 오답노트------------------
// 회전하는 캘리퍼스 메소드에서 마지막에 거리를 구하는 부분에
// i와 tmp 사이에 대해서만 길이를 구하고 j와 tmp 사이에 대해서는 길이를 구하지 않았음.
// 오답노트2-----------------
// 볼록껍질을 만들때 모노톤 체인 알고리즘에서는 시계 방향으로 만들었음.
// 근데 회전하는 캘리퍼스로 길이를 구하는 과정에서는 반시계 뱡향을 상정하고 코드를 짬.
// 모노톤 체인 메소드의 while문 안의 부등호를 수정.
// 오답노트3-----------------
// 바꾼 모노톤 체인 메소드에서 볼록껍질을 합치는 순서 바꾸기.
// 반시계로 짰으니까 아래쪽부터 (왼 -> 오) 합치기.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class pr13310 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		Star[] star = new Star[n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int dx = Integer.parseInt(st.nextToken());
			int dy = Integer.parseInt(st.nextToken());
			star[i] = new Star(x, y, dx, dy);
		}
		// 삼분탐색
		int left = 0;
		int right = t;
		while(right-left >= 3) {
			int leftThird = left + (right - left) / 3;
			int rightThird = right - (right - left) / 3;
			if(starDistance(star, leftThird, n) <= starDistance(star, rightThird, n))			// 왼쪽 지역이 거리가 더 작거나 같으면
				right = rightThird;																// 오른쪽 지역 버리기
			else																				// 오른쪽 지역이 거리가 더작으면
				left = leftThird;																// 왼쪽 지역 버리기
		}
		// 최소 거리와 최적 날짜 구하기
		int outputT = -1557;
		long min = -1557;
		for(int i=left; i<=right; i++) {
			long tmp = starDistance(star, i, n);
			if(min == -1557 || tmp < min) {
				min = tmp;
				outputT = i;
			}
		}
		// 출력
		System.out.println(outputT);
		System.out.print(min);
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

	// 좌표 클래스에서 확장된 별 좌표 클래스
	public static class Star {
		long x;
		long y;
		long dx;
		long dy;

		public Star(long x, long y, long dx, long dy) {
			this.x = x;
			this.y = y;
			this.dx = dx;
			this.dy = dy;
		}

		public Point getLocation(int t) {
			return new Point(x + t * dx, y + t * dy);
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

	// 볼록껍질 구하는 메소드 - 모노톤 체인
	public static ArrayList<Point> monotone(Point[] p) {
		int n = p.length;																		// 점의 개수
		// 정렬
		Arrays.sort(p);
		// 아래쪽 볼록껍질 구하기
		Stack<Point> lower = new Stack<>();
		for(int i=0; i<n; i++) {
			// 시계방향인 경우 스택의 맨 위를 지우기
			while(lower.size()>=2 && ccw(lower.get(lower.size()-2), lower.peek(), p[i])<=0)
				lower.pop();
			lower.add(p[i]);
		}
		// 위쪽 볼록껍질 구하기
		Stack<Point> upper = new Stack<>();
		for(int i=n-1; i>=0; i--) {
			// 시계방향인 경우 스택의 맨 위를 지우기
			while(upper.size()>=2 && ccw(upper.get(upper.size()-2), upper.peek(), p[i])<=0)
				upper.pop();
			upper.add(p[i]);
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

	// 볼록껍질 사용해 최대 거리 제곱 구하는 메소드 - 회전하는 캘리퍼스
	public static long calipers(ArrayList<Point> ballLock) {
		if(ballLock.size() < 2)
			return 0;
		if(ballLock.size() == 2)
			return distance(ballLock.get(0), ballLock.get(1));
		long distance = 0;
		int tmp = 1;																			// 시작 대척점
		for(int i=0; i<ballLock.size(); i++) {
			int j = (i + 1) % ballLock.size();													// i 다음점
			while(true) {
				int tmp2 = (tmp + 1) % ballLock.size();
				long tmp_area = Math.abs(ccw(ballLock.get(i), ballLock.get(j), ballLock.get(tmp)));
				long tmp2_area = Math.abs(ccw(ballLock.get(i), ballLock.get(j), ballLock.get(tmp2)));
				if(tmp2_area > tmp_area)
					tmp = tmp2;
				else
					break;
			}
			distance = Math.max(distance, distance(ballLock.get(i), ballLock.get(tmp)));
            distance = Math.max(distance, distance(ballLock.get(j), ballLock.get(tmp)));
		}
		return distance;
	}

	// 두 점 간의 거리 구하는 메소드
	public static long distance(Point a, Point b) {
		return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
	}

	// t일 후의 별들 중에서 가장 멀리 떨어진 두 별 사이의 거리의 제곱을 구하는 메소드
	public static long starDistance(Star[] star, int t, int n) {
		Point[] p = new Point[n];
		for(int i=0; i<n; i++)
			p[i] = star[i].getLocation(t);
		ArrayList<Point> ballLock = monotone(p);
		return calipers(ballLock);
	}
}