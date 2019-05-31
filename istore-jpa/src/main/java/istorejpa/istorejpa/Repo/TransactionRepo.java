package istorejpa.istorejpa.Repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import istorejpa.istorejpa.ModelUI.OrderTransactionUI;
import istorejpa.istorejpa.Models.OrderTransaction;
import istorejpa.istorejpa.Models.Transaction;

public interface TransactionRepo extends CrudRepository<OrderTransaction,Long>{
	List<OrderTransaction> findAll();
	OrderTransaction findById(Integer transId);
	List<OrderTransaction> findByBuyerId(String buyerId);
	OrderTransaction findByItemId(Integer itemId);
}
