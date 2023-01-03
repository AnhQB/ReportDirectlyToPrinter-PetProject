package ReportPrinter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ReportPrinter.mybatis.dto.ProductDTO;
import ReportPrinter.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/")
	public String index(Model model) {
		List<ProductDTO> lstProductDTO = productService.findAll();
		
		
		model.addAttribute("lstProduct", lstProductDTO);
		return "product/index";
	}
}	
