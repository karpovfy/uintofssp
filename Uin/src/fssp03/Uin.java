package fssp03;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;


public class Uin {
    private static Uin instance;
    static File pathFolder;
    static String delimiterAllIdReg="/1=03#";
    static String delimiter="/[0-9][0-9]=";
    
    public static synchronized Uin  getInstance(File path)
    {
        if(instance==null)
        {
        instance=new Uin(path);
        instance.getListFiles(pathFolder);
        
        }
        return instance;
    }
    
    private Uin(File path)
    {
       this.pathFolder=path; 
    }
    

   public ArrayList<String> getListFiles(File path)
{

	ArrayList<String> AllFiles=new ArrayList<String>();
	int i=0;			
	
	for (final File fileEntry : path.listFiles()) {
				if (fileEntry.isDirectory()) {
					getListFiles(fileEntry);
				}
		        if(fileEntry.getName().toLowerCase().endsWith(".txt")){
		        	AllFiles.add(path.getAbsolutePath()+File.separatorChar+fileEntry.getName());
		       //System.out.println(fileEntry.getName()+" "+i);
		            i++;
		        }
		    
	}
	
			return AllFiles;	
	
	
	}
    
    
    public  void Work(ArrayList<String> input) throws IOException, ClassNotFoundException
{
	FileInputStream inputStream = null ;
	Scanner sc = null;
	int count=input.size();
	
	for(int i=0;i<count;i++)
	{
	

		File file = new File(pathFolder.getAbsolutePath()+"\\"+"uin"+i+".txt");
	 OutputStreamWriter output4 = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8);
	try {
		
		String[] arr = input.toArray(new String[input.size()]);
		StringBuilder sb = new StringBuilder();
		
	    Locale loc = new Locale("ru", "RU");
	    //System.out.println("+++++++++++++++++++");
            
		inputStream = new FileInputStream(arr[i]);
         
	    sc = new Scanner(inputStream, "UTF-8");
	    sc.useLocale(loc);
	  
	    while (sc.hasNextLine()) {
	        String line = sc.nextLine();
	        if(line.startsWith(delimiterAllIdReg))
	        {
	   
	        	String s=new String();
	            s= (line.replaceAll(delimiter, ";"));
	            output4.write(s+"\n");
	       
	            } 
	            }
	
	    if (sc.ioException() != null) {
	        throw sc.ioException();
	    }
	} finally {
	    if (inputStream != null) {
	        inputStream.close();
	        
	    }
	    if ((sc != null)&&(output4!=null)) {
	        sc.close();
	        output4.close();
	    }
	}
}
}

    
}

