package view;
import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Album;

public class JTableModel extends JFrame {
	

  public JTableModel(ArrayList<Album> values ) {
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    
    Object[][] data =new Object[values.size()][5];
 
    for(int i=0; i<values.size();i++){

            	data[i][0]=values.get(i).getAlbum();
            	data[i][1]=values.get(i).getArtist();
            	data[i][2]=values.get(i).getGenre();
            	data[i][3]=values.get(i).getRating();
            	data[i][4]=values.get(i).getreview();
    }
    
    JTable table = new JTable(data,
    		
    		new Object[] { "Album","Artist","Genre","Rating","Review" }
    		);
    getContentPane().add(new JScrollPane(table), BorderLayout.CENTER);
    pack();
    
    this.setVisible(true);
  }
  
  
}
