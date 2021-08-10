package kodlamaio.northwind.api.controllers;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;

@RestController // her iş için bir controller vardır.uygulamanın dış dünya ile iletişimini controllerlar sağlıyor.
@RequestMapping("/api/products") //dış dünyadan bir istek gelirse bu controller haber verecek bize

public class ProductsController {
	// bizim operasyonlarımız (metodlarımız) nasıl destek verecek yazıyoruz.
	
	private ProductService productService;
	
	@Autowired
	public ProductsController(ProductService productService) { //Projeyi tarar productservisi implemente eden productmanager ı buluyor ve onları newleme işini yapıyor.
		super();
		this.productService = productService;
	}
	
	@GetMapping("/getall") //getAll diye bir istek gelirse aşağıda metod çalışacak
	public DataResult<List<Product>> getAll(){ //ProductsController vasıtasıyla bu metod desteğini veriyoruz demektir.
		return this.productService.getAll();
		//(List<Product>) this.productService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Product product) {
		return this.productService.add(product);
	}
}
