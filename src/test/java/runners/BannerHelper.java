package runners;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BannerHelper {

    private static boolean bannerDisplayed = false;

    public static void displayBanner() {
        if (!bannerDisplayed) {
            try {
                System.out.println("\n");
                System.out.println("=".repeat(70));
                System.out.println("🚀 INICIANDO PRUEBAS AUTOMATIZADAS");
                System.out.println("=".repeat(70));

                InputStream is = BannerHelper.class.getClassLoader()
                        .getResourceAsStream("banner.txt");

                if (is != null) {
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));
                    String line;
                    while ((line = br.readLine()) != null) {
                        System.out.println(line);
                    }
                    br.close();
                }
                bannerDisplayed = true;
            } catch (Exception e) {
                System.err.println("Error cargando banner: " + e.getMessage());
            }
        }
    }
}
