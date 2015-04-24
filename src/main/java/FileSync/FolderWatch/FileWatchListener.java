package FileSync.FolderWatch;
import java.io.File;
/**
 * Created by Ady on 2/18/2015.
 */
public interface FileWatchListener {
    void fileScanned(int var1, String var2, String var3, File f);
}