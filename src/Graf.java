import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.StringTokenizer;

public class Graf {
    int N, K;
    Node[] node;

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
            Kant k = new Kant(node[til], node[fra].kant1);
            node[fra].kant1 = k;

        }
    }

    public void initforgj(Node s){
        for (int i = N; i--> 0;){
            node[i].d = new Forgj();
        }
        ((Forgj)s.d).dist = 0;
    }

    public void bfs(Node s){
        initforgj(s);
        Kø kø = new Kø();
        kø.leggTilBakerst(s);
        while (!kø.tom()){
            Node n = kø.hentFremste();
            for (Kant k = n.kant1; k != null; k = k.neste){
                Forgj f = (Forgj)k.til.d;
                if (f.dist == Forgj.uendelig){
                    f.dist = ((Forgj)n.d).dist + 1;
                    f.forgj = n;
                    kø.leggTilBakerst(k.til);
                }
            }
            kø.fjernFremste();
        }
    }

    public void lesFraUrl(){
        System.out.println("Node:     Forgj:     Dist:");
        for (int i = 0; i < N; i++){
            int forgj;
            if(((Forgj)node[i].d).forgj == null){
                forgj = -1;
            }else{
                forgj = ((Forgj)node[i].d).forgj.nodeID;
            }
            System.out.println(node[i].nodeID + "      " + forgj + "       " + ((Forgj)node[i].d).dist);
        }
    }

    public Node df_topo(Node n, Node l){
        Topo_lst nd = (Topo_lst) n.d;
        if(nd.funnet) return l;
        nd.funnet = true;
        for(Kant k = n.kant1;k!=null;k=k.neste){
            l = df_topo(k.til,l);
        }
        nd.neste = l;
        System.out.println(n.nodeID);
        return n;
    }

    public Node topologisort(){
        Node l = null;
        for(int i=N;i-->0;){
            node[i].d = new Topo_lst();
        }
        for (int i=N;i-->0;){
            l = df_topo(node[i],l);
        }
        return l;
    }

}
