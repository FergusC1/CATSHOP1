package advertisements;

import java.awt.Component;
import java.awt.Container;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.RootPaneContainer;

import clients.Picture;
import middle.MiddleFactory;

public class AdvertisementsView implements Observer{
	private static final int H = 300;
	private static final int W = 400;
	
	public class ImageJFrame{
		ImageJFrame(){
			JFrame f = new JFrame("Advert");
			ImageIcon icon = newImageIcon("50.png");
			f.add(newJLabel(icon));
			f.pack();
			f.setVisible(true);
		}

		private Component newJLabel(ImageIcon icon) {
			// TODO Auto-generated method stub
			return null;
		}

		private ImageIcon newImageIcon(String string) {
			// TODO Auto-generated method stub
			return null;
		}
		

			
			
			
		}
	

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	
	public AdvertisementsView( RootPaneContainer rpc, MiddleFactory mf, int x, int y){
		Container cp         = rpc.getContentPane();   
	    Container rootWindow = (Container) rpc;         
	    cp.setLayout(null);                             
	    rootWindow.setSize( W, H );                     
	    rootWindow.setLocation( x, y );
	    new ImageJFrame();
	}

}
