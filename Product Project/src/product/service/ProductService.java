package product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import product.VO.ProductVO;
import product.entity.Product;
import product.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository pRepository;
	

	public Product save(Product p) {
		if(p.getPrice() > 0 && null != p.getName() && null != p.getCode()) {
			return pRepository.save(p);
		}else {
			return null;
			}	
	}
	public Product convertVoToEntidade(ProductVO pVO) {
		Product p = new Product();
		
		p.setCode(pVO.getCode());
		p.setName(pVO.getName());
		p.setPrice(pVO.getPrice());
		
		return p;
	}
	public List<Product> searchProduct(String keyword){
		if(keyword == null) {
			return pRepository.findAll();
		}else {
		return pRepository.searchProduct(keyword);
		}
	}
	
	public void delete(Integer id) {
		pRepository.deleteById(id);
	}
	public Product update(Product p, Integer id) {
		Optional<Product> pNew = pRepository.findById(id);
		Product pBanco = pNew.get();
		
		if(null != p.getName()) {
			pBanco.setName(p.getName());
		}
		if(null != p.getCode()) {
			pBanco.setCode(p.getCode());
		}
		if(null != p.getPrice()) {
			pBanco.setPrice(p.getPrice());
		}
		
		return pRepository.save(pBanco);
	}
	
	
}
