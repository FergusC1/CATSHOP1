package catalogue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BetterBasketTest {


	@Test
	void testMergeAddProduct() {
		BetterBasket b = new BetterBasket();
		Product p1 = new Product("0001", "Toaster", 10.00, 1);
		Product p2 = new Product("0001", "Toaster", 10.00, 1);
		Product p3 = new Product("0002", "Kettle", 15.00, 1);
		Product p4 = new Product("0002", "Kettle", 15.00, 2);
		
		//test if p1 and p2 are merged
		b.add(p1);
		b.add(p2);
		assertEquals(1, b.size(), "Size incorrect after merge");
		assertEquals(2, b.get(0).getQuantity(), "Quantity incorrect after merge");
		
		//test if p3 gets merged
		b.add(p3);
		assertEquals(2, b.size(), "Size incorrect after non-merge");
		
		//test if p4 merges two into p3
		b.add(p4);
		assertEquals(3, b.get(1).getQuantity(), "quantity incorrect afterreveresed merge");
	}
	

	@Test
	void testSortAddProduct() {
		BetterBasket b = new BetterBasket();
		Product p1 = new Product("0001", "Toaster", 10.00, 1);
		Product p2 = new Product("0002", "Microwave", 50.00, 1);
		Product p3 = new Product("0003", "Kettle", 15.00, 1);
		
		//test do p1 and p3 get sorted
		b.add(p3);
		b.add(p1);
		assertEquals("0001", b.get(0).getProductNum(), "product incorrectly sorted");
		assertEquals("0003", b.get(1).getProductNum(), "product incorrectly sorted");
		
		//test does p2 get correctly inserted
		b.add(p2);
		assertEquals("0001", b.get(0).getProductNum(), "product incorrect after insert");
		assertEquals("0002", b.get(1).getProductNum(), "product incorrect after insert");
		assertEquals("0003", b.get(2).getProductNum(), "product incorrect after insert");
	}


}
