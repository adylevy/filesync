package FileSync.Dal;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class DaoFileObj {
    
    @Id
    @GeneratedValue
    private int id;
    private int serverId;
    private String hash;
    
    @Enumerated
    private FileObjStatus status;
    private String path;
    private String filename;
    private boolean isDirectory;
    
    
    public DaoFileObj() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getServerId() {
        return serverId;
    }
    public void setServerId(int id) {
        this.serverId = id;
    }
    public String getHash() {
        return hash;
    }
    public void setHash(String hash) {
        this.hash = hash;
    }
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    public String getFilename() {
        return filename;
    }
    public void setFilename(String filename) {
        this.filename = filename;
    }
    public boolean getIsDirectory() {
        return isDirectory;
    }
    public void setIsDirectory(boolean isDirectory) {
        this.isDirectory = isDirectory;
    }
    public FileObjStatus getStatus() {
        return status;
    }
    public void setStatus(FileObjStatus status) {
        this.status = status;
    }
}
