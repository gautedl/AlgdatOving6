import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.StringTokenizer;



public class Main {


    public static void main(String[] args) throws IOException {
        Node node = new Node();
        Kø kø = new Kø();
        BreddeFørst breddeFørst = new BreddeFørst();

        Graf graf = new Graf();
        URL url = new URL("http://www.iie.ntnu.no/fag/_alg/uv-graf/L7g1");
        graf.lesFraUrl(url);
        System.out.println(breddeFørst.antall);

    }
}
