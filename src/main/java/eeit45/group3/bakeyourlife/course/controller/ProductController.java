package eeit45.group3.bakeyourlife.course.controller;

import java.util.List;

import eeit45.group3.bakeyourlife.course.model.Course;
import eeit45.group3.bakeyourlife.course.model.Product;
import eeit45.group3.bakeyourlife.course.repository.ProductRepositry;
import eeit45.group3.bakeyourlife.course.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


@Controller("")
@RequestMapping(path = "/admin/Course")
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/listProducts")
	public String showExampleView(Model model)
	{
		List<Product> products = productService.getAllProduct();
		model.addAttribute("products", products);
		return "/admin/course/CourseProduct";
	}

	@GetMapping("/addP")
	public String showAddProduct(Model model) {
		//表單綁定用
		model.addAttribute("product",new Product());
		return "/admin/course/CreateCp";
	}

	@RequestMapping(value = "/addP", method = RequestMethod.POST)
    public String saveProduct(
//			@RequestParam("file") MultipartFile file,
//    		@RequestParam("pname") String name,
//    		@RequestParam("price") Integer price,
//    		@RequestParam("desc") String desc
			@ModelAttribute Product product
	)
    {
    	productService.saveProductToDB(product.getFile(), product.getName(), product.getDescription(), product.getPrice());
    	return "redirect:./listProducts";
    }
    
    @GetMapping("/deleteProd/{id}")
    public String deleteProduct(@PathVariable("id") Long id)
    {
    	productService.deleteProductById(id);
    	return "redirect:/admin/Course/listProducts";
    }
    
    @PostMapping("/changeName")
    public String changePname(@RequestParam("id") Long id,
    		@RequestParam("newPname") String name)
    {
    	productService.chageProductName(id, name);
    	return "redirect:/admin/Course/listProducts";
    }
    @PostMapping("/changeDescription")
    public String changeDescription(@RequestParam("id") Long id ,
    		@RequestParam("newDescription") String description)
    {
    	productService.changeProductDescription(id, description);
    	return "redirect:/admin/course/listProducts";
    }
    
    @PostMapping("/changePrice")
    public String changePrice(@RequestParam("id") Long id ,
    		@RequestParam("newPrice") int price)
    {
    	productService.changeProductPrice(id, price);
    	return "redirect:/admin/course/listProducts";
    }
}
