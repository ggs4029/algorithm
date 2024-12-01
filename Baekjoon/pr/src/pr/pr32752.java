// 백준 ???번 - B번 수열이에요?
// 길이 n인 정수열 a가 있고 a의 l번째 원소부터 r번째 원소의 순서를 임의로 재배치 할 때,
// 단조증가하는 수열로 만들 수 있는지 확인하는 문제.
// 방법---------------------
// 첫 줄에 n, l, r이 입력으로 주어짐.
// 두번째 줄에 정수열 a가 주어진다.
// 재배치할 구간만 따로 빼서 정렬하고 다시 배열에 박은 뒤에
// 단조 증가인지 for문을 돌며 검사하고 결과를 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class pr32752 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int l = Integer.parseInt(input[1]) - 1;
		int r = Integer.parseInt(input[2]) - 1;
		int[] a = new int[n];
		String[] input2 = br.readLine().split(" ");
		for(int i=0; i<n; i++)
			a[i] = Integer.parseInt(input2[i]);
		// l~r구간만 따로 빼서 졍렬
		int[] tmpArray = Arrays.copyOfRange(a, l, r+1);
		Arrays.sort(tmpArray);
		// 바뀐 배열
		for(int i=0; i<tmpArray.length; i++)
            a[l+i] = tmpArray[i];
		// 단조 증가인지 검사
		boolean output = true;
		for (int i=1; i<n; i++) {
			if(a[i-1]>a[i]) {								// 전 값이 더 크면
				output = false;								// 단조증가 아님
				break;
			}
		}
		// 출력
		if(output)
			System.out.print(1);
		else
			System.out.print(0);
	}
}