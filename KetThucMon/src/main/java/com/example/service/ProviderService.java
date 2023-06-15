package com.example.service;

import com.example.model.Provider;

import java.util.List;

public interface ProviderService {
	 //search and show
    public List<Provider> getAllProvider(Provider provider);
    
    public List<Provider> getAllProvider();
    
    public Provider findOneProvider(int id);
    
	public void addOneProvider(Provider provider);

	public void updateOneProvider(Provider provider);

	public void deleteOneProvider(int id);

	public Long countToTalProviders();

}
