package product.controller;

import java.io.Serializable;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import product.entity.Product;
import product.service.ProductService;

@RestController
@RequestMapping("product")
public class ProductController implements Serializable {

	private static final long serialVersionUID = 1499046711178227904L;

	@Autowired
	private ProductService productService;


	@PostMapping("/save")
	public void save(Product p) {
		productService.save(p);
	}
	@PutMapping("/update")
	public void update(Product p, Integer id) {
		productService.update(p, id);
	}
	
	@DeleteMapping("/delete-by-id")
	public void deleteById(Integer id) {
		productService.delete(id);
	}
	
	@GetMapping("/search")
	public void searchProduct(String keyword) {
		productService.searchProduct(keyword);
	}
	


}
