package FileSync;

import FileSync.FolderWatch.FolderWatcher;
import FileSync.UI.test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;
import java.awt.*;

public class MainApp {
    public static void main(String[] args) {
       ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
      //  FolderWatcher fw = context.getBean(FolderWatcher.class);

       SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JPanel panel = new JPanel(new BorderLayout());

                JFrame frame = new JFrame();
                frame.setContentPane(new test().panel);
                // frame.getContentPane().add(panel);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
        
        new LocalFileManager();

    }
}
