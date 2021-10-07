public class BreddeFørst {
    int antall;

    Forgj forgj = new Forgj();

    public void bfs(Node s){
        forgj.initforgj(s);
        Kø kø = new Kø();
        kø.leggTilBakerst(s);
        while (kø.tom()){
            Node n = kø.taUtFremste();
            for (Kant k = n.kant1; k != null; k = k.neste){
                Forgj f = (Forgj)k.til.d;
                if (f.dist == Forgj.uendelig){
                    f.dist = ((Forgj)n.d).dist + 1;
                    f.forgj = n;
                    kø.leggTilBakerst(k.til);
                    antall++;
                }
            }
        }
    }
}
