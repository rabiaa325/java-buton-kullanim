
package cizgeteorisi;

import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Cerceve extends JFrame implements ActionListener   {
    JPanel PANELANA, PANELSAG,PANELSOL;
    JButton BUTONYeniDugum,BUTONTemizle;
    //DragListener mause ile gezdirilmesi için DragListener kullanılır
    DragListener drag=new DragListener();//sürükle bırak y dügüm de yapılır!
    
    public Cerceve(){
        //cerceve oluştur
        super("cizge teorisi");
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setSize(1200,700);//ekran boyutu
         setResizable(false);
         setLocationRelativeTo(null);
         setVisible(true);
         //üzerine bileşen ekle
         setLayout(new BorderLayout());
        //panel oluşturma
      PANELANA = new JPanel();//nesne oluşturma 
      PANELANA. setBackground(Color.WHITE);
      this.add(PANELANA,BorderLayout.CENTER);
      
      PANELANA.setLayout(new BorderLayout());
      
      PANELSOL=new JPanel();
      PANELSOL. setBackground(Color.GRAY);
      PANELANA.add(PANELSOL,BorderLayout.WEST);
      
      PANELSAG=new JPanel();
      PANELSAG. setBackground(Color.WHITE);
      PANELANA. add(PANELSAG,BorderLayout.CENTER);
      
      BUTONYeniDugum=new JButton("Yeni Dugum");
      PANELSOL.add(BUTONYeniDugum);
     
       
      BUTONTemizle=new JButton("Temizle");
      PANELSOL.add(BUTONTemizle);
      
       BUTONYeniDugum.addActionListener(this);
       BUTONTemizle.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if (e.getSource()== BUTONYeniDugum){
           //JOptionPane.showMessageDialog(null,"yeni düğüme tıkladınız","bilgi mesajı", JOptionPane.INFORMATION_MESSAGE);
           Dugum yDugum=new Dugum();
            PANELSAG.add(yDugum);
            PANELSAG.repaint();//bu olmazsa cizmi göstermez
            yDugum.addMouseMotionListener(drag);
            yDugum.addMouseListener(drag);
            //hangi nesne sürüklenecek onla ilgili(mausela)
       }
       else if(e.getSource()== BUTONTemizle){
           PANELSAG.removeAll();
           PANELSAG.repaint();
       }
    }
   
    
}
