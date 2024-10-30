// 백준 1197번
// 그래프가 주어지면, 그 그래프의 최소 스패닝 트리를 구하는 문제.
// 최소 스패닝 트리 =  주어진 그래프의 모든 정점들을 연결하는 부분 그래프 중에서 그 가중치의 합이 최소인 트리
// 방법---------------------
// 첫 줄에 정점의 개수 v, 간선의 개수 e가 주어짐.
// 다음줄부터 e줄에 걸쳐 정점 a, 정점 b, 가중치 c가 한줄에 주어진다.
// 입력 받은 간선 리스트를 가중치 오름차순 정렬.
// 최소 스패닝 트리 생성 -> 크루스칼 알고리즘 활용.
// 각 간선에 대해서 사이클을 형성하는지 안하는지 확인하고 트리에 추가.
// 최종적으로 최소 스패닝 트리의 가중치를 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class pr1197 {

	private static int[] parent; // 트리의 각 노드의 부모 노드 번호를 저장할 배열 parent

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input = br.readLine().split(" ");
		int v = Integer.parseInt(input[0]);
		int e = Integer.parseInt(input[1]);
		ArrayList<Edge> edgeList = new ArrayList<>();
		for(int i=0; i<e; i++) {
			String[] input2 = br.readLine().split(" ");
			int a = Integer.parseInt(input2[0]);
			int b = Integer.parseInt(input2[1]);
			int c = Integer.parseInt(input2[2]);
			edgeList.add(new Edge(a, b, c));
		}
		// 가중치 오름차순으로 정렬
		edgeList.sort((x, y) -> x.weight - y.weight);

		// 트리를 이용한 상호배타적 집합 표현
		parent = new int[v + 1];

		// 각 정점으로 구성된 n개의 상호배타적 집합 생성
		for(int x=1; x<=v; x++)
			makeSet(x);

		// 오름차순으로 정렬된 edgeList에서 간선을 하나씩 검사하여, 사이클을 형성하지 않으면 트리 간선(가중치 합에 더함)
		int treeEdgeCount = 0; 								// 트리 간선 수
		int treeWeightSum = 0; 								// 트리 가중치 합
		for(int i=0; (i<e) && (treeEdgeCount<v-1); i++) {
			Edge edge = edgeList.get(i);
			if (findSet(edge.v1) != findSet(edge.v2)) {
				union(edge.v1, edge.v2);
				treeWeightSum += edge.weight;
				treeEdgeCount++;
			}
		}

		// 최소 스패닝 트리의 가중치 출력
		System.out.println(treeWeightSum);
	}

	// 하나의 원소 x로 구성된 집합 생성
	private static void makeSet(int x) {
		parent[x] = x;
	}

	// x의 대표 원소를 알아냄 - 경로압축 사용
	private static int findSet(int x) {
		if (parent[x] != x)
			parent[x] = findSet(parent[x]);
		return parent[x];
	}

	// x가 속한 집합과 y가 속한 집합을 합침
	private static void union(int x, int y) {
		int rootX = findSet(x);
		int rootY = findSet(y);
		// 단순한 union
		if (rootX != rootY) {
			parent[rootY] = rootX; 							// rootX가 rootY의 부모가 됨
		}
	}
}

// 가중치 그래프의 간선 정보를 표현하는 클래스
class Edge {
	int v1, v2; 											// 간선을 이루는 정점 번호
	int weight; 											// 간선 가중치

	public Edge(int v1, int v2, int weight) {
		this.v1 = v1;
		this.v2 = v2;
		this.weight = weight;
	}
}