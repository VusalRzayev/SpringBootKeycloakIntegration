package az.rv.demoapp.controller;

import az.rv.demoapp.model.Product;
import az.rv.demoapp.request.ProductRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/products")
public class ProductController {

    private List<Product> products= Stream.of(
            new Product(1,"Product1"),
            new Product(2,"Product2"),
            new Product(3,"Product3")
    ).collect(Collectors.toList());


    @GetMapping
    public ResponseEntity<List<Product>> all(){

        return ResponseEntity.ok().body(products);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> product(@PathVariable int productId){
        Optional<Product> product = products.stream().
                filter(p -> p.getId() == productId).findFirst();
        return product.map(value -> ResponseEntity.ok().body(value)).orElseGet(() -> ResponseEntity.status(HttpStatus.NO_CONTENT).build());
    }

    @PostMapping("/add")
    public ResponseEntity<Product> createProduct(@RequestBody ProductRequest productRequest){
        int id = products.stream().max(Comparator.comparingInt(Product::getId)).get().getId();
        Product product = new Product(++id, productRequest.getName());
        products.add(product);
        return ResponseEntity.ok(product);
    }


}
