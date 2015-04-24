package FileSync.FolderWatch;

import net.contentobjects.jnotify.JNotify;
import net.contentobjects.jnotify.JNotifyException;
import net.contentobjects.jnotify.JNotifyListener;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class FolderWatcher {


    // watch mask, specify events you care about,
    // or JNotify.FILE_ANY for all events.
    int mask = JNotify.FILE_CREATED |
            JNotify.FILE_DELETED |
            JNotify.FILE_MODIFIED |
            JNotify.FILE_RENAMED;

    // watch subtree?
    boolean watchSubtree = true;

    // add actual watch
    int watchID;


    public FolderWatcher(String path, Object Listener) throws InterruptedException, JNotifyException {
        coldStart(path, (FileWatchListener) Listener);
        watchID = JNotify.addWatch(path, mask, watchSubtree, (JNotifyListener) Listener);
    }

    private void coldStart(String path, FileWatchListener listener) {
        File f = new File(path);
        scanDirectory(f,listener);
    }

    private void scanDirectory(File f, FileWatchListener listener) {
        ArrayList<File> files = new ArrayList<File>(Arrays.asList(f.listFiles()));
        for (int i = 0; i < files.size(); i++) {
            File file = files.get(i);
            if (file.isDirectory()) {
                scanDirectory(file, listener);
            }
            try {
                listener.fileScanned(0, file.getCanonicalPath(), file.getName(), file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
