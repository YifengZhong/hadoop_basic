import java.io.ObjectInputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Created by yf_zh on 5/1/2017.
 */
public class FileRead {
    public static final String OUTPUT_DIR = System.getProperty("user.dir")
            + "/storage";
    public static List<String> read(String name) {
        ObjectInputStream in = null;
        List<String> buffer = null;
        try {
            Path path = FileSystems.getDefault().getPath(OUTPUT_DIR.concat("/"), name);
            buffer = Files.readAllLines(path);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if(in != null) {
                try {
                    in.close();
                } catch(Exception e) {}
            }
        }
        return buffer;
    }
}
