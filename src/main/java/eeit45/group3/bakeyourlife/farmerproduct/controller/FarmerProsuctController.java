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
@RequestMapping(path = "/FarmerProduct")
public class FarmerProsuctController {

	FarmerProductService farmerProductService;

	ServletContext context;

	@Autowired
	public FarmerProsuctController(FarmerProductService farmerProductService, ServletContext context) {
		this.farmerProductService = farmerProductService;
		this.context = context;
	}

	@GetMapping("/")
	public String viewIndex(Model model) {
		List<FarmerProductBean> farmerProductBeans = farmerProductService.findAll();
		model.addAttribute("farmerProductBeans", farmerProductBeans);
		return "FarmerProduct/FarmerProduct";
	}

	@RequestMapping("UpdateFarmerProductState")
	private String updateFarmerProductState(@RequestParam Integer farmerProductId,
			@RequestParam Integer farmerProductState) {
		FarmerProductBean farmerProductBean = null;
		if (farmerProductId != null) {
			farmerProductBean = farmerProductService.findById(farmerProductId);
		}
		farmerProductBean.setFarmerProductState(farmerProductState);
		Date date = new Date();
		switch (farmerProductState) {
		case 3:
			farmerProductBean.setFarmerProductSoldTime(date);
			break;
		case 1:
			farmerProductBean.setFarmerProductLaunchedTime(date);
		case 2:
			farmerProductBean.setFarmerProductCheckTime(date);
			break;
		default:
			break;
		}

		farmerProductService.update(farmerProductBean);
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
	private String deleteFarmerApplyList(@RequestParam Integer farmerProductId) {
		farmerProductService.delete(farmerProductId);
		return "redirect:./";
	}

}
