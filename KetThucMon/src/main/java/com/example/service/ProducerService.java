package com.example.service;

import com.example.model.Producer;

import java.util.List;

public interface ProducerService {
	 //search and show
    public List<Producer> getAllProducer(Producer producer);
    
	public Producer findOneProducer(int id);
	
    //CRUD
	public void addOneProducer(Producer producer);

	public void updateOneProducer(Producer producer);

	public void deleteOneProducer(int id);

	public Long countToTalProducers();
}
