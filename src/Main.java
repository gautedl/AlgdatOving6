import java.io.IOException;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws IOException {
        Graf graf = new Graf();
        int startNummer = 5;

        URL url = new URL("http://www.iie.ntnu.no/fag/_alg/uv-graf/L7g1");
        graf.ny_ugraf(url);
        graf.bfs(graf.node[startNummer]);
        graf.lesFraUrl();
        System.out.println("\n");
        graf.topologisort();
    }
}
