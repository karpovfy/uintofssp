package fssp03;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {
   
    public static void main(String[] args) throws IOException {
        UserGui u=new UserGui();
        
     
     File file = u.GetPath();
     ArrayList<String> files=Uin.getInstance(file).getListFiles(file);
        try {
            Uin.getInstance(file).Work(files);
           u.showMessage();
            
          
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
