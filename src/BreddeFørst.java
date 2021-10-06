public class BreddeFørst {
    public Node[] node;
    public int antallNoder = node.length;

    Forgj forgj = new Forgj();

    public void bfs(Node s){
        forgj.initforgj(s);
        Kø kø = new Kø(N - 1);
        kø.leggIKø(s);
        while (kø.tom()){
            Node n = (Node)kø.nesteIKø();
            for (Kant k = n.kant1; k != null; k = k.neste){
                Forgj f = (Forgj)k.til.d;
                if (f.dist == f.uendelig){
                    f.dist = ((Forgj)n.d).dist + 1;
                    f.forgj = n;
                    kø.leggIKø(kø.til);
                }
            }
        }
    }
}
