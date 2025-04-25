import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr25372 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // 입력
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            String s = br.readLine();
            if(s.length()>=10 || s.length()<6)
                sb.append("no");
            else
                sb.append("yes");
            sb.append("\n");
        }
        System.out.print(sb.toString().trim());
    }
}