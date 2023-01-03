package ReportPrinter.service;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import ReportPrinter.mybatis.dto.ProductDTO;
import ReportPrinter.mybatis.model.Product;


public interface ProductService {
	
	public static final int LIMIT = 10;
		
	List<ProductDTO> findAll();

	void insertProduct(ProductDTO product);

	Product findProductById(int id);

	void deleteProductById(int id);

	void updateProduct(ProductDTO product);

	List<ProductDTO> findBySearch(String name, String from, String to, String currentPage);
	

}
