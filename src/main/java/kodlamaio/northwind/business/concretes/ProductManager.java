package kodlamaio.northwind.business.concretes;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import kodlamaio.northwind.dataAccess.abstracts.ProductDao;
import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

@Service //Bu class projede servis görevi görecek diye bilgi görecek
public class ProductManager implements ProductService {

	private ProductDao productDao;
	
	@Autowired//productdao yu enjekte edecek ortamı verdi(productDao yu ekleyebilmem için @Autowired eklemeliyiz.
	public ProductManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}


	@Override  
	public DataResult<List<Product>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Product>>(this.productDao.findAll(),"data listelendi");
				
	}


	@Override
	public Result add(Product products) {
		// TODO Auto-generated method stub
		return new SuccessResult("Ürün eklendi");
	}


	@Override
	public DataResult<Product> getByProductName(String productName) {
		return new SuccessDataResult<Product>(this.productDao.getByProductName(productName),"data listelendi");
	}


	@Override
	public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
		//Buraya iş kuralarını yazacağız, mesela bunları listeleyebilmek için şu şartları sağlaması lazım falan.Eğer sağlanmıyorsa 
		//apiye yada arayüze sen bu şartları sağlamıyorsun diyeceğiz.
		return new SuccessDataResult<Product>(this.productDao.getByProductNameAndCategory_CategoryId
				(productName,categoryId),"data listelendi");
	}


	@Override
	public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameOrCategory_CategoryId
				(productName,categoryId),"data listelendi");
	}


	@Override
	public DataResult<List<Product>> getByProductIdIn(List<Integer> categories) {//category döndürdüğü için onu yazdık
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByIdIn(categories),"data listelendi");
	}


	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByProductNameContains(productName),"data listelendi");
	}


	@Override
	public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByProductNameStartsWith(productName),"data listelendi");
	}


	@Override
	public DataResult<List<Product>> getByNameOrCategory(String productName, int categoryId) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByNameAndCategory(productName,categoryId),"data listelendi");
	}


	@Override
	public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
		Pageable pageable=PageRequest.of(pageNo-1, pageSize);
		
		return new SuccessDataResult<List<Product>>
		((List<Product>) this.productDao.findAll(pageable).getContent());
	}


	@Override
	public DataResult<List<Product>> getAllSorted() {
		Sort sort=Sort.by(Sort.Direction.DESC,"productName");//hangi yönde sıralayacağını neye göre sıralayacağını gösteriyor.
		return new SuccessDataResult<List<Product>>
		((List<Product>) this.productDao.findAll(sort),"Başarılı");
	}


	@Override
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
		return new SuccessDataResult<List<ProductWithCategoryDto>>
		(this.productDao.getProductWithCategoryDetails(),"ürünler listelendi");
		
	}



	

}
