package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Driver;
import com.example.demo.repository.DriverRepository;



@RestController
@RequestMapping("api/v1/")
public class DriverController {
	
	@Autowired
	private DriverRepository driverRepository;
	
	@Autowired
	private UserController userController;
	
	@PostMapping("/driver/create")
	public Driver add_driver(@RequestBody Driver driver) {
		return driverRepository.save(driver);
	}
	
	@GetMapping("/driver/get")
	public List<Driver> getallDrivers(){
		return driverRepository.findAll();
	}

	
	@PutMapping("/driver/updateStatus/{name}")
	public void updateStatus(@PathVariable String name) {
		Driver driver = driverRepository.findbyName(name);
		
		boolean checkStatus = driver.getDriver_available();
		
		if(checkStatus)
			checkStatus = false;
		else
			checkStatus = true;
		
		driver.setDriver_available(checkStatus);
		driverRepository.save(driver);	
	}
	
	public double calculateBill(int current_lat, int current_long, int des_lat, int des_long) {
		double distance = Math.sqrt((current_lat - des_lat) * (current_lat - des_lat) + (current_long - des_long) * (current_long - des_long));
		
		return distance;
	}
	
	
	@GetMapping("/driver/findride/{source_lat}/{source_long}/{des_lat}/{des_long}")
	public List<String> find_ride(@PathVariable int source_lat, @PathVariable int source_long, @PathVariable int des_lat, @PathVariable int des_long){
		
		List<Driver> allDrivers = driverRepository.findbyAvailable(true);
		
		//List<Driver> findRideDrivers = new ArrayList<>();
		
		List<String> findRideDrivers = new ArrayList<>();
		
		for(int i=0;i<allDrivers.size();i++) {
			
			int current_lat = allDrivers.get(i).getDriver_lat();
			int current_long = allDrivers.get(i).getDriver_long();
			double dis = 0;
		    
		    dis = Math.sqrt((current_lat - source_lat) * (current_lat - source_lat) + (current_long - source_long) * (current_long - source_long));
			
		    if(dis<=5) {
		    	findRideDrivers.add(allDrivers.get(i).getDriver_name() + "  [Available]");
		    }
		    
		}
		
		if(findRideDrivers.isEmpty()) {
			findRideDrivers.add("No ride found");
		}
		
		return findRideDrivers;
		
	}
	
	@PutMapping("/driver/updateDriverLocation/{name}/{lat}/{lng}")
	
	public void update_driverLocation(@PathVariable String name, @PathVariable int lat, @PathVariable int lng) {
		Driver driver = driverRepository.findbyName(name);
		
		driver.setDriver_lat(lat);
		driver.setDriver_long(lng);
		driverRepository.save(driver);
		
	}
	//choose_ride(“Rahul”,”Driver1”)
	//Output : ride Started
	
	@PutMapping("/driver/chooseRide/{nameUser}/{nameDriver}/{des_lat}/{des_long}")
	
	public String choose_ride(@PathVariable String nameUser, @PathVariable String nameDriver, @PathVariable int des_lat, @PathVariable int des_long ) {
		
		Driver driver = driverRepository.findbyName(nameDriver);
		
		double billAmount = calculateBill(driver.getDriver_lat(), driver.getDriver_long(),des_lat,des_long);	    
		updateStatus(nameDriver);
		
		double earning = driver.getDriver_earning() + billAmount;
		
		driver.setDriver_earning(earning);
		
		update_driverLocation(nameDriver, des_lat, des_long);
		userController.update_userLocation(nameUser, des_lat, des_long);
		
		
		driverRepository.save(driver);
		
		return "ride Started \n" + "ride Ended bill amount $ " + billAmount;
	}
	
	
	//find_total_earning()
	
	@GetMapping("driver/getAllEarning")
	public List<String> find_total_earning(){
		
		List<Driver> drivers = driverRepository.findAll();
		
		List<String> allEarnings = new ArrayList<>();
		
		for(int i=0;i<drivers.size();i++) {
			String name = drivers.get(i).getDriver_name();
			double earning = drivers.get(i).getDriver_earning();
			
			allEarnings.add(name + " earn $" + earning);
		}
		
		return allEarnings;
	}

	
}
