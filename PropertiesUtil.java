import java.io.InputStream;
import java.util.Properties;

public final class PropertiesUtil {

    private static final Properties prop = new Properties();

    static {
        loadProperties();
    }

    public PropertiesUtil() {}

    public static String getProperties(String key) {
        return prop.getProperty(key);
    }

    public static void loadProperties() {

        try (InputStream is = PropertiesUtil.class.getClassLoader().getResourceAsStream("data.properties")) {
            prop.load(is);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
