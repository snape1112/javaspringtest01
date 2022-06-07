package com.microservice.fibonicci;

import java.util.ArrayList;
import java.util.List;

import com.microservice.fibonicci.model.Fibonicci;
import com.microservice.fibonicci.service.IFibonicciService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

@RestController
public class FibonicciController {

	@Autowired
    private IFibonicciService fibonicciService;
	
	@GetMapping("fibonicci/{number}")
	public ArrayList<Integer> FibonicciController(@PathVariable Integer number){
		ArrayList<Integer> array = new ArrayList<Integer>();
		Integer firstNumber = 0;
		Integer secondNumber = 1;
		Integer summe = 0;
		boolean isBegin = true;

		if(number > 30) {
			System.out.println("You should input number less than 30.");
			return array;
		}
		
		array.add(firstNumber);
		array.add(secondNumber);
		for(int i = 2 ; i <= number; ++i)
		{
			int sum = firstNumber + secondNumber;
			array.add(sum);
			firstNumber = secondNumber;
			secondNumber = sum;
		}

		Fibonicci entity_ = fibonicciService.findByNumber(number);
		if(entity_ != null) {
			entity_.setFrequent(entity_.getFrequent() + 1);
			fibonicciService.save(entity_);
		}
		else {
			Fibonicci entity = new Fibonicci();
			entity.setResult(array.toString());
			entity.setNumber(number);
			entity.setFrequent(1);
			fibonicciService.save(entity);
		} 
		
		return array;
	}
	
	@GetMapping("list")
	public List<Fibonicci> FibonicciList(){
		List<Fibonicci> array = fibonicciService.findAll();
		return array;
	}
}
