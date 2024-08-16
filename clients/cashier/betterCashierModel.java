package clients.cashier;

import catalogue.*;
import middle.MiddleFactory;
import middle.Names;
import middle.RemoteMiddleFactory;

import javax.swing.*;

/**
 * The Improved Cashier Client
 * @author  Fergus Chamberlain
 * @version 2.0
 */


public class betterCashierModel extends CashierModel
{

	public betterCashierModel(MiddleFactory mf) {  // Constructor for betterCashierModel class that takes a MiddleFactory object as a parameter
		super(mf);
		// TODO Auto-generated constructor stub
	}
	@Override //overrides make basket in superclass Cashier Model
    public BetterBasket makeBasket() {
        return new BetterBasket();
    }
  
}
