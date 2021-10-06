import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.util.StringTokenizer;

public class Main {
    Graf graf = new Graf();
    BreddeFørst breddeFørst = new BreddeFørst();
    Node[] node;

    public void ny_ugraf(URL url) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Node[] node = new Node[N];
        for (int i=0; i<N; ++i) node[i] = new Node();
        int K = Integer.parseInt(st.nextToken());
        for (int i=0; i<K; ++i) {
            st = new StringTokenizer(br.readLine());
            int fra = Integer.parseInt(st.nextToken());
            int til = Integer.parseInt(st.nextToken());
            Kant k = new Kant(node[til], node[fra].kant1);
            node[fra].kant1 = k;
        }
    }

    public void ny_ugraftab(URL url) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
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

    public void lesFraUrl(URL url) throws IOException {

        Kø kø = new Kø();

        ny_ugraf(url);

        for (int i = 0; i < graf.N; i++){
            breddeFørst.bfs(node[i]);
            
        }
    }

    public static void main(String[] args) {
    }
}
