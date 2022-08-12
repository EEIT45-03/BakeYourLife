package eeit45.group3.bakeyourlife.course.controller;

import java.util.List;

import eeit45.group3.bakeyourlife.course.model.Product;
import eeit45.group3.bakeyourlife.course.service.ProductService;
import eeit45.group3.bakeyourlife.utils.Image;
import eeit45.group3.bakeyourlife.utils.ImgurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller("")
@RequestMapping(path = "/admin/Course")
public class AdminProductController {
	
	@Autowired
	private ProductService productService;

	@Autowired
	public AdminProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/listProducts")
	public String showExampleView(Model model)
	{
		List<Product> products = productService.getAllProduct();
		model.addAttribute("products", products);
		return "admin/course/CourseProduct";
	}

	@GetMapping("/addP")
	public String showAddProduct(Model model) {
		//表單綁定用
		model.addAttribute("product",new Product());
		return "admin/course/CreateCp";
	}

	@RequestMapping(value = "/addP", method = RequestMethod.POST)
    public String saveProduct(
			@ModelAttribute Product product
	)
    {
		Image image = ImgurService.updateByMultipartFile(product.getFile());
		image.getLink();
		System.out.println("圖片連結: " + image.getLink());
		productService.saveProductToDB(image.getLink(), product.getName(), product.getDescription(), product.getSummary(), product.getPrice());
    	return "redirect:./listProducts";
    }
    
    @GetMapping("/deleteProd/{id}")
    public String deleteProduct(@PathVariable("id") Long id)
    {
    	productService.deleteProductById(id);
    	return "redirect:/admin/Course/listProducts";
    }


}
