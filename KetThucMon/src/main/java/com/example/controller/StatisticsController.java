package com.example.controller;

import com.example.service.CustomerService;
import com.example.service.EmployeeService;
import com.example.service.OrderService;
import com.example.service.ProducerService;
import com.example.service.ProductService;
import com.example.service.ProviderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/statis")
public class StatisticsController {
	@Autowired
    private CustomerService customerService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProviderService providerService;
	
	@Autowired
	private ProducerService producerService;
   
    @GetMapping("/page")
    public String showStatisticsPage(Model model) {
    	//customer
        Long vipCount = customerService.countVipCustomers();
        Long regularCount = customerService.countRegularCustomers();
        Long totalCustomers = customerService.countTotalCustomers();
        //order
        Long cashCount = orderService.countOrderByPaymentMethod("Tiền mặt");
        Long transferCount = orderService.countOrderByPaymentMethod("Chuyển khoản");
        Long installmentCount = orderService.countOrderByPaymentMethod("Trả góp");
        Long totalOrders = orderService.countTotalOrders();
        
        Long shippingStatus = orderService.countOrderByOrderStatus("Đang giao");
        Long completedStatus = orderService.countOrderByOrderStatus("Đã giao");
        Long newOrderStatus = orderService.countOrderByOrderStatus("Đơn hàng mới");
        Long orderCancelledStatus = orderService.countOrderByOrderStatus("Đã hủy");
        
        //employee
        Long totalEmployees = employeeService.countTotalEmployees();
        //product
        Long totalProducts = productService.countToTalProducts();
        //provider
        Long totalProviders = providerService.countToTalProviders();
        //producer
        Long totalProducers = producerService.countToTalProducers();
        
        //customer
        model.addAttribute("vipCount", vipCount);
        model.addAttribute("regularCount", regularCount);
        model.addAttribute("totalCustomers", totalCustomers);
        //order
        model.addAttribute("cashCount", cashCount);
        model.addAttribute("transferCount", transferCount);
        model.addAttribute("installmentCount", installmentCount);
        model.addAttribute("totalOrders", totalOrders);
        //------
        model.addAttribute("shippingStatus", shippingStatus);
        model.addAttribute("completedStatus", completedStatus);
        model.addAttribute("newOrderStatus", newOrderStatus);
        model.addAttribute("orderCancelledStatus", orderCancelledStatus);
        //employee
        model.addAttribute("totalEmployees", totalEmployees);
        //product
        model.addAttribute("totalProducts", totalProducts);
        //provider
        model.addAttribute("totalProviders", totalProviders);
        //producer
        model.addAttribute("totalProducers", totalProducers);
        
        return "statis/statistics";
    }

}
