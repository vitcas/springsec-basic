package com.example.demo.controllers;

import com.example.demo.models.Resource;
import com.example.demo.repositories.ResourceRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/test")
public class TestController {

	private final ResourceRepository resourceRepository;

    public TestController(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }
	
    // Endpoint GET - Retorna uma mensagem de boas-vindas
    @GetMapping("/hello")
    public String getHello() {
        return "Hello, welcome to the test API!";
    }

    // Endpoint POST - Cria um recurso fictício
    @PostMapping("/create")
    public String createResource(@RequestBody String resource) {
        return "Resource created: " + resource;
    }

    // Endpoint DELETE - Exclui um recurso fictício
    @DeleteMapping("/delete/{id}")
    public String deleteResource(@PathVariable String id) {
        return "Resource with id " + id + " has been deleted.";
    }
    
    // Endpoint GET - Retorna todos os recursos
    @GetMapping("/resources")
    public List<Resource> getAllResources() {
        return resourceRepository.findAll();
    }

    // Endpoint POST - Cria um novo recurso
    @PostMapping("/v2/create")
    public Resource createResource(@RequestBody Resource resource) {
        return resourceRepository.save(resource);
    }

    // Endpoint DELETE - Exclui um recurso por ID
    @DeleteMapping("/v2/delete/{id}")
    public String deleteResource(@PathVariable Long id) {
        resourceRepository.deleteById(id);
        return "Resource with id " + id + " has been deleted.";
    }
}