package dev.feryadi.springbootweb.controller;

import dev.feryadi.springbootweb.model.Product;
import dev.feryadi.springbootweb.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Feryadialoi
 * @date 10/8/2021 9:34 AM
 */
@Slf4j
@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public String index(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        model.addAttribute("gender", "M");
        return "products/index";
    }

    @GetMapping("/show/{id}")
    public String show(@PathVariable("id") Product product, Model model) {
        model.addAttribute("product", product);
        return "products/show";
    }

    @GetMapping("/create")
    public String create(Product product, Model model) {
        model.addAttribute("product", product);
        return "products/create";
    }

    @PostMapping
    public String store(@Valid Product product, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(objectError -> {
                log.info("{} : {}", objectError.getObjectName(), objectError.getDefaultMessage());
            });
            return "/products/create";
        }
        productRepository.save(product);
        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Product product, Model model) {
        log.info("edit : {}", product);
        model.addAttribute("product", product);
        return "products/edit";
    }

    @PostMapping("/{id}")
    public String update(Product product) {
        log.info("update : {}", product);
        productRepository.save(product);
        return "redirect:/products";
    }

}
