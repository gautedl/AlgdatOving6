public class BreddeFørst {
    int antall;

    Graf graf = new Graf();

    public void bfs(Node s){
        graf.initforgj(s);
        Kø kø = new Kø();
        kø.leggTilBakerst(s);
        while (!kø.tom()){
            Node n = kø.taUtFremste();
            for (Kant k = n.kant1; k != null; k = k.neste){
                Forgj f = k.til.d;
                if (f.dist == Forgj.uendelig){
                    f.dist = n.d.dist + 1;
                    f.forgj = n;
                    kø.leggTilBakerst(k.til);
                }
            }
        }
    }
}
