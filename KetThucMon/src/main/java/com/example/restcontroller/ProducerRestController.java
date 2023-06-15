package com.example.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Producer;
import com.example.service.ProducerService;

@RestController
@RequestMapping("/api/producers")
public class ProducerRestController {

    @Autowired
    private ProducerService producerService;

    @GetMapping("/list")
    public ResponseEntity<List<Producer>> getAllProducers() {
        List<Producer> producerList = producerService.getAllProducer(null);
        return ResponseEntity.ok(producerList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producer> getProducerById(@PathVariable("id") int id) {
        Producer producer = producerService.findOneProducer(id);
        if (producer != null) {
            return ResponseEntity.ok(producer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Producer> addProducer(@RequestBody Producer producer) {
        producerService.addOneProducer(producer);
        return ResponseEntity.status(HttpStatus.CREATED).body(producer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producer> updateProducer(@PathVariable("id") int id, @RequestBody Producer updatedProducer) {
        Producer producer = producerService.findOneProducer(id);
        if (producer != null) {
            producer.setProducerId(updatedProducer.getProducerId());
            producerService.updateOneProducer(producer);
            return ResponseEntity.ok(producer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducer(@PathVariable("id") int id) {
        producerService.deleteOneProducer(id);
        return ResponseEntity.noContent().build();
    }
}

