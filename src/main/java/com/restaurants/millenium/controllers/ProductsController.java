package com.restaurants.millenium.controllers;

import com.restaurants.millenium.domain.Headers;
import com.restaurants.millenium.domain.Product;
import com.restaurants.millenium.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;
import java.util.List;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(ProductsController.BASE_URL)
public class ProductsController {
    public static final String BASE_URL = "/api/products";

    private final ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    List<Product> getAllProducts(){
        return productService.findAllProducts();
    }

    @PostMapping
    public List<Product> getProducts(@RequestBody Headers headers) throws IOException {
        String link = "https://app.vendaerp.com.br/api/request/produtos/getall";

        List<Product> prodsFromDB = productService.findAllProducts();

        URL url = new URL(link);
        URLConnection request = url.openConnection();
        request.setRequestProperty("Authorization-Token", headers.AuthorizationToken);
        request.setRequestProperty("User", headers.User);
        request.setRequestProperty("App", headers.App);
        request.connect();

        // Convert to a JSON object to print data
        JsonParser jp = null; //from gson
        JsonElement root = jp.parseReader(new InputStreamReader((InputStream) request.getContent())); //Convert the input stream to a json element
        JsonArray products = root.getAsJsonArray();
        for(int i = 0; i < products.size(); i++){
            boolean savedproduct = false;

            JsonObject auxObj = products.get(i).getAsJsonObject();
            String id = auxObj.get("ID").getAsString();
            for(int j = 0; j < prodsFromDB.size(); j++){
                System.out.println(id + " " + prodsFromDB.get(i).getIdFromAPI());
                if(id.equals(prodsFromDB.get(j).getIdFromAPI())){
                    savedproduct = true;
                    System.out.println("Entrou!");
                }
            }

            if(savedproduct == true){
                continue;
            }

            String nome = auxObj.get("Nome").getAsString();
            Double preco = auxObj.get("PrecoVenda").getAsDouble();

            Product prod = new Product();

            prod.setIdFromAPI(id);
            prod.setName(nome);
            prod.setPrice(preco);

            saveProduct(prod);
        }
        prodsFromDB = productService.findAllProducts();

        return prodsFromDB;
    }

    @ResponseStatus(HttpStatus.CREATED)
    public Product saveProduct(@RequestBody Product sol){
        return productService.saveProduct(sol);
    }

}

