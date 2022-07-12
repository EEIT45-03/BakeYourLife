package eeit45.group3.bakeyourlife.course.service;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import eeit45.group3.bakeyourlife.course.model.Product;
import eeit45.group3.bakeyourlife.course.repository.ProductRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;



@Service
public class ProductService {
	@Autowired
	private ProductRepositry productRepo;
	
	public void  saveProductToDB(String image,String name,String description, String summary,int price)
	{
		Product p = new Product();

		p.setImage(image);
		p.setDescription(description);
		p.setSummary(summary);
        p.setName(name);
        p.setPrice(price);
        
        productRepo.save(p);
	}
	public List<Product> getAllProduct()
	{
		return productRepo.findAll();
	}
    public void deleteProductById(Long id)
    {
    	productRepo.deleteById(id);
    }
    public void chageProductName(Long id ,String name)
    {
    	Product p = new Product();
    	p = productRepo.findById(id).get();
    	p.setName(name);
    	productRepo.save(p);    
    }
    public void changeProductDescription(Long id , String description)
    {
    	Product p = new Product();
    	p = productRepo.findById(id).get();
    	p.setDescription(description);
    	productRepo.save(p);
    }
    public void changeProductPrice(Long id,int price)
    {
    	Product p = new Product();
    	p = productRepo.findById(id).get();
    	p.setPrice(price);
    	productRepo.save(p);
    }
}
