public class Kant {
    Kant neste;
    Node til;

    public Kant(Node n, Kant nst) {
        til = n;
        neste = nst;
    }

    @Override
    public String toString() {
        return "Kant{" +
                "neste=" + neste +
                ", til=" + til +
                '}';
    }
}
