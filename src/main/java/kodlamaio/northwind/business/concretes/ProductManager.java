package kodlamaio.northwind.business.concretes;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import kodlamaio.northwind.dataAccess.abstracts.ProductDao;
import kodlamaio.northwind.entities.concretes.Product;

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
		return new SuccessDataResult<List<Product>>
		(this.productDao.findAll(),"data listelendi");
				
	}


	@Override
	public Result add(Product products) {
		// TODO Auto-generated method stub
		return new SuccessResult("Ürün eklendi");
	}



	

}
