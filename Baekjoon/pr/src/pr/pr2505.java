// 백준 2505번
// 1부터 n까지의 숫자가 차례대로 들어있는 수열 = 초기상태 일때
// 입력으로 주어지는 수열을 두번 뒤집어서 초기 상태로 되돌릴 수 있는
// 그 구간을 순서대로 출력하는 문제.
// 방법---------------------
// 첫 줄에 n을 입력 받음.
// 다음 줄에 두 개의 구간이 뒤집혀진 수열의 상태를 한 줄에 입력 받음.
// 첫번째 뒤집기
// 초기상태가 어그러지기 시작하는 인덱스 구하고
// 그 인덱스에 원래 있어야 되는 값이 어디에 있는지 찾고 그 구간을 뒤집음.
// 두번째 뒤집기
// 초기상태 어그러지기 시작하는 인덱스 +
// 거기서부터 역순으로 가다가 딱 끊기는 지점 찾아 뒤집기
// 오답노트-------------------
// 뒤집기 전에도 초기상태인지 검사하고
// 첫번째 뒤집은 후에도 초기상태인지 검사해야함.
// 초기상태인지 검사하는 부분은 메소드로 따로 빼기.
// 오답노트2------------------
// 입력이
// 10
// 6 5 4 3 2 10 9 8 7 1 이런식으로 들어오면
// 배열을 앞이 아니라 뒤부터 탐색해야 정답 출력이 가능함.
// 이 코드를 추가해야함.
// 원래코드(앞 탐색), 뒤로 탐색 메소드로 나누기.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class pr2505 {
	public static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		n = Integer.parseInt(br.readLine());
		int[] num = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			num[i] = Integer.parseInt(st.nextToken());
		// 이미 초기상태면
		if(sort(num)) {
			System.out.println(1 + " " + 1);
			System.out.print(1 + " " + 1);
			return;
		}
		// 일단 앞에서 탐색
		if(front(num)) {
			return;
		}
		// 앞에서 못하면 뒤에서 탐색
		else
			back(num);
	}

	// 초기상태에서 어그러지는 부분을 앞에서부터 탐색하는 메소드
	public static boolean front(int[] num) {
		int left = 0;														// 초기상태가 어그러지기 시작하는 인덱스를 저장할 변수
		while(left<n && num[left]==left+1)
			left++;
		for(int right=left; right<n; right++) {
			if(num[right] == left+1) {
				int[] num2 = Arrays.copyOf(num, n);
				flip(num2, left, right);									// 첫 뒤집기
				if(sort(num2)) {											// 첫번째 뒤집기만으로 초기상태 됐으면
					System.out.println((left+1) + " " + (right+1));
					System.out.print(1 + " " + 1);
					return true;
				}
				int left2 = 0;												// 어그러지기 시작하는 인덱스 저장할 변수
				while(left2<n && num2[left2]==left2+1)
					left2++;
				int right2 = n - 1;											// 어그러짐이 끝나는 인덱스 저장할 변수
				while(right2>=0 && num2[right2]==right2+1)
					right2--;
				int[] num3 = Arrays.copyOf(num2, n);
				flip(num3, left2, right2);									// 두번째 뒤집기
				if(sort(num3)) {
					System.out.println((left+1) + " " + (right+1));
					System.out.print((left2+1) + " " + (right2+1));
					return true;
				}
			}
		}
		return false;
	}

	// 초기상태에서 어그러지는 부분을 뒤에서부터 탐색하는 메소드
	public static void back(int[] num) {
		int right = n - 1;
		while(right>=0 && num[right]==right+1)
			right--;
		for(int left=right; left>=0; left--) {
			if(num[left] != right+1)
				continue;
			int[] num2 = Arrays.copyOf(num, n);
			flip(num2, left, right);
			if(sort(num2)) {
				System.out.println((left+1) + " " + (right+1));
				System.out.print(1 + " " + 1);
			}
			int left2 = 0;
			while(left2<n && num2[left2]==left2+1)
				left2++;
			int right2 = n - 1;
			while(right2>=0 && num2[right2]==right2+1)
				right2--;
			int[] num3 = Arrays.copyOf(num2, n);
			flip(num3, left2, right2);
			if(sort(num3)) {
				System.out.println((left+1) + " " + (right+1));
				System.out.print((left2+1) + " " + (right2+1));
			}
		}
	}

	// 특정 구간 뒤집는 메소드
	public static void flip(int[] num, int left, int right) {
		while(left < right) {
			int tmp = num[left];
			num[left] = num[right];
			num[right] = tmp;
			left++;
			right--;
		}
	}

	// 초기상태인지 검사 메소드
	public static boolean sort(int[] num) {
		for(int i=0; i<n; i++) {
			if(num[i] != i+1)
				return false;
		}
		return true;
	}
}