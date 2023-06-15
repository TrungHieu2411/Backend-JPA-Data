package com.example.restcontroller;


import com.example.model.Provider;
import com.example.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/providers")
public class ProviderRestController {

    @Autowired
    private ProviderService providerService;

    @GetMapping("/list")
    public ResponseEntity<List<Provider>> getAllProviders() {
        List<Provider> providerList = providerService.getAllProvider(null);
        return ResponseEntity.ok(providerList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Provider> getProviderById(@PathVariable("id") int id) {
        Provider provider = providerService.findOneProvider(id);
        if (provider != null) {
            return ResponseEntity.ok(provider);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Provider> createProvider(@RequestBody Provider provider) {
        providerService.addOneProvider(provider);
        return ResponseEntity.status(HttpStatus.CREATED).body(provider);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Provider> updateProvider(@PathVariable("id") int id, @RequestBody Provider updatedProvider) {
        Provider provider = providerService.findOneProvider(id);
        if (provider != null) {
        	provider.setProviderId(updatedProvider.getProviderId());
            provider.setProviderName(updatedProvider.getProviderName());
            provider.setAddress(updatedProvider.getAddress());
            // Update other properties as needed

            providerService.updateOneProvider(provider);
            return ResponseEntity.ok(provider);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProvider(@PathVariable("id") int id) {
        providerService.deleteOneProvider(id);
        return ResponseEntity.noContent().build();
    }
}
