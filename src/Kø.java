public class Kø {

    KøNode hode;

    public void leggTilBakerst(KøNode node){
        if(hode==null){
            hode = node;
            return;
        }
        KøNode denne = hode;
        while(denne.neste()!=null){
            denne = denne.neste();
        }
        denne.neste = node;
    }

    public KøNode taUtFremste(){
        KøNode retur = hode;
        retur.neste = null;
        hode = hode.neste();
        return retur;
    }

    private static class KøNode{
        KøNode neste;
        int verdi;

        public KøNode(KøNode neste, int verdi){
            this.neste = neste;
            this.verdi = verdi;
        }

        public KøNode neste(){return neste;}

        public int verdi(){return verdi;}
    }

}
