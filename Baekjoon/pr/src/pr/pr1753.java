// 백준 1753번
// 방향그래프가 주어지면 주어진 시작점에서 다른 모든 정점으로의 최단 경로를 구하는 문제.
// 모든 간선의 가중치는 10 이하의 자연수이다.
// 방법---------------------
// 첫째 줄에 정점 개수 v, 간선 개수 e 주어짐.
// 둘째 줄에 시작 정점의 번호 k가 주어짐.
// 그 다음 줄부터 e줄에 걸쳐 각 간선을 나타내는 세 개의 정수 u, v, w가 주어짐.
// 다익스트라 알고리즘 메소드 + 가중치 그래프 간선 클래스 사용해
// 그래프 탐색하고 모든 정점으로의 최단 경로 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class pr1753 {
	public static ArrayList<Edge>[] list;
	public static long[] dist;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		list = new ArrayList[V+1];
		dist = new long[V+1];
		for(int i=1; i<=V; i++)
			list[i] = new ArrayList<>();
		for(int i=1; i<=E; i++){
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			long w = Long.parseLong(st.nextToken());
			list[u].add(new Edge(v, w));
		}
		// 다익스트라
		Arrays.fill(dist, Long.MAX_VALUE);
		dijkstra(K);
		// 출력
		for(int i=1; i<=V; i++){
			if(dist[i]!=Long.MAX_VALUE)
				sb.append(dist[i]).append("\n");
			else
				sb.append("INF").append("\n");
		}

		System.out.print(sb.toString().trim());
	}

	// 가중치 그래프의 간선 정보를 표현하는 클래스
	public static class Edge {
		int v;								// 도착지
		long w;								// 가중치

		public Edge(int v, long w){
			this.v = v;
			this.w = w;
		}
	}

	// 다익스트라 메소드
	public static void dijkstra(int s){
		PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
		dist[s] = 0;								// 시작 정점 거리 0
		pq.add(new long[]{dist[s], s});				// 시작 정점 까지의 거리, 정점 번호
		while(!pq.isEmpty()) {
			long[] tmp = pq.poll();
			long tmpDist = tmp[0];
			int u = (int)tmp[1];
			if(tmpDist>dist[u])						// 이미 처리된 간선이면
				continue;
			for(Edge edge : list[u]){				// 인접 정점 탐색
				int v = edge.v;
				long w = edge.w;
				if(dist[v] > dist[u]+w){
					dist[v] = dist[u] + w;
					pq.add(new long[]{dist[v], v});
				}
			}
		}
	}
}