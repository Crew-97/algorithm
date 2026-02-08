import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] buildPi(char[] p) {
        int m = p.length;
        int[] pi = new int[m];
        int j = 0;

        for (int i = 1; i < m; i++) {
            while (j > 0 && p[i] != p[j]) j = pi[j - 1];
            if (p[i] == p[j]) pi[i] = ++j;
        }
        return pi;
    }

    static boolean kmp(char[] s, char[] p) {
        int n = s.length, m = p.length;
        if (m == 0) return true;

        int[] pi = buildPi(p);
        int j = 0;

        for (int i = 0; i < n; i++) {
            while (j > 0 && s[i] != p[j]) j = pi[j - 1];
            if (s[i] == p[j]) {
                if (j == m - 1) return true; 
                j++;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();
        char[] target = br.readLine().toCharArray();

        System.out.println(kmp(str, target) ? 1 : 0);
    }
}
