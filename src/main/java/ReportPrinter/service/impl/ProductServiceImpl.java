package ReportPrinter.service.impl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ReportPrinter.mybatis.dao.ProductDao;
import ReportPrinter.mybatis.dto.ProductDTO;
import ReportPrinter.mybatis.model.Product;
import ReportPrinter.service.ProductService;



@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;
		
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<ProductDTO> findAll() {
		List<Product> lstProduct = productDao.findAll();
		List<ProductDTO> lstProductDTO = lstProduct.stream().map(each -> modelMapper.map(each, ProductDTO.class)).collect(Collectors.toList());
		
		lstProductDTO.forEach(each -> {
			if(each.getImage() != null) {				
				each.setImageBase64(Base64.getEncoder().encodeToString(each.getImage()));
			}
		});
		
		return lstProductDTO;
	}

	@Override
	public void insertProduct(ProductDTO productDTO) {
		Product product = modelMapper.map(productDTO, Product.class);
		product.setImage(Base64.getDecoder().decode(productDTO.getImageBase64()));
		
		productDao.insert(product);
	}

	@Override
	public void deleteProductById(int id) {
		productDao.deleteById(id);
	}
	
	@Override
	public Product findProductById(int id) {
		return productDao.findProductById(id);
	}

	@Override
	public void updateProduct(ProductDTO product) {
		//productDao.update(product);
	}

	@Override
	public List<ProductDTO> findBySearch(String name, String from, String to, String currentPage) {
		float fromI = from == "" || from == null ? -1 : Float.parseFloat(from);
		float toI = to == "" || to == null ? -1 : Float.parseFloat(to);
		
		if(currentPage == null || currentPage == "") {
			currentPage = "1";
		}
		
		
		List<Product> lstProduct = productDao.findSearch(name, fromI, toI, LIMIT, LIMIT * (  Integer.parseInt(currentPage) - 1));
		List<ProductDTO> lstProductDTO = lstProduct.stream().map(each -> modelMapper.map(each, ProductDTO.class)).collect(Collectors.toList());
		
		lstProductDTO.forEach(each -> {
			if(each.getImage() != null) {				
				each.setImageBase64(Base64.getEncoder().encodeToString(each.getImage()));
			}
		});
		
		return lstProductDTO;
	}



}
