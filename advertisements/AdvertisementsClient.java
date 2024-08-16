package advertisements;

import javax.swing.JFrame;

import middle.MiddleFactory;



public class AdvertisementsClient {
	
	  private static void displayGUI(MiddleFactory mf)
	  {
	    JFrame  window = new JFrame();     
	    window.setTitle( "Advertisement Client(MVC RMI)" );
	    window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	    
	    AdvertisementsModel model = new AdvertisementsModel(mf);
	    AdvertisementsView  view  = new AdvertisementsView( window, mf, 0, 0 );


	    model.addObserver( view );       // Add observer to the model
	    window.setVisible(true);         // Display Screen
	  }
	}



