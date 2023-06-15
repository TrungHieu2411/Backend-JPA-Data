package com.example.service.impl;

import com.example.model.Provider;
import com.example.repository.ProviderRepository;
import com.example.service.ProviderService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProviderServiceImpl implements ProviderService {

    @Autowired
    private ProviderRepository providerRepository;

    @Override
    public List<Provider> getAllProvider() {
        return providerRepository.findAll();
    }

    @Override
    public List<Provider> getAllProvider(Provider provider) {
        return providerRepository.findAll();
    }

    @Override
    public Provider findOneProvider(int id) {
        return providerRepository.findById(id).orElse(null);
    }

    @Override
    public void addOneProvider(Provider provider) {
        providerRepository.save(provider);
    }

    @Override
    public void updateOneProvider(Provider provider) {
        providerRepository.save(provider);
    }

    @Override
    public void deleteOneProvider(int id) {
        providerRepository.deleteById(id);
    }

    @Override
    public Long countToTalProviders() {
        return providerRepository.count();
    }

}
