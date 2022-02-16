package de.neuefische.springshop;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shop")
public class ShopController {
    ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @PostMapping("/add")
    public void addProductToRepo(@RequestBody ProductDTO product){
        if(product.getType().equals("Toy")){
            shopService.addProduct(new ToyProduct(product.getName(), product.getId()));
        }else {
            shopService.addProduct(new ClothProduct(product.getName(), product.getId()));
        }
    }

    @PostMapping("/{id}")
    public void addOrderToRepo(@PathVariable int id, @RequestBody int[] products){
        shopService.addOrder(id, products);
    }

    @GetMapping
    public String showProducts(){
        return shopService.listProducts();
    }

    @GetMapping("/orders/{id}")
    public Optional<List<Product>> getOrderFromRepo(@PathVariable int id){
        return shopService.getOrder(id);
    }
}
