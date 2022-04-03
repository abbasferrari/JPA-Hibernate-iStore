package istorejpa.istorejpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import istorejpa.istorejpa.Models.Item;
import istorejpa.istorejpa.Models.OrderTransaction;
import istorejpa.istorejpa.Models.User;
import istorejpa.istorejpa.Repo.ItemRepo;
import istorejpa.istorejpa.Repo.TransactionRepo;
import istorejpa.istorejpa.Repo.UserRepo;

@SpringBootApplication
@PropertySource("classpath:application-${spring.profiles.active:default}.properties")
public class IstoreJpaApplication extends SpringBootServletInitializer {

// 	@Override
// 	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
// 		return application.sources(IstoreJpaApplication.class);
// 	}

	public static void main(String[] args) {
		SpringApplication.run(IstoreJpaApplication.class, args);
	}


	/*@Bean
	public CommandLineRunner runner(UserRepo uRepo, ItemRepo iRepo, TransactionRepo tRepo) {
		return r -> {
			
			uRepo.save(new User("abbas23@gmail.com","abbas22508","Mohamed Abbas","IND","12345","9"));
			uRepo.save(new User("abbas34@gmail.com","abbas32508","Mohamed Abbas","IND","12345","9"));
			
			iRepo.save(new Item(101,"bottle","750ml","Utilities",750.00,uRepo.findById("abbas2508")));
			iRepo.save(new Item(102,"bottle","750ml","Utilities",750.00,uRepo.findById("abbas2508")));
			iRepo.save(new Item("BOOK","20","Utilities",750.00,uRepo.findById("abbas2508")));
			
			tRepo.save(new OrderTransaction(iRepo.findById(1001),uRepo.findByEmail("abbas@gmail.com")));
		
			//Log.info("Users : "+ uRepo.findAll());
			//Log.info("Items(ADS) : "+ iRepo.findAll());
			//Log.info("Transaction : "+ tRepo.findAll());
		};
	}*/
}
