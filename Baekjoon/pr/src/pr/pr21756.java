import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class pr21756 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> num = new ArrayList<>();
		for(int i=1; i<=n; i++)
			num.add(i);
		// 작업 진행하고 마지막에 남는 수 찾기
		while(num.size() >= 2) {
			for(int i=0; i<num.size(); i++)
				num.remove(i);
		}
		// 출력
		System.out.print(num.get(0));
	}
}