public class Forgj {
    int dist;
    Node forgj;
    static int uendelig = 1000000000;
    public int finn_dist(){
        return dist;
    }
    public Node finn_forgj(){
        return forgj;
    }
    public Forgj(){
        dist = uendelig;
    }

    public void initforgj(Node s){
        for (int i = N; i--> 0;){
            node[i].d = new Forgj();
        }
        ((Forgj)s.d).dist = 0;
    }
}
