package clients.cashier;

import catalogue.Basket;
import middle.MiddleFactory;
import middle.OrderException;
import middle.OrderProcessing;
import middle.StockException;
import middle.StockReadWriter;
import middle.StockReader;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class CashierModelTest {

    private CashierModel cashierModel;
    private Basket basket;

    @Before
    public void setUp() throws Exception {
        // Create a real Basket and add a product to it
        basket = new Basket();
        basket.add(new catalogue.Product("001", "Test Product", 10.0, 5)); // Adding a product to simulate a real scenario

   
        MiddleFactory factory = new MiddleFactory() {
            @Override
            public StockReadWriter makeStockReadWriter() {
                return null; // Not needed for this test
            }

            @Override
            public OrderProcessing makeOrderProcessing() {
                return new OrderProcessing() {
                    @Override
                    public void newOrder(Basket purchased) throws OrderException {
                        // Simulate processing an order
                        if (purchased.size() == 0) {
                            throw new OrderException("Basket is empty!");
                        }
                        // Order processed successfully
                    }

                    @Override
                    public int uniqueNumber() throws OrderException {
                        return 1;
                    }

					@Override
					public Basket getOrderToPick() throws OrderException {
						// TODO Auto-generated method stub
						return null;
					}

					@Override
					public boolean informOrderPicked(int orderNum) throws OrderException {
						// TODO Auto-generated method stub
						return false;
					}

					@Override
					public boolean informOrderCollected(int orderNum) throws OrderException {
						// TODO Auto-generated method stub
						return false;
					}

					@Override
					public Map<String, List<Integer>> getOrderState() throws OrderException {
						// TODO Auto-generated method stub
						return null;
					}
                };
            }

			@Override
			public StockReader makeStockReader() throws StockException {
				// TODO Auto-generated method stub
				return null;
			}
        };

        // Instantiate the CashierModel with the factory
        cashierModel = new CashierModel(factory);


        Field basketField = CashierModel.class.getDeclaredField("theBasket");
        basketField.setAccessible(true);  
        basketField.set(cashierModel, basket);  
    }

    @Test
    public void testDoCancel() {
        // Check that the basket initially has items
        assertEquals(1, basket.size());

        // Perform the cancel operation
        cashierModel.doCancel();

        // Verify that the basket was cleared
        assertEquals(0, basket.size());

        // Verify that the basket is null after cancelling
        assertNull(cashierModel.getBasket());
    }
}
