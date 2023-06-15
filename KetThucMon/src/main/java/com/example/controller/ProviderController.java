package com.example.controller;

import com.example.model.Provider;
import com.example.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/provider")
public class ProviderController {
    @Autowired
    private ProviderService providerService;

    @GetMapping("/list")
    public String getProviderList(Model model) {
        Provider provider = new Provider();
        List<Provider> providerList = providerService.getAllProvider(provider);
        model.addAttribute("providerList", providerList);
        return "provider/provider_list";
    }

    @GetMapping("/delete/{id}")
    public String deleteProvider(@PathVariable("id") int id) {
        providerService.deleteOneProvider(id);
        return "redirect:/provider/list";
    }

    @GetMapping(value = {"/detail", "/detail/", "/detail/{id}"})
    public String detailProvider(@PathVariable(value = "id", required = false) Integer id, Model model) {
        Provider provider = new Provider();
        if (id != null) {
            provider = providerService.findOneProvider(id);
        }
        model.addAttribute("provider", provider);
        return "provider/provider_form";
    }

    @PostMapping(value = "/detail", params = "create")
    public String createProvider(@ModelAttribute("provider") Provider provider, Model model) {
        providerService.addOneProvider(provider);
        model.addAttribute("message", "Provider created successfully");
        return "redirect:/provider/list";
    }

    @PostMapping(value = "/detail", params = "update")
    public String updateProvider(@ModelAttribute("provider") Provider provider, Model model) {
        providerService.updateOneProvider(provider);
        model.addAttribute("message", "Provider updated successfully");
        return "redirect:/provider/list";
    }
}
