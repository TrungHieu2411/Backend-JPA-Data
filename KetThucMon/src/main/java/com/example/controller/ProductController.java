package com.example.controller;

import com.example.model.Producer;
import com.example.model.Product;
import com.example.model.Provider;
import com.example.service.ProducerService;
import com.example.service.ProductService;
import com.example.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
	private static final String UPLOAD_DIR = "src/main/resources/static/images/product/";

	@Autowired
	private ProductService productService;

	@Autowired
	private ProviderService providerService;

	@Autowired
	private ProducerService producerService;

	@GetMapping("/list")
	public String getProductList(Model model, @RequestParam(value = "providerId", required = false) Integer providerId,
			@RequestParam(value = "producerId", required = false) Integer producerId) {

		return getString(model, providerId, producerId);
	}

	@PostMapping("/list")
	public String postProductList(Model model, @RequestParam(value = "providerId", required = false) Integer providerId,
			@RequestParam(value = "producerId", required = false) Integer producerId) {

		return getString(model, providerId, producerId);
	}

	private String getString(Model model, @RequestParam(value = "providerId", required = false) Integer providerId,
			@RequestParam(value = "producerId", required = false) Integer producerId) {
		List<Provider> providerList = providerService.getAllProvider(null);
		List<Producer> producerList = producerService.getAllProducer(null);
		List<Product> productList;

		if (providerId != null && producerId != null) {
			productList = productService.getProductsByProviderAndProducer(providerId, producerId);
		} else if (providerId != null) {
			productList = productService.getProductsByProvider(providerId);
		} else if (producerId != null) {
			productList = productService.getProductsByProducer(producerId);
		} else {
			productList = productService.getAllProducts();
		}
		model.addAttribute("productList", productList);
		model.addAttribute("providerList", providerList);
		model.addAttribute("producerList", producerList);

		model.addAttribute("providerId", providerId);
		model.addAttribute("producerId", producerId);
		return "product/product_list";
	}

	@GetMapping("/detail")
	public String addProduct(Model model) {
		Product product = new Product();
		List<Provider> providerList = providerService.getAllProvider(null);
		List<Producer> producerList = producerService.getAllProducer(null);

		model.addAttribute("product", product);
		model.addAttribute("providerList", providerList);
		model.addAttribute("producerList", producerList);
		return "product/product_form";
	}

	@GetMapping("/detail/{id}")
	public String editProduct(@PathVariable(value = "id") Integer id, Model model) {
		Product product = productService.getProductById(id);
		if (id != null) {
			product = productService.getProductById(id);
		}
		List<Provider> providerList = providerService.getAllProvider(null);
		List<Producer> producerList = producerService.getAllProducer(null);

		model.addAttribute("product", product);
		model.addAttribute("providerList", providerList);
		model.addAttribute("producerList", producerList);
		return "product/product_form";
	}

	@PostMapping(value = "/detail", params = "create")
	public String saveProduct(@ModelAttribute("product") @Validated Product product, Model model, BindingResult result,
			@RequestParam("imageFile") MultipartFile imageFile) throws IOException {
		if (!imageFile.isEmpty()) {
			String fileName = StringUtils.cleanPath(imageFile.getOriginalFilename());
			Path path = Paths.get(UPLOAD_DIR + fileName);
			Files.copy(imageFile.getInputStream(), path);
			product.setImage(fileName);
		}
		productService.addProduct(product);
		model.addAttribute("message", "Product created successfully");
		return "redirect:/product/list";
	}

	@PostMapping(value = "/detail", params = "update")
	public String updateProduct(@ModelAttribute("product") @Validated Product product, Model model,
			BindingResult result, @RequestParam("imageFile") MultipartFile imageFile) throws IOException {
		if (!imageFile.isEmpty()) {
			String fileName = StringUtils.cleanPath(imageFile.getOriginalFilename());
			Path path = Paths.get(UPLOAD_DIR + fileName);
			Files.copy(imageFile.getInputStream(), path);
			product.setImage(fileName);
		}
		productService.updateProduct(product);
		model.addAttribute("message", "Product updated successfully");
		return "redirect:/product/list";
	}

	@GetMapping("/delete/{productId}")
	public String deleteProduct(@PathVariable("productId") int productId) {
		productService.deleteProduct(productId);
		return "redirect:/product/list";
	}
}
