package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.Customer;
import com.example.model.Employee;
import com.example.model.Order;
import com.example.model.OrderDetail;
import com.example.model.Product;
import com.example.service.CustomerService;
import com.example.service.EmployeeService;
import com.example.service.OrderDetailService;
import com.example.service.OrderService;
import com.example.service.ProductService;

@Controller
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderService orderService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/list")
	public String getOrderList(Model model, @RequestParam(value = "customerId", required = false) Integer customerId,
			@RequestParam(value = "employeeId", required = false) Integer employeeId,
			@RequestParam(value = "paymentMethod", required = false) String paymentMethod,
			@RequestParam(value = "orderStatus", required = false) String orderStatus) {

		List<Customer> customerList = customerService.getAllCustomer(null);
		List<Employee> employeeList = employeeService.getAllEmployee(null);
		List<Order> orderList;

		if (customerId != null && employeeId != null) {
			orderList = orderService.getOrderByCustomerAndEmployee(customerId, employeeId);
		} else if (customerId != null) {	
			orderList = orderService.getOrderByCustomerId(customerId);
		} else if (employeeId != null) {
			orderList = orderService.getOrderByEmployeeId(employeeId);
		} else if (paymentMethod != null && orderStatus != null) {
			orderList = orderService.getPaymentMethodAndOrderStatus(paymentMethod, orderStatus);
		} else if (paymentMethod != null) {
			orderList = orderService.getOrderByPaymentMethod(paymentMethod);
		} else if (orderStatus != null) {
			orderList = orderService.getOrderByOrderStatus(orderStatus);
		}else {
			orderList = orderService.getAllOrders();
		}

		model.addAttribute("orderList", orderList);
		model.addAttribute("customerList", customerList);
		model.addAttribute("employeeList", employeeList);

		model.addAttribute("customerId", customerId);
		model.addAttribute("employeeId", employeeId);
		return "order/order_list";
	}

	@PostMapping("/list")
	public String postOrderList(Model model,
			@RequestParam(value = "customerId", required = false) Integer customerId,
			@RequestParam(value = "employeeId", required = false) Integer employeeId,
			@RequestParam(value = "paymentMethod", required = false) String paymentMethod,
			@RequestParam(value = "orderStatus", required = false) String orderStatus) {

		List<Customer> customerList = customerService.getAllCustomer(null);
		List<Employee> employeeList = employeeService.getAllEmployee(null);
		List<Order> orderList;

		if (customerId != null && employeeId != null) {
			orderList = orderService.getOrderByCustomerAndEmployee(customerId, employeeId);
		} else if (customerId != null) {	
			orderList = orderService.getOrderByCustomerId(customerId);
		} else if (employeeId != null) {
			orderList = orderService.getOrderByEmployeeId(employeeId);
		} else if (paymentMethod != null && orderStatus != null) {
			orderList = orderService.getPaymentMethodAndOrderStatus(paymentMethod, orderStatus);
		} else if (paymentMethod != null) {
			orderList = orderService.getOrderByPaymentMethod(paymentMethod);
		} else if (orderStatus != null) {
			orderList = orderService.getOrderByOrderStatus(orderStatus);
		}else {
			orderList = orderService.getAllOrders();
		}

		model.addAttribute("orderList", orderList);
		model.addAttribute("customerList", customerList);
		model.addAttribute("employeeList", employeeList);
		

		model.addAttribute("customerId", customerId);
		model.addAttribute("employeeId", employeeId);
		return "order/order_list";
	}

	@GetMapping("/add")
	public String addOrder(@PathVariable(value = "id", required = false) Integer id, Model model) {
		//ORDER
		Order order = new Order();
		if (id != null) {
			order = orderService.getOrderById(id);
		}
		List<Customer> customerList = customerService.getAllCustomer(null);
		List<Employee> employeeList = employeeService.getAllEmployee(null);

		model.addAttribute("order", order);
		model.addAttribute("customerList", customerList);
		model.addAttribute("employeeList", employeeList);
		
		//ORDER DETAIL
		OrderDetail orderDetail = new OrderDetail();
		if (id != null) {
			orderDetail = orderDetailService.getOrderDetailById(id);
		}
		
		List<Product> productList = productService.getAllProduct(null);
		List<Order> orderList = orderService.getAllOrder(null);
		
		model.addAttribute("orderDetail", orderDetail);
		model.addAttribute("orderList", orderList);
		model.addAttribute("productList", productList);

		return "order/order_add";
	}

	@PostMapping("/save")
	public String saveOrder(@ModelAttribute("order") Order order, @ModelAttribute("orderDetail") OrderDetail orderDetail) {
	    //ORDER
		orderService.addOrder(order);
	    //ORDER DETAIL
	    orderDetailService.addOrderDetail(orderDetail);
	    return "redirect:/order/add";
	}
	
	
	
	@GetMapping("/edit/{id}")
	public String editOrder(@PathVariable(value = "id", required = false) Integer id, Model model) {
		Order order = new Order();
		if (id != null) {
			order = orderService.getOrderById(id);
		}
		List<Customer> customerList = customerService.getAllCustomer(null);
		List<Employee> employeeList = employeeService.getAllEmployee(null);

		model.addAttribute("order", order);
		model.addAttribute("customerList", customerList);
		model.addAttribute("employeeList", employeeList);
		return "order/order_update";
	}

	@PostMapping("/update")
	public String updateOrder(@ModelAttribute("order") Order order) {
		orderService.updateOrder(order);
		return "redirect:/order/list";
	}

	@GetMapping("/delete/{id}")
	public String deleteOrder(@PathVariable("id") int id) {
		orderService.deleteOrder(id);
		return "redirect:/order/list";
	}
	
	//ORDER DETAIL
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private OrderDetailService orderDetailService;
	
	@GetMapping("/detail/{id}")
	public String getOrderDetail(Model model, @PathVariable("id") Integer orderId) {
		Order order = orderService.getOrderById(orderId);
		model.addAttribute("order", order);
		return "order/order_detail";
	}
	
	@PostMapping("/detail/save")
	public String saveOrderDetail(@ModelAttribute("orderDetail") OrderDetail orderDetail) {
	    //ORDER DETAIL
	    orderDetailService.addOrderDetail(orderDetail);
	    return "redirect:/order/list";
	}
	
	@PostMapping("/detail/{id}")
	public String postOrderDetailList(Model model, @RequestParam(value = "productId", required = false) Integer productId) {

		List<Product> productList = productService.getAllProduct(null);
		List<OrderDetail> orderDetailList;

		if (productId != null ) {
			orderDetailList = orderDetailService.getOrderByProductId(productId);
		} else {
			orderDetailList = orderDetailService.getAllOrderDetails();
		}
		model.addAttribute("orderDetailList", orderDetailList);
		model.addAttribute("productList", productList);

		model.addAttribute("productId", productId);
		return "order/order_detail";
	}

}
