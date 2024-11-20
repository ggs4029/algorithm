import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class pr17165_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] input = new String[n]; int[] result = new int[n];
		for(int i=0; i<n; i++) input[i] = br.readLine();
		int output = 0; int gosu = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++)
				if(input[i].charAt(j)=='W') result[i]++;
			if(result[i]>output) {
				output = result[i]; gosu = i;
			}
		}
		System.out.println((result[gosu] == n - 1 ? 1 : 2) + " " + (gosu + 1));
	}
}