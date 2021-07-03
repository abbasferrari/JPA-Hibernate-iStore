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

import istorejpa.istorejpa.ModelUI.AdItemUI;
import istorejpa.istorejpa.Models.Item;
import istorejpa.istorejpa.Repo.ItemRepo;
import istorejpa.istorejpa.Repo.UserRepo;

@RestController
@CrossOrigin(origins = "http://117.216.103.253:4200")
public class ItemController {

@Autowired
ItemRepo iRepo;

@Autowired
UserRepo uRepo;


//TESTING
@GetMapping("/items")
public String insertItems() {
	iRepo.save(new Item(101,"bottle","750ml","Utilities",750.00,uRepo.findById("abbas2508")));
	iRepo.save(new Item(102,"bottle","750ml","Utilities",750.00,uRepo.findById("abbas2508")));
	iRepo.save(new Item("BOOK","20","Utilities",750.00,uRepo.findById("abbas2508")));
	return "Doneeeeee";
}

@GetMapping("/showAds")
public List<AdItemUI> showAds(){
	ArrayList<AdItemUI> ads = new ArrayList<AdItemUI>();
	for(Item item : iRepo.findAll()) {
		if (item.getStatus() == 0) {
		ads.add(new AdItemUI((int)item.getSerialNo(),String.valueOf(item.getStatus()),String.valueOf(item.getId()),item.getName(),item.getDescription(),
				item.getCategory(),item.getPrice(),item.getSellerId().getEmail(),item.getTimeStamp().toString()));
		}
	}
	
	return ads;
}

@GetMapping("/updateAd/{id}")
public String updateAd(@PathVariable String id) {
	Item temp = iRepo.findById(Integer.parseInt(id));
	temp.setStatus(1);
	iRepo.save(temp);
	return "updated ad";
}

@PostMapping("/searchCat/{category}")
public List<AdItemUI> searchCategory(@PathVariable String category){
	
	if (category != null && category.length() > 0) { 
		List<AdItemUI> ads = new ArrayList<AdItemUI>();	
		for(Item item : iRepo.findByCategory(category)){
				ads.add(new AdItemUI((int)item.getSerialNo(),String.valueOf(item.getStatus()),String.valueOf(item.getId()),item.getName(),item.getDescription(),
						item.getCategory(),item.getPrice(),item.getSellerId().getEmail(),item.getTimeStamp().toString()));
		}
		return ads;
	}
	return null;
}

@PostMapping("/searchAd/{name}")
public List<AdItemUI> searchAds(@PathVariable String name) {
	
	if (name != null && name.length() > 0) { 
		List<AdItemUI> ads = new ArrayList<AdItemUI>();	
		for(Item item : iRepo.findByName(name)){
				ads.add(new AdItemUI((int)item.getSerialNo(),String.valueOf(item.getStatus()),String.valueOf(item.getId()),item.getName(),item.getDescription(),
						item.getCategory(),item.getPrice(),item.getSellerId().getEmail(),item.getTimeStamp().toString()));
		}
		return ads;
	}
	return null;
	
}

@GetMapping("/showAd/{id}")
public Item getItem(@PathVariable String id) {
	return iRepo.findById(Integer.parseInt(id));
}

@PostMapping("/postAd")
public int postAnAd(@RequestBody AdItemUI ad) {
	iRepo.save(new Item(ad.getName(),"null",ad.getCategory(),ad.getPrice(),uRepo.findByEmail(ad.getSellerId())));
	return 200;
}

@GetMapping("/showMyAds/{sellerId}")
public List<AdItemUI> showMyAds(@PathVariable String sellerId){
	ArrayList<AdItemUI> ads = new ArrayList<AdItemUI>();
	for(Item item : iRepo.findBysellerId(sellerId)) {
		ads.add(new AdItemUI((int)item.getSerialNo(),String.valueOf(item.getStatus()),String.valueOf(item.getId()),item.getName(),item.getDescription(),
				item.getCategory(),item.getPrice(),item.getSellerId().getEmail(),item.getTimeStamp().toString()));
	}
	
	return ads;
}

}
