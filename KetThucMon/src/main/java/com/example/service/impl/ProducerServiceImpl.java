package com.example.service.impl;

import com.example.model.Producer;
import com.example.repository.ProducerRepository;
import com.example.service.ProducerService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProducerServiceImpl implements ProducerService {

    @Autowired
    private ProducerRepository producerRepository;

    @Override
    public List<Producer> getAllProducer(Producer producer) {
        return producerRepository.findAll();
    }
    
    @Override
    public Producer findOneProducer(int id) {
        return producerRepository.findById(id).orElse(null);
    }

    @Override
    public void addOneProducer(Producer producer) {
    	producerRepository.save(producer);
    }

    @Override
    public void updateOneProducer(Producer producer) {
    	producerRepository.save(producer);
    }

    @Override
    public void deleteOneProducer(int id) {
    	producerRepository.deleteById(id);
    }

	@Override
	public Long countToTalProducers() {
		// TODO Auto-generated method stub
		return producerRepository.count();
	}

}
