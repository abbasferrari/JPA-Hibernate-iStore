package istorejpa.istorejpa.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import istorejpa.istorejpa.ModelUI.OrderTransactionUI;
import istorejpa.istorejpa.Models.Item;
import istorejpa.istorejpa.Models.OrderTransaction;
import istorejpa.istorejpa.Models.User;
import istorejpa.istorejpa.Repo.ItemRepo;
import istorejpa.istorejpa.Repo.TransactionRepo;
import istorejpa.istorejpa.Repo.UserRepo;



@RestController
//@CrossOrigin(origins = "https://istore-angular.herokuapp.com")
public class TransactionController {

@Autowired
TransactionRepo tRepo;

@Autowired
ItemRepo iRepo;

@Autowired
UserRepo uRepo;

//TESTING
@GetMapping("/t")
public String getTrans() {
	User u = uRepo.findByEmail("abbas@gmail.com");
	Item i = iRepo.findById(101);
	OrderTransaction o = new OrderTransaction(i, u);
	tRepo.save(new OrderTransaction(iRepo.findById(1001),uRepo.findByEmail("abbas@gmail.com")));
	return "transc ontrolelerlerler";
}

@PostMapping("/checkOutAd")
public String checkOut(@RequestBody OrderTransactionUI obj) {
		try {
		System.out.println(obj.toString());
		Item temp = iRepo.findById(Integer.parseInt(obj.getItemId()));
		temp.setStatus(1);
		iRepo.save(temp);
		return tRepo.save(new OrderTransaction(iRepo.findById(Integer.parseInt(obj.getItemId())),uRepo.findByEmail(obj.getBuyerId()))).getId().toString();
		
		}
		catch(Exception e) {
			return null;
		}
}



@GetMapping("/searchTrans")
public List<OrderTransactionUI> getAllTrans(){
	ArrayList<OrderTransactionUI> orderTrans = new ArrayList<OrderTransactionUI>();
	for(OrderTransaction order : tRepo.findAll()) {
		orderTrans.add(	new OrderTransactionUI(
				        String.valueOf(order.getId()),
						String.valueOf(order.getItemId().getId()),
						order.getBuyerId().getEmail()));
	}
	return orderTrans;
}

@GetMapping("/searchOrder/{id}")
public OrderTransaction getTransObj(@PathVariable String id) {
	return tRepo.findById(Integer.parseInt(id));
}

@GetMapping("/searchOrders/{buyerId}")
public List<OrderTransactionUI> getOrderDetailsById(@PathVariable String buyerId){
	ArrayList<OrderTransactionUI> orderTrans = new ArrayList<OrderTransactionUI>();
	for(OrderTransaction order : tRepo.findByBuyerId(buyerId)) {
		orderTrans.add(	new OrderTransactionUI(
				        String.valueOf(order.getId()),
						String.valueOf(order.getItemId().getId()),
						order.getBuyerId().getEmail()));
	}
	return orderTrans;
}

}
