package FileSync;

import FileSync.BL.FileObj;
import FileSync.Dal.DaoFileObj;
import FileSync.Dal.FileObjStatus;
import FileSync.FolderWatch.FolderWatcher;
import FileSync.Logic.ServerUpdater;
import FileSync.Utils.Crypto;
import net.contentobjects.jnotify.JNotifyListener;

import java.io.File;

/**
 * Created by Ady on 2/16/2015.
 */
public class LocalFileManager {
    // path to watch
    //TODO: move to settings
    private String path = "C:\\fs_origin";// System.getProperty("user.home");

    public LocalFileManager() {
        try {
            FolderWatcher fw = new FolderWatcher(path, new Listener());
            ServerUpdater sw = new ServerUpdater();

        } catch (Exception ex) {
            System.out.println(ex.getCause());
        }

    }
}


class Listener implements JNotifyListener, FileSync.FolderWatch.FileWatchListener {
    public void fileRenamed(int wd, String rootPath, String oldName,
                            String newName) {
      //  DaoFileObj df = getOrAddFile(rootPath,name,null,FileObjStatus.Modified);
        //TODO: add rename functionality
        print("renamed " + rootPath + " : " + oldName + " -> " + newName);
    }

    public void fileModified(int wd, String rootPath, String name) {
        DaoFileObj df = getOrAddFile(rootPath,name,null,FileObjStatus.Modified);
        print("modified " + rootPath + " : " + name);
    }

    public void fileDeleted(int wd, String rootPath, String name) {

        DaoFileObj df = getOrAddFile(rootPath,name,null,FileObjStatus.Removed);
        print("deleted " + rootPath + " : " + name);
    }

    public void fileCreated(int wd, String rootPath, String name) {

        DaoFileObj df = getOrAddFile(rootPath,name,null,FileObjStatus.New);
        print("created " + rootPath + " : " + name+ "::"+df.getHash());

    }

    void print(String msg) {
        System.err.println(msg);
    }

    public void fileScanned(int wd, String fullPath, String name, File f) {

        DaoFileObj df = getOrAddFile(f.getParent(),name,f,FileObjStatus.New);
        print("scanned " + fullPath + " : " + name + " "+df.getHash());
    }
    public DaoFileObj getOrAddFile(String rootPath,String name,File f,FileObjStatus newStatus){
        DaoFileObj df;
       try {
           String fullPath = rootPath + "\\" + name;
           if (f == null) {
               f = new File(fullPath);
           }
           String md5 = Crypto.md5(fullPath);
           df = FileObj.getByHash(md5);
           if (df == null) {
               df = new DaoFileObj();
               df.setHash(md5);
               df.setFilename(name);
               df.setIsDirectory(f.isDirectory());
               df.setStatus(newStatus);
               df.setPath(fullPath);
               FileObj.addFile(df);
           }
           if (df.getStatus() != newStatus && df.getStatus()!=FileObjStatus.New ) {
               df.setStatus(newStatus);
               FileObj.addFile(df);
           }
           return df;
       }
       catch (Exception e){
           System.out.println(e.getCause());
       }
        return null;
    }
}

