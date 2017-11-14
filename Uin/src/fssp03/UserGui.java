package fssp03;

import java.awt.FlowLayout;

import javax.swing.*;
import java.awt.event.*;
import java.io.File;
public class UserGui implements ActionListener {
	JLabel jlab;
	static File path;
	JButton choiceButton,saveButton;
	UserGui()
	{
		JFrame jfrm=new JFrame("��� 03");
		jfrm.setLayout(new FlowLayout());
		jfrm.setSize(480, 240);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jlab=new JLabel("������� ����");
		jfrm.add(jlab);
		choiceButton=new JButton("�������");
		jfrm.add(choiceButton);
		jfrm.setVisible(true);
	
		 
			choiceButton.addActionListener(new ActionListener()
			{
		public void actionPerformed(ActionEvent ae)
		{
			GetPath();
		}
			});	
		
	}

	
	
	public File GetPath()
	{
	
		JFileChooser dialog=new JFileChooser();
		dialog.setDialogTitle("����� ����������");
		dialog.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		 int result =dialog.showOpenDialog(dialog);
		 if (result == JFileChooser.APPROVE_OPTION )
         JOptionPane.showInputDialog("������ ����",dialog.getSelectedFile());

              
                 try{
                 File file = new File(dialog.getSelectedFile().toString());
		 path=file;
                 }
                 catch(NullPointerException e)
                 {
                    
                  System.exit(0);
                 }  
               
                 return path;
                  
                
             
	}

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("��� �� �� ���"); 
    }
    
    public void showMessage()
    {
        JOptionPane.showMessageDialog(null, "��������� ���������");
       
	
}
    
     public void showErrorMessage()
    {
        JOptionPane.showMessageDialog(null, "�������� �����");
       
	
}

}