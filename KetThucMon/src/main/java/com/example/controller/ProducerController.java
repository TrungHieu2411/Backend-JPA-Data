package com.example.controller;

import com.example.model.Producer;
import com.example.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/producer")
public class ProducerController {
	@Autowired
	private ProducerService producerService;

	@GetMapping("/list")
	public String getProducerList(Model model) {
		Producer producer = new Producer();
		List<Producer> producerList = producerService.getAllProducer(producer);
		model.addAttribute("producerList", producerList);
		return "producer/producer_list";
	}

	@GetMapping("/delete/{id}")
	public String deleteProducer(@PathVariable("id") int id) {
		producerService.deleteOneProducer(id);
		return "redirect:/producer/list";
	}

	@GetMapping(value = {"/detail", "/detail/", "/detail/{id}"})
	public String detailProducer(@PathVariable(value = "id", required = false) Integer id, Model model) {
		Producer producer = new Producer();
		if (id != null) {
			producer = producerService.findOneProducer(id);
		}
		model.addAttribute("producer", producer);
		return "producer/producer_form";
	}

	@PostMapping(value = "/detail", params = "create")
	public String createProducer(@ModelAttribute("producer") Producer producer, Model model) {
		producerService.addOneProducer(producer);
		model.addAttribute("message", "Producer created successfully");
		return "redirect:/producer/list";
	}

	@PostMapping(value = "/detail", params = "update")
	public String updateProducer(@ModelAttribute("producer") Producer producer, Model model) {
		producerService.updateOneProducer(producer);
		model.addAttribute("message", "Producer updated successfully");
		return "redirect:/producer/list";
	}
}
