package com.animal.AnimalKingdom;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.DiscriminatorValue;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.animal.AnimalKingdom.Service.AnimalService;
import com.animal.AnimalKingdom.Service.PenService;
import com.animal.AnimalKingdom.Service.ZooService;
import com.animal.AnimalKingdom.birds.Ducks;
import com.animal.AnimalKingdom.birds.Eagles;
import com.animal.AnimalKingdom.birds.Emu;
import com.animal.AnimalKingdom.birds.Geese;
import com.animal.AnimalKingdom.birds.Ostriches;
import com.animal.AnimalKingdom.birds.Parrot;
import com.animal.AnimalKingdom.general.Animal;
import com.animal.AnimalKingdom.mammals.BlackBear;
import com.animal.AnimalKingdom.mammals.BrownBear;
import com.animal.AnimalKingdom.mammals.Cheetah;
import com.animal.AnimalKingdom.mammals.Lion;
import com.animal.AnimalKingdom.mammals.Monkey;
import com.animal.AnimalKingdom.mammals.Polarbear;
import com.animal.AnimalKingdom.mammals.Tiger;
import com.animal.AnimalKingdom.mammals.Wolve;
import com.animal.AnimalKingdom.reptiles.Alligator;
import com.animal.AnimalKingdom.reptiles.Snake;
import com.animal.AnimalKingdom.zoo.Pens;
import com.animal.AnimalKingdom.zoo.Zoo;

@Controller
public class WebController {

	@Autowired 
	AnimalService animalService;
	
	@Autowired 
	PenService penService;
	
	@Autowired 
	ZooService zooService;
	
	@RequestMapping(value = {"","/","/Dashboard"}, method = RequestMethod.GET)
	public String welcomePage(ModelMap model, HttpServletRequest request, HttpServletResponse  response) {
		List<Animal> animals=animalService.loadAllAnimals();
		model.put("animals", animals);
		model.put("animalCount", animals.size());
		return "DashBoard";
		
	}
	
	
	@RequestMapping(value = "/addPen", method = RequestMethod.GET)
	public String addPen(ModelMap model, HttpServletRequest request, HttpServletResponse  response) {
		List<Pens> pens=penService.loadAllPens();
//		pens.forEach(a->System.out.println(a.getPenName()));
		model.put("pens", pens);
		Pens pen=new Pens();
		model.put("pen", pen);
		Map<String, String> penMap=new HashMap<String, String>();
		for (Penstype penstype : Penstype.values()) { 
//		    System.out.println("penstype---->"+penstype.getValue());
		    penMap.put(penstype.getValue(), penstype.getValue());
		}
		model.put("penMap", penMap);
		return "AddPen";
	}
	
	
	@RequestMapping(value = "/savePen", method = RequestMethod.POST)
	public String savePen(ModelMap model, HttpServletRequest request, HttpServletResponse  response,@ModelAttribute Pens penInput) {
		List<Pens> pens=penService.loadAllPens();
		boolean flag=true;
		for(Pens p:pens) {
			if(p.getPenName().equalsIgnoreCase(penInput.getPenName().trim())) {
				flag=false;
				break;
			}
		}
		if(flag) {
			Optional<Zoo> zoo=zooService.findById(1l);
			if(zoo.isPresent()) {
				penInput.setZoo(zoo.get());
				penService.savePen(penInput);
				pens.add(penInput);
			}
		}else {
			model.put("message", "Pen with same name Already Exist..");
		}
		model.put("pens", pens);
		Pens pen=new Pens();
		model.put("pen", pen);
		Map<String, String> penMap=new HashMap<String, String>();
		for (Penstype penstype : Penstype.values()) { 
		    penMap.put(penstype.getValue(), penstype.getValue());
		}
		model.put("penMap", penMap);
		return "AddPen";
	}
	

	
	@RequestMapping(value = "/addAnimal", method = RequestMethod.GET)
	public String addAnimal(ModelMap model, HttpServletRequest request, HttpServletResponse  response) {
		Animal animal=new Animal();
		model.put("animal", animal);
		List<Pens> pens=penService.loadAllPens();
		Map<String, String> penNameMap=new HashMap<String, String>();
		for(Pens p:pens) {
			penNameMap.put(p.getPenName(), p.getPenName());
		}
		model.put("penNameMap", penNameMap);
		
		Map<String, String> animalMap=new HashMap<String, String>();
		for (Animals animal1 : Animals.values()) { 
//			System.out.println("animal---->"+animal1); 
			animalMap.put(animal1.name(), animal1.name());
		}
		model.put("animalMap", animalMap);
		return "addAnimal";
	}
	
	
	@RequestMapping(value = "/EditAnimal", method = RequestMethod.GET)
	public String editAnimal(ModelMap model, HttpServletRequest request, HttpServletResponse  response,@RequestParam(name = "id") Long id) {
		Animal animal=null;
		System.out.println("AnimalId :: "+id);
		Optional<Animal> animalOut=animalService.findAnimalByID(id);
		if(animalOut.isPresent()) {
			animal=animalOut.get();
			animal.setPenName(animal.getPen().getPenName());
			DiscriminatorValue val = animal.getClass().getAnnotation( DiscriminatorValue.class );
			
			animal.setPenType(val.value());
		}else {
			animal=new Animal();
		}
		
		model.put("animal", animal);
		List<Pens> pens=penService.loadAllPens();
		Map<String, String> penNameMap=new HashMap<String, String>();
		for(Pens p:pens) {
			penNameMap.put(p.getPenName(), p.getPenName());
		}
		model.put("penNameMap", penNameMap);
		
		Map<String, String> animalMap=new HashMap<String, String>();
		for (Animals animal1 : Animals.values()) { 
//			System.out.println("animal---->"+animal1); 
			animalMap.put(animal1.name(), animal1.name());
		}
		model.put("animalMap", animalMap);
		return "addAnimal";
	}
	
	
	@RequestMapping(value = "/DeleteAnimal", method = RequestMethod.GET)
	public String deleteAnimal(ModelMap model, HttpServletRequest request, HttpServletResponse  response,@RequestParam(name = "id") Long id) {
		Animal animal=null;
		System.out.println("AnimalId :: "+id);
		Optional<Animal> animalOut=animalService.findAnimalByID(id);
		if(animalOut.isPresent()) {
			animal=animalOut.get();
			animalService.deleteAnimal(animal);
		}
		
		List<Animal> animals=animalService.loadAllAnimals();
		model.put("animals", animals);
		model.put("animalCount", animals.size());
		return "DashBoard";
	}
	
	@RequestMapping(value = "/saveAnimal", method = RequestMethod.POST)
	public String saveAnimal(ModelMap model, HttpServletRequest request, HttpServletResponse  response,@ModelAttribute Animal animalInput) {
		List<Pens> pens=penService.loadAllPens();
		Pens pens2=null;
		for(Pens p:pens) {
			if(p.getPenName().equalsIgnoreCase(animalInput.getPenName().trim())) {
				pens2=p;
				break;
			}
		}
		StringBuilder className=new StringBuilder();
		className.append("com.animal.AnimalKingdom.");
		if(pens2!=null) {
			animalInput.setPen(pens2);
			if(pens2.getPenType().equals(Penstype.Bird.getValue())) {
				className.append("birds");
			}else if(pens2.getPenType().equals(Penstype.Mammal.getValue())) {
				className.append("mammals");
			}else if(pens2.getPenType().equals(Penstype.Reptile.getValue())) {
				className.append("reptiles");
			}
			Animal animal=null;
			try {
				Class c = Class.forName(className+"."+animalInput.getPenType());
				System.out.println("c---->"+c.getSimpleName());
				
				switch (c.getSimpleName()) {
				case "Ducks":
					animal=new Ducks(animalInput);
					break;
				case "Eagles":
					animal=new Eagles(animalInput);
					break;
				case "Emu":
					animal=new Emu(animalInput);
					break;
				case "Geese":
					animal=new Geese(animalInput);
					break;
				case "Ostriches":
					animal =new Ostriches(animalInput);
					break;
				case "Parrot":
					animal =new Parrot(animalInput);
					break;
				case "Cheetah":
					animal=new Cheetah(animalInput);
					break;
				case "Lion":
					animal=new Lion(animalInput);
					break;
				case "Alligator":
					animal=new Alligator(animalInput);
					break;
				case "Tiger":
					animal=new Tiger(animalInput);
					break;
				case "BlackBear":
					animal=new BlackBear(animalInput);
					break;
				case "BrownBear":
					animal=new BrownBear(animalInput);
					break;
				case "Monkey":
					animal=new Monkey(animalInput);
					break;
				case "Polarbear":
					animal=new Polarbear(animalInput);
					break;
				case "Wolve":
					animal=new Wolve(animalInput);
					break;
				case "Snake":
					animal=new Snake(animalInput);
					break;
				default:
					break;
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			if(animal!=null) {
				animalService.save(animal);
			}
		}
		List<Animal> animals=animalService.loadAllAnimals();
//		animals.forEach(a->System.out.println(a.getName()));
//		System.out.println(animals);
		model.put("animals", animals);
		model.put("animalCount", animals.size());
		return "DashBoard";
	}
}
