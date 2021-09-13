package kodlamaio.northwind.business.abstracts;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

public interface ProductService {
	DataResult<List<Product>> getAll();
	
	DataResult<List<Product>> getAllSorted();
	
	DataResult<List<Product>> getAll(int pageNo,int pageSize);
	
	Result add(Product products);
	
	DataResult<Product> getByProductName(String productName);
	
	DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId);
	
	DataResult<List<Product>> getByProductNameOrCategoryId(String productName,int categoryId);
	
	DataResult<List<Product>> getByProductIdIn(List<Integer> categories); // Product tablosundan integer türünde categorileri getirecek
	
	DataResult<List<Product>> getByProductNameContains(String productName);//ürün ismine göre arama
	
	DataResult<List<Product>> getByProductNameStartsWith(String productName);//bu isimle başlayan product listesini getirecek.
	
	DataResult<List<Product>> getByNameOrCategory(String productName,int categoryId);
	
	DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();
	
}
