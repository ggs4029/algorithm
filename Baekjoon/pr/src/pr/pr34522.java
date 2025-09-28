// 백준 2025 Centroid Cup N번
// 두 ai의 서버 해킹 대결.
// 서버는 루트를 가지고 정점의 개수가 2^n - 1개인 포화 이진 트리 구조.
// 핑크빈이 먼저 선공하고 번갈아 턴 진행.
// 각 턴에서 ai는 남아 있는 리프 노드 중 하나를 셧다운.
// 어떤 노드의 모든 자식 노드가 셧다운되면 그 노드는 새로운 리프 노드.
// 이때 마지막으로 자식 노드를 셧다운한 ai가 플래그 1개 획득
// 루트 노드만 남을 때까지 게임이 진행됨.
// 플래그 수가 더 많은 ai가 승리 할 때 누가 이기게 될지 구하는 문제.
// 방법---------------------
// 첫 줄에 n이 주어짐.
// 걍 후공이 이기는거 아닌가.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr34522 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		// 출력
		System.out.print("Yeti");
	}
}