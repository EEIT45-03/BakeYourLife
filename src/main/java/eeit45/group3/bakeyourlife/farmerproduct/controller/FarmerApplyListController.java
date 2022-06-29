package eeit45.group3.bakeyourlife.farmerproduct.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import eeit45.group3.bakeyourlife.farmerproduct.model.FarmerProductBean;
import eeit45.group3.bakeyourlife.farmerproduct.model.FarmerProductService;

@Controller
@RequestMapping(path = "/FarmerApplyList")
public class FarmerApplyListController {

	FarmerProductService farmerProductService;

	ServletContext context;

	@Autowired
	public FarmerApplyListController(FarmerProductService farmerProductService, ServletContext context) {
		this.farmerProductService = farmerProductService;
		this.context = context;
	}

	@GetMapping("/")
	public String viewIndex(Model model) {
		List<FarmerProductBean> farmerProductBeans = farmerProductService.findAll();
		model.addAttribute("farmerProductBeans", farmerProductBeans);
		return "FarmerProduct/FarmerApplyList";
	}

	@GetMapping("CreateFarmerApplyList")
	public String viewCreateFarmerApplyList() {
		return "FarmerProduct/CreateFarmerApplyList";
	}

	@PostMapping("CreateFarmerApplyList")
	public String createFarmerApplyList(FarmerProductBean farmerProductBean) {

		Date date = new Date();
		farmerProductBean.setFarmerProductApplyTime(date);
		farmerProductService.insert(farmerProductBean);
		return "redirect:./";
	}

	@GetMapping("/UpdateFarmerApplyList")
	private String viewUpdateFarmerApplyList(@RequestParam Integer farmerProductId, Model model) {

		FarmerProductBean farmerProductBean = null;

		if (farmerProductId != null) {
			farmerProductBean = farmerProductService.findById(farmerProductId);
		}

		model.addAttribute("bean", farmerProductBean);

		return "FarmerProduct/UpdateFarmerApplyList";

	}

	@PostMapping("UpdateFarmerApplyList")
	private String updateFarmerApplyList(@RequestParam Integer farmerProductId,
			@ModelAttribute("bean") FarmerProductBean farmerProductBean) {
		FarmerProductBean farmerProductBeanDb = farmerProductService.findById(farmerProductId);

		if (farmerProductBeanDb != null) {
			farmerProductService.update(farmerProductBean);
		}

		return "redirect:./";
	}

	@RequestMapping("DeleteFarmerApplyList")
	private String processDeleteFarmerApplyList(@RequestParam Integer farmerProductId) {
		farmerProductService.delete(farmerProductId);
		return "redirect:./";
	}

}
