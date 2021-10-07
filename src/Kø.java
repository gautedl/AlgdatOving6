public class Kø {

    KøNode hode;
    public int antall;

    public boolean tom(){
        return hode==null;
    }

    public void leggTilBakerst(Node node){
        KøNode køNode = new KøNode(node);
        if(hode==null){
            hode = køNode;
            return;
        }
        KøNode denne = hode;
        while(denne.neste()!=null){
            denne = denne.neste();
        }
        denne.neste = køNode;
        antall++;
    }

    public Node taUtFremste(){
        KøNode retur = hode;
        retur.neste = null;
        hode = hode.neste();
        return retur.node();
    }

    private static class KøNode{
        KøNode neste;
        Node node;

        public KøNode(Node node){
            this.neste = null;
            this.node = node;
        }

        public KøNode neste(){return neste;}

        public Node node(){return node;}
    }

}
