import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Graf {
    int N, K;
    Node []node;

    BreddeFørst breddeFørst = new BreddeFørst();


    public void ny_ugraf(URL url) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Node[] node = new Node[N];
        for (int i=0; i<N; ++i) node[i] = new Node();
        K = Integer.parseInt(st.nextToken());
        for (int i=0; i<N; ++i) {
            st = new StringTokenizer(br.readLine());
            int fra = Integer.parseInt(st.nextToken());
            int til = Integer.parseInt(st.nextToken());
            Kant k = new Kant(node[til], node[fra].kant1);
            node[til].kant1 = k;
        }
        System.out.println(Arrays.toString(node));
    }

    public void ny_ugraftab(URL url) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Kanttab[][] kant = new Kanttab[N][N];
        for (int i=0; i<N; ++i) for (int j=0; j<N; ++j) kant[i][j] = new Kanttab();
        K = Integer.parseInt(st.nextToken());
        for (int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            int fra = Integer.parseInt(st.nextToken());
            int til = Integer.parseInt(st.nextToken());
            kant[fra][til].fins=1;

        }
    }

    public void lesFraUrl(URL url) throws IOException {


        ny_ugraf(url);

        System.out.println(N);
        Kø kø = new Kø();

        //System.out.println(node);
        System.out.println(K);

        for (int i = 0; i < N; i++){
            breddeFørst.bfs(node[i]);
        }

        ny_ugraftab(url);

        for (int i = 0; i < N; i++){
            breddeFørst.bfs(node[i]);
        }
        System.out.println(kø.antall);
    }
}
