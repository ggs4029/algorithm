// 백준 14725번
// 로봇 개미들이 물어다준 정보를 토대로 개미굴의 구조를 출력하는 문제.
// 출력 형식은 문제 참조.
// 방법---------------------
// 첫 줄에 정보 개수 n을 입력 받음.
// 다음 줄부터 n줄에 걸쳐 정보들을 입력 받음.
// 정보는 먹이 정보 개수 k와 k개의 지나온 방에 있는 먹이 정보들이 한 줄에 주어진다.
// 노드 클래스 구현해 트리맵으로 노드 저장.
// 트리에 노드들 추가하고 구조 출력.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class pr14725 {
	public static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		// 트리 만들고 정보 등록
		int n = Integer.parseInt(br.readLine());
		Node root = new Node();
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			Node tmp = root;
			for(int l=0; l<k; l++) {
				String input = st.nextToken();
				if(!tmp.tree.containsKey(input))
					tmp.tree.put(input, new Node());
				tmp = tmp.tree.get(input);
			}
		}
		// 출력
		printTree(root, 0);
		System.out.print(sb.toString().trim());
	}

	// 노드 정보 기록할 클래스
	public static class Node {
		TreeMap<String, Node> tree = new TreeMap<>();
	}

	// 트리 구조 출력 메소드
	public static void printTree(Node node, int depth) {
		for(String s : node.tree.keySet()) {
			for(int i=0; i<depth; i++)					// 층만큼 -- 추가
				sb.append("--");
			sb.append(s).append("\n");
			printTree(node.tree.get(s), depth+1);
		}

	}
}