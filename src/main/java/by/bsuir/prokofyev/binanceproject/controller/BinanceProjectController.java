package by.bsuir.prokofyev.binanceproject.controller;

import by.bsuir.prokofyev.binanceproject.dto.ProductDTO;
import by.bsuir.prokofyev.binanceproject.entity.Product;
import by.bsuir.prokofyev.binanceproject.service.InformationService;

import by.bsuir.prokofyev.binanceproject.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
class BinanceProjectController {


    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody ProductDTO dto){
    return new ResponseEntity<>(productService.create(dto), HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<Product>> readAllAll(){
        return new ResponseEntity<>(productService.readAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Product> update(@RequestBody Product product){
        return new ResponseEntity<>(productService.update(product), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id){
        productService.delete(id);
        return  HttpStatus.OK;
    }



    /*
    *    private final InformationService informationService;
    *
    *public BinanceProjectController(InformationService informationService) {
    *    this.informationService = informationService;
    *}
    *
    * @GetMapping(value = "/binance" , produces = "application/json")
    * public String ValidateInput(@RequestParam(required = false) String name) {
    *    if (name == null)
    *    {
    *        return informationService.informationError();
    *    }
    *    return !(name.equals("USDT")) ? informationService.informationError() : informationService.information();
    * }
    */
}