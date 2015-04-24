package FileSync.Logic;

import FileSync.BL.FileObj;
import FileSync.ServerData.SDK.User;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Ady on 3/8/2015.
 */
public class ServerUpdater {
    Timer timer;
    public  ServerUpdater(){
        timer = new Timer();
        timer.schedule(new UpdateServerTask(), 5 * 1000, 5 * 1000);
    }

    private class UpdateServerTask extends TimerTask {
        public void run() {
            System.out.println("Looking for changed files...");
            List changedFiles = FileObj.getChangedFiles();
            System.out.println("there are "+changedFiles.size()+" files to push to server");
            //timer.cancel(); //Not necessary because we call System.exit
            User.Login("ady","levy");
        }

    }
}
