// 백준 7578번
// 어떤 공장에는 2n개의 기계가 2열에 걸쳐 n개씩 배치되어 있고 이 2개의 열을 각각 a열과 b열이라고 부름.
// a열의 임의의 기계는 B열의 유일한 기계와 케이블로 연결되어 있고,
// b열의 임의의 기계는 a열의 유일한 기계와 케이블로 연결되어 있음.
// 각 기계에는 식별번호가 붙어있고, 짝이 맺어진 기계끼리는 같은 식별번호를 가지고 있음.
// 기계들이 무작위로 배치되어 있고 정수 n과 a열에 위치한 기계, b열에 위치한 기계의 식별번호가
// 각각 순서대로 주어질 때, 서로 교차하는 케이블 쌍의 개수를 세고 출력하는 문제.
// 방법---------------------
// 첫 줄에 n이 주어짐.
// 둘째 줄에 a열의 기계들의 식별번호들이 주어짐.
// 셋째 줄에 b열의 기게들의 식별번호들이 주어짐.
// 서로 교차하는 케이블 쌍의 개수 세는법
// -> 해시맵 사용해 b열의 기계들의 위치를 미리 기록
// -> 새로운 배열 tmp에서 tmp[i] = a열 i번째 기계의 식별번호를 가진 b열 기계의 인덱스
// -> 펜윅 트리 사용해 tmp[i] 전에 처리된 기계들 중 현재 기계보다 인덱스가 큰 기계의 수를 셈
// 펜윅 트리 클래스를 구현해 사용하고
// 교차하는 케이블 쌍의 개수 세서 출력.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class pr7578 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		String[] a = br.readLine().split(" ");
		String[] b = br.readLine().split(" ");
		FenwickTree fTree = new FenwickTree(n);
		// 해시맵에 b열 기계의 식별번호와 인덱스를 기록
		HashMap<String, Integer> m = new HashMap<>();
		for(int i=0; i<n; i++)
			m.put(b[i], i+1);
		int[] tmp = new int[n];
		for(int i=0; i<n; i++)
			tmp[i] = m.get(a[i]);								// a열 i번째 기계의 식별번호를 가진 b열 기계의 인덱스를 저장
		// 교차하는 케이블 쌍의 개수 세기
		long output = 0;
		for(int i=0; i<n; i++) {
			output += fTree.query(n) - fTree.query(tmp[i]-1);	// 교차하는 케이블 쌍 개수 세고
			fTree.update(tmp[i], 1);							// 현재 위치에 해당하는 값을 업데이트
		}
		// 출력
		System.out.print(output);
	}
}

// 펜윅 트리 클래스
class FenwickTree {
	public static int[] tree;

	public FenwickTree(int n) {
		tree = new int[n+1];
	}

	// 펜윅 트리에 값 추가
	public void update(int index, int val) {
		while(index<tree.length) {
			tree[index] += val;
			index += index & -index;
		}
	}

	// 주어진 구간 합 구하기
	public int query(int index) {
		int sum = 0;
		while(index>0) {
			sum += tree[index];
			index -= index & -index;
		}
		return sum;
	}
}