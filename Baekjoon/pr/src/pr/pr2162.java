// 백준 2162번
// 2차원 좌표 평면 위에 n개의 선분들이 있음.
// 두 선분이 서로 만나는 경우를 두 선분은 같은 그룹에 속한다고 정의하고
// 그룹의 크기는 그 그룹에 속한 선분의 개수로 정의할거임.
// n개의 선분들이 주어지면 이 선분들이 총 몇개의 그룹으로 이루어져 있는지,
// 그리고 가장 크기가 큰 그룹에 속한 선분의 개수는 몇 개인지 구하는 문제.
// 방법---------------------
// 첫 줄에 n이 주어짐.
// 다음 줄부터 n줄에 걸쳐 각 선분들의 양 끝점의 좌표가 주어짐. (x, y 좌표가 두개씩)
// 입력 받은 점들 Point 클래스 구현해서 저장하고
// Point 클래스로 구현한 점 두개로 Line 클래스 구현해서 선분으로 저장.
// 이중 for문 돌면서 모든 선분끼리 교차하는지 검사하고
// 교차하면 union메소드로 하나로 묶고 ( 유니온 파인드 알고리즘) 그룹 크기를 갱신함.
// 이중 for문 다 돌고 나왔으면 그룹 개수랑 제일 큰 그룹 크기 출력.
// 오답노트------------------
// union 메소드에서 if문 조건을 x <= y 로 하면
// x = y 일 때 부모가 같은데 합쳐버리는게 됨.
// = 빼고 수정.
// 오답노트2-----------------
// x < y 로 해버리면 정작 x > y 일 때 아무것도 안하잖아.
// x != y로 부모만 다르면 합치도록 수정함.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr2162 {
	public static int[] parent;							// 부모 저장할 배열
    public static int[] group;							// 그룹 크기 저장할 배열

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		Line[] line = new Line[n];
		parent = new int[n];
		group = new int[n];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long x1 = Long.parseLong(st.nextToken());
			long y1 = Long.parseLong(st.nextToken());
			long x2 = Long.parseLong(st.nextToken());
			long y2 = Long.parseLong(st.nextToken());
			line[i] = new Line(new Point(x1, y1), new Point(x2, y2));
			parent[i] = i;
			group[i] = 1;
		}
		// 선분끼리 교차하는지 검사
		for(int i=0; i<n; i++) {
			for(int j= i+1; j<n; j++) {
				if(crossing(line[i], line[j]))			// 교차하면
					union(i, j);						// 합치기
			}
		}
		// 그룹 개수랑 제일 큰 그룹 크기 구하기
		int sum = 0;
		int max = 0;
		for(int i=0; i<n; i++) {
			if(parent[i] == i) {						// 부모면
				sum++;
				if(group[i] > max)
					max = group[i];
			}
		}
		// 출력
		System.out.println(sum);
		System.out.print(max);
	}

	// ccw 메소드
	public static long ccw(Point a, Point b, Point c) {
		// 반시계 방향 = 양수
		// 일직선 = 0
		// 시계 방향 = 음수
		long output = (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
		// 부호만 리턴
		if(output > 0)
			return 1;
		if(output < 0)
			return -1;
		return 0;
	}

	// Point 클래스
	public static class Point {
		long x, y;

		Point(long x, long y) {
			this.x = x;
			this.y = y;
		}
	}

	// Line 클래스
	public static class Line {
		Point x, y;

		Line(Point x, Point y) {
			this.x = x;
			this.y = y;
		}
	}

	// 선분 교차 판별 메소드
	public static boolean crossing(Line l1, Line l2) {
		Point p1 = l1.x;
		Point p2 = l1.y;
		Point p3 = l2.x;
		Point p4 = l2.y;
		long tmp1 = ccw(p1, p2, p3) * ccw(p1, p2, p4);
		long tmp2 = ccw(p3, p4, p1) * ccw(p3, p4, p2);
		if(tmp1<=0 && tmp2<=0) {
			if(tmp1==0 && tmp2==0) {										// 네 점이 다 한줄에 있으면
				if(Math.min(p1.x, p2.x) <= Math.max(p3.x, p4.x) &&			// 점끼리 크기 비교해서 겹치는 부분 있는지
						Math.min(p3.x, p4.x) <= Math.max(p1.x, p2.x) &&
						Math.min(p1.y, p2.y) <= Math.max(p3.y, p4.y) &&
						Math.min(p3.y, p4.y) <= Math.max(p1.y, p2.y))
					return true;
				else
					return false;
			}
			return true;
		}
		return false;
	}

	// 유니온 파인드 - 찾기 연산 메소드
	public static int find(int x) {
		if(parent[x] == x)
			return x;
		else
			return parent[x] = find(parent[x]);			// 경로 압축
	}

	// 유니온 파인드 - 합집합 연산 메소든
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x != y) {									// 부모가 다르면
			parent[x] = y;								// 부모 바꾸기
			group[y] += group[x];						// 그룹 크기 합치기
		}
	}
}