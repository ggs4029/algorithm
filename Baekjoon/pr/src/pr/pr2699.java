// 백준 2699번
// 격자점의 집합이 주어지면
// 컨벡스 헐을 일반적인 순서로 출력하는 문제.
// 일반적인 순서란 문제에 자세하게 나와있음.
// 방법---------------------
// 첫 줄에 테스트 케이스의 개수 p가 주어짐.
// 각 테스트 케이스의 첫 줄에는 격자점의 개수 n이 주어짐.
// 그 다음 줄부터 한 줄에 5개의 격자점의 좌표가 주어진다. (x y 즉, 한줄에 10개의 숫자가)
// 모노톤 체인으로 볼록껍질 구하되 입력 받은 좌표들 중에서 변 위에 있는 점은 제거하고 꼭짓점만 포함.
// 좌표 시작점 구한뒤 시계방향으로 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class pr2699 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int p = Integer.parseInt(br.readLine());
		while(p-- > 0) {
			// 입력
			int n = Integer.parseInt(br.readLine());
			ArrayList<Point> ps = new ArrayList<>();
			int tmp = 0;
			while(tmp < n) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				while(st.hasMoreTokens()) {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					ps.add(new Point(x, y));
					tmp++;
				}
			}
			// 정렬
	        Point[] p2 = ps.toArray(new Point[ps.size()]);
	        Arrays.sort(p2);
			// 위쪽 볼록 껍질 구하기
			Stack<Point> upper = new Stack<>();
			for(int i=p2.length-1; i>=0; i--) {
				// 시계방향인 경우 스택의 맨 위를 지우기
				while(upper.size()>=2 && ccw(upper.get(upper.size()-2), upper.get(upper.size()-1), p2[i])<=0)
					upper.pop();
				upper.push(p2[i]);
			}
			// 아래쪽 볼록 껍질 구하기
			Stack<Point> lower = new Stack<>();
			for(int i=0; i<p2.length; i++) {
				// 시계방향인 경우 스택의 맨 위를 지우기
				while(lower.size()>=2 && ccw(lower.get(lower.size()-2), lower.get(lower.size()-1), p2[i])<=0)
					lower.pop();
				lower.push(p2[i]);
			}
			// 중복 방지 제거하고 합치기
			upper.pop();
			lower.pop();
			ArrayList<Point> ballLock = new ArrayList<>();
			for(Point i : lower)
				ballLock.add(i);
			for(Point i : upper)
				ballLock.add(i);
			// 시작점 찾기
			int tmp2 = 0;
			for(int i=1; i<ballLock.size(); i++) {
				if(ballLock.get(i).y>ballLock.get(tmp2).y ||													// y좌표 먼저 비교하고
						(ballLock.get(i).y==ballLock.get(tmp2).y && ballLock.get(i).x<ballLock.get(tmp2).x)) {	// 같으면 x좌표로 비교
					tmp2 = i;
				}
			}
			// 찾은 시작점 맨 앞에 두기
			ArrayList<Point> output = new ArrayList<>();
			for(int i=0; i<ballLock.size(); i++)
				output.add(ballLock.get((tmp2 - i + ballLock.size()) % ballLock.size()));						// 순회 시계방향으로
			sb.append(output.size()).append("\n");
			// 뒤집기
			for(Point i : output)
				sb.append(i.x + " " + i.y).append("\n");
		}
		// 출력
		System.out.print(sb.toString().trim());
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