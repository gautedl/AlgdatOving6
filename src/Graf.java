import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Graf {
    int N, K;
    Node[] node;

    //BreddeFørst breddeFørst = new BreddeFørst();


    public void ny_ugraf(URL url) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        node = new Node[N];
        for (int i=0; i<N; ++i) {
            node[i] = new Node();
            node[i].nodeID=i;
        }
        K = Integer.parseInt(st.nextToken());
        for (int i=0; i<K; ++i) {
            st = new StringTokenizer(br.readLine());
            int fra = Integer.parseInt(st.nextToken());
            int til = Integer.parseInt(st.nextToken());
            node[fra].kant1 = new Kant(node[til], node[fra].kant1);

        }
        System.out.println(Arrays.toString(node));
    }

    public void initforgj(Node s){
        for (int i = N; i--> 0;){
            node[i].d = new Forgj();
        }
        s.d.dist = 0;
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

    public void lesFraUrl(){

        System.out.println("Node:     Forgj:     Dist:");
        for (int i = 0; i < N; i++){
            System.out.println(node[i].nodeID + "   " + node[i].d + "    " + node[i].d.dist);
        }

    }


}
