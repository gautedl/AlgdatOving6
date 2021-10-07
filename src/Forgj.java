public class Forgj {
    int dist;
    Node forgj;
    static int uendelig = 1000000000;
    Node[] node;

    public int finn_dist(){
        return dist;
    }
    public Node finn_forgj(){
        return forgj;
    }
    public Forgj(){
        dist = uendelig;
    }
    Kø kø = new Kø();


    public void initforgj(Node s){

        for (int i = kø.antall; i--> 0;){
            node[i].d = new Forgj();
        }
        ((Forgj)s.d).dist = 0;
    }
}
