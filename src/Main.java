import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public void ny_ugraftab(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Kanttab[][] kant = new Kanttab[N][N];
        for (int i=0; i<N; ++i) for (int j=0; j<N; ++j) kant[i][j] = new Kanttab();
        int K = Integer.parseInt(st.nextToken());
        for (int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            int fra = Integer.parseInt(st.nextToken());
            int til = Integer.parseInt(st.nextToken());
            kant[fra][til].fins=1;
        }
    }
    
    public static void main(String[] args) {
    }
}
