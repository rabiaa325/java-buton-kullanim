
package cizgeteorisi;

import java.awt.Component;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputAdapter;
import java.awt.Point;


class DragListener extends MouseInputAdapter {
    Point location;
    MouseEvent mouseBilgi;
    
        @Override
        public void mousePressed(MouseEvent me){//mouse tıklama
            mouseBilgi=me;
        }
      @Override

        public void mouseDragged(MouseEvent me){//mouse sürüklenme
            if (SwingUtilities.isLeftMouseButton(me)==true){
                Component component=me.getComponent();
                location=component.getLocation(location);
                int x=location.x-mouseBilgi.getX()+me.getX();
                int y=location.y-mouseBilgi.getY()+me.getY();
                component.setLocation(x, y);
            }
        
    }
    
}
