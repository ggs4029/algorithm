// 백준 6962번
// 숲 주위를 파란 리본으로 둘러싸려함.
// 둘러쌀 범위를 구하는 방법은 문제 참조. (대충 시게방향으로 나무 선택한다는 내용)
// 숲을 둘러싼 리본의 둘레 길이 구하는 문제.
// 방법---------------------
// 첫 줄에 테스트 케이스의 개수 m이 주어짐.
// 각 테스트 케이스의 첫 줄은 나무의 개수 n이 주어짐.
// 그 다음 줄부터 n줄에 걸쳐 나무의 좌표 x, y가 한 줄씩 주어진다.
// 입력 받은 좌표들로 볼록껍질을 모노톤 체인 알고리즘 써서 구하고
// 볼록껍질 시작점 찾아 차례대로 순회하며 볼록껍질 둘레를 구해 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class pr6962 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		int m = Integer.parseInt(br.readLine());
		for(int i=0; i<m; i++) {
			int n = Integer.parseInt(br.readLine());
			Point[] p = new Point[n];
			for(int j=0; j<n; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				p[j] = new Point(x, y);
			}
			// 정렬
			Arrays.sort(p);
			// 아래쪽 볼록껍질 구하기
			Stack<Point> lower = new Stack<>();
			for(int j=0; j<n; j++) {
				// 시계방향인 경우 스택의 맨 위를 지우기
				while(lower.size()>=2 && ccw(lower.get(lower.size()-2), lower.peek(), p[j])<=0)
					lower.pop();
				lower.add(p[j]);
			}
			// 위쪽 볼록껍질 구하기
			Stack<Point> upper = new Stack<>();
			for(int j=n-1; j>=0; j--) {
				// 시계방향인 경우 스택의 맨 위를 지우기
				while(upper.size()>=2 && ccw(upper.get(upper.size()-2), upper.peek(), p[j])<=0)
					upper.pop();
				upper.add(p[j]);
			}
			// 중복 제거하고 합치기
			lower.pop();
			upper.pop();
			ArrayList<Point> ballLock = new ArrayList<>();
			for(Point j : lower)
				ballLock.add(j);
			for(Point j : upper)
				ballLock.add(j);
			// 시작점 찾기
			int tmp = 0;
			for(int j=1; j<ballLock.size(); j++) {
				if(ballLock.get(j).x<ballLock.get(tmp).x ||													// x좌표 먼저 비교하고
						(ballLock.get(j).x==ballLock.get(tmp).x && ballLock.get(j).y<ballLock.get(tmp).y)) {	// 같으면 y좌표로 비교
					tmp = j;
				}
			}
			// 찾은 시작점
			ArrayList<Point> output = new ArrayList<>();
			for(int j=0; j<ballLock.size(); j++)
				output.add(ballLock.get((tmp + j) % ballLock.size()));
			// 볼록껍질 둘레 계산
	        double sum = 0;
	        for(int j=0; j<output.size(); j++) {
	            Point tmp2 = output.get(j);
	            Point tmp3 = output.get((j+1) % output.size());
	            sum += Math.sqrt(Math.pow(tmp2.x - tmp3.x, 2) + Math.pow(tmp2.y - tmp3.y, 2));
	        }
	        sb.append(String.format("%.2f", sum)).append("\n");
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