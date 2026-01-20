import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr9243 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		String file = br.readLine();
		String delete = br.readLine();
		// 삭제 성공했는지 검증하기
		if(n%2 == 0) {										// 짝수번 덮어씌우기
			if(file.equals(delete))
				System.out.print("Deletion succeeded");
			else
				System.out.print("Deletion failed");
		}
		else {												// 홀수번 덮어씌우기
			for(int i=0; i<file.length(); i++) {
				if(file.charAt(i) == delete.charAt(i)) {
					System.out.print("Deletion failed");
					return;
				}
			}
			System.out.print("Deletion succeeded");
		}
	}
}