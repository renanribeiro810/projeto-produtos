package product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import product.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>{
	
	List<Product> findByName(String name);
	List<Product> findByPrice(Double price);
	
	@Query(value = "Select * from product"
			+ " where product.name like concat('%',:keyword,'%')"
			+ " or cast(product.price as varchar(10)) like concat('%',:keyword,'%')"
			+ " or cast(product.code as varchar(10)) like concat('%',:keyword,'%')", nativeQuery = true)
	List<Product> searchProduct(String keyword);
	
}
