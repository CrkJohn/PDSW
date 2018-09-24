package edu.eci.pdsw;

import edu.eci.pdsw.OrderGenerator;
import org.quicktheories.generators.Generate;
import com.google.inject.Guice;
import edu.eci.pdsw.orderCalculator.model.*;
import edu.eci.pdsw.orderCalculator.services.Modulo;
import edu.eci.pdsw.orderCalculator.services.OrdersManager;
import org.quicktheories.core.Gen;
import static org.quicktheories.generators.SourceDSL.*;
import java.util.List;

public class ManagerGenerator {
	public static Gen<OrdersManager> managers() {
		return generatorOrders().map(generatorManager ->{
				OrdersManager manager = Guice.createInjector(new Modulo()).getInstance(OrdersManager.class);
				generatorManager.forEach(d-> manager.placeOrder(d));
				return manager;		
		  });
	}
	

	private static Gen<List<Order>> generatorOrders(){
		return lists().of(OrderGenerator.orders()).ofSizeBetween(0, 20);
	}
}
