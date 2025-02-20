// 백준 4181번
// 볼록껍질에 포함된 점과 아닌 점들이 모두 주어지면
// 이 점들을 반시계 방향으로 순서를 매겨 출력하는 문제.
// 방법---------------------
// 첫 줄에 점 개수 n이 주어진다.
// 다음 줄부터 n줄에 x, y좌표와 볼록껍질에 포함되어있는지 여부인 c가 주어진다.
// 볼록껍질에 포함되는 친구들만 p에 add 시키고
// monotone chain 알고리즘으로 볼록껍질 구하고
// 좌표 시작점 구한뒤에 회전 시켜 시작점부터 출력하도록.
// 오답노트------------------
// 볼록껍질에서 pop하는 부분에서 <=0 이 아닌 <0으로 해야함.
// 그래야 세 점이 한 직선에 있을때 가운데 점을 포함할수 있음.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class pr4181 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		ArrayList<Point> p = new ArrayList<>();
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			String c = st.nextToken();
			if(c.equals("Y"))
				p.add(new Point(x, y));
		}
		// 정렬
        Point[] p2 = p.toArray(new Point[p.size()]);
        Arrays.sort(p2);
		// 위쪽 볼록 껍질 구하기
		Stack<Point> upper = new Stack<>();
		for(int i=p2.length-1; i>=0; i--) {
			// 시계방향인 경우 스택의 맨 위를 지우기
			while(upper.size()>=2 && ccw(upper.get(upper.size()-2), upper.get(upper.size()-1), p2[i])<0)
				upper.pop();
			upper.push(p2[i]);
		}
		// 아래쪽 볼록 껍질 구하기
		Stack<Point> lower = new Stack<>();
		for(int i=0; i<p2.length; i++) {
			// 시계방향인 경우 스택의 맨 위를 지우기
			while(lower.size()>=2 && ccw(lower.get(lower.size()-2), lower.get(lower.size()-1), p2[i])<0)
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
		int tmp = 0;
		for(int i=1; i<ballLock.size(); i++) {
			if(ballLock.get(i).x<ballLock.get(tmp).x ||													// x좌표 먼저 비교하고
					(ballLock.get(i).x==ballLock.get(tmp).x && ballLock.get(i).y<ballLock.get(tmp).y)) {	// 같으면 y좌표로 비교
				tmp = i;
			}
		}
		// 찾은 시작점 맨 앞에 두고 출력
		ArrayList<Point> output = new ArrayList<>();
		for(int i=0; i<ballLock.size(); i++)
			output.add(ballLock.get((tmp + i) % ballLock.size()));
		sb.append(output.size()).append("\n");
		for(Point i : output)
			sb.append(i.x + " " + i.y).append("\n");
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