// 백준 20949번
// 효정은 ppi가 가장 높은 모니터를 구매하려함.
// ppi는 가로 픽셀 수, 세로 픽셀 수, 대각선의 길이가 주어지면 공식을 통해 구할 수 있음.
// n개의 모니터가 주어지면 ppi가 높은 순으로 모니터를 정렬하는 문제.
// 방법---------------------
// 첫 줄에 모니터의 개수 n이 주어짐.
// 다음 줄부터 n개 줄에 걸쳐 각 모니터들의 가로 픽셀 수 w와 세로 픽셀 수 h가 주어짐.
// 배열리스트에 포인트 클래스로 티비번호랑 w^2 + h^2값 입력 받고
// 제곱값끼리 비교해서 티비넘버 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class pr20949 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		int n = Integer.parseInt(br.readLine());
		ArrayList<Point> tv = new ArrayList<>();
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			tv.add(new Point(i + 1, (int)(Math.pow(w,2)+Math.pow(h,2))));
		}
		// 정렬
		Collections.sort(tv, new Comparator<Point>(){
			@Override
			public int compare(Point x, Point y){
				if(x.wd == y.wd)
					return x.num - y.num;
				else
					return -(x.wd - y.wd);
			}
		});
		// 출력
		for(int i=0; i<n; i++)
			sb.append(tv.get(i).num).append("\n");
		System.out.print(sb.toString().trim());
	}

	// 정렬용 포인트 클래스
	public static class Point {
	    int num = 0;
	    int wd = 0;

	    public Point(int num, int v){
	        this.num = num;
	        this.wd = v;
	    }
	}
}