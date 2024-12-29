// 백준 32219번
// 이진 검색 트리를 전위 순회한 결과가 주어졌을 때, 이 트리를 후위 순회한 결과를 구하는 프로그램을 작성
// 방법---------------------
// 트리를 전위 순회한 결과가 주어짐.
// 이진 검색 트리의 조건에 맞게 메소드를 구현하고.
// 후위 순회 메소드를 만들어 순회 결과를 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr5639 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		Node root = new Node(Integer.parseInt(br.readLine()));					// 첫번쨰 노드가 루트임.
		while(true) {
			String input = br.readLine();
			if(input==null || input.equals(""))
				break;
			root.insert(Integer.parseInt(input.trim()));
		}
		// 출력
		postOrder(root);
	}

	// 이진 검색 트리 메소드
	public static class Node {
		int num;
		Node l;
		Node r;

		Node(int num) {
			this.num = num;
		}

		Node(int num, Node l, Node r) {
			this.num = num;
			this.l = l;
			this.r = r;
		}

		// 노드 삽입
		public void insert(int n) {
			if(n<this.num) {					// 왼쪽 트리
				if(this.l==null)
					this.l = new Node(n);
				else
					this.l.insert(n);
			}
			else {								// 오른쪽 트리
				if(this.r==null)
					this.r = new Node(n);
				else
					this.r.insert(n);
			}
		}
	}

	// 후위 순회 메소드
	public static void postOrder(Node node) {
		if(node==null)
			return;
		postOrder(node.l);						// 왼쪽 먼저
		postOrder(node.r);						// 그다음 오른쪽
		System.out.println(node.num);
	}
}