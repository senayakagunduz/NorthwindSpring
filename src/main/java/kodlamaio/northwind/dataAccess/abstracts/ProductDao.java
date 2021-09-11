package kodlamaio.northwind.dataAccess.abstracts;

import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductDao extends JpaRepository <Product,Integer> {
	Product getByProductName(String productName);
	
	Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);
	
	List<Product> getByProductNameOrCategory_CategoryId(String productName,int categoryId);
	
	List<Product> getByIdIn(List<Integer> categories); // Product tablosundan integer türünde categorileri getirecek
	
	List<Product> getByProductNameContains(String productName);//ürün ismine göre arama
	
	List<Product> getByProductNameStartsWith(String productName);//bu isimle başlayan product listesini getirecek.
	
	@Query("From Product where productName=:productName and category_id=:categoryId")
	List<Product> getByNameAndCategory(String productName, int categoryId);
	
	//@Query("Select new kodlamaio.northwind.entities.dtos.ProductWithCategoryDto(p.id,p.productName,c.categoryName) From Category c Inner Join c.products" )
	//List<ProductWithCategoryDto> getProductWithCategoryDetails();
	
	@Query("Select new kodlamaio.northwind.entities.dtos.ProductWithCategoryDto"
	  		+ "(p.id, p.productName, c.categoryName) "
	  		+ "From Category c Inner Join c.products p")
	  List<ProductWithCategoryDto> getProductWithCategoryDetails();
}
