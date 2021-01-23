package br.com.andrade.marketplace.controller;

import java.math.BigDecimal;
import java.util.HashMap;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.andrade.marketplace.request.ProductRequest;
import br.com.andrade.marketplace.request.SellRequest;
import br.com.andrade.marketplace.response.ProductResponse;
import br.com.andrade.marketplace.service.ApiProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ApiProductService apiProductService;
	
	
	@PostMapping("/add-product")
	public String create(@Valid ProductRequest productRequest, BindingResult result, Model model) {
		apiProductService.save(productRequest);
		return "redirect:/index";
	}
	
	@PostMapping("/sell-product/{idProduct}/{idSalesman}/{idCustomer}/{price}")
	public String sellProduct(@PathVariable("idProduct") Long idProduct ,@PathVariable("idSalesman") Long idSalesman, @PathVariable("idCustomer") Long idCustomer, @PathVariable("price") BigDecimal price, SellRequest sellRequest, BindingResult result, Model model) {
		sellRequest.setIdProduct(idProduct);
		sellRequest.setPrice(price);
		apiProductService.sellProduct(sellRequest);
		return "redirect:/index";
	}
	
	@PostMapping("/update/{id}")
	public String update(@PathVariable("id") Long id, @Valid ProductRequest productRequest, BindingResult result, Model model) {
		productRequest.setId(id);
		apiProductService.update(productRequest);
		return "redirect:/index";
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") Long id, Model model) {
		ProductResponse productResponse = validateProductExists(id);
	    model.addAttribute("product", ProductRequest.parserProductRequest(productResponse));
	    model.addAttribute("categorys", apiProductService.findByCategorys());
	    return "edit-product";
	}
	
	@GetMapping("/delete/{id}")
	public String deletePooduct(@PathVariable("id") Long id, Model model) {
		validateProductExists(id);
		apiProductService.delete(id);
	    return "redirect:/index";
	}
	
	@GetMapping("/sell/{idProduct}/{name}/{price}")
	public String sellProduct(@PathVariable("idProduct") Long idProduct, @PathVariable("name") String name, @PathVariable("price") BigDecimal price, Model model) {
		SellRequest sellRequest = new SellRequest();
		sellRequest.setIdCustomer(1l); //Mock
		sellRequest.setNameCustomer("Costumer name mock"); //Mock
		sellRequest.setIdSalesman(1l); //Mock
		sellRequest.setNameSalesman("Salesman name mock"); //Mock
		sellRequest.setIdProduct(idProduct);
		sellRequest.setNameProduct(name);
		sellRequest.setPrice(price);
		model.addAttribute("sell", sellRequest);
	    return "sell-product";
	}

	private ProductResponse validateProductExists(Long id) {
		ProductResponse productResponse = apiProductService.findBy(id);
		if(productResponse == null) {
			new IllegalArgumentException("Invalid product Id:" + id);
		}
		return productResponse;
	}
	
	@GetMapping("/index")
	public String showUserList(Model model) {
		model.addAttribute("products", apiProductService.findByExampleOrderScoreNameCategory(new HashMap<>()).getProducts());
	    return "index";
	}
	
	@GetMapping("/page-add-product")
	public String goForPageAddProduct(Model model) {
		model.addAttribute("product", new ProductRequest());
		model.addAttribute("categorys", apiProductService.findByCategorys());
		return "page-product";
	}

}
