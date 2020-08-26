package com.example.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
public class controller {
    @Autowired
    RedisRepository redisRepository;
    @Autowired
    ProductRepository productRepository;
    @PostMapping("/product")
    public void createProduct(@RequestBody ProductRequest productRequest){
        Product product = new Product();
        product.setTitle(productRequest.getTitle());
        productRepository.save(product);


    }

    @PutMapping("/product/rating/{id}")
    public void createProduct(@PathVariable("id") long id,
                              @RequestBody ProductRequest productRequest){
//       Product product = productRepository.findById(id).get();
//       if(Objects.isNull(product.getRatings())){
//           List<Rating> ratings = new ArrayList<>();
//           product.setRatings(ratings);
//       }
//       product.getRatings().add(new Rating(productRequest.getRating()));
//       productRepository.save(product);
//
//       if(redisRepository.findById(id).isPresent())
//         redisRepository.delete(redisRepository.findById(id).get());
        Product product = productRepository.findById(id).get();
        List<Rating> ratings;
        if (Objects.isNull(product.getRatings())){
             ratings = new ArrayList<>();
        }else{
            ratings = product.getRatings();
        }
        ratings.add(new Rating(productRequest.getRating()));
        productRepository.save(product);
        Optional<ProductRating> productRatingOptional =
                redisRepository.findById(id);
        if(productRatingOptional.isPresent()){
            redisRepository.delete(productRatingOptional.get());
        }
    }

    @GetMapping("/product/average_rating/{id}")
    public double getProduct(@PathVariable("id") Long id){
         ProductRating productRating;
        Optional<ProductRating> productRatingOptional =
                redisRepository.findById(id);
         if(productRatingOptional.isPresent()){
             return productRatingOptional.get().getAvergaeRating();
         }else{
             return getRatingAndInsertInCache(id).getAvergaeRating();
         }



    }

    private ProductRating getRatingAndInsertInCache(Long id) {
        Product product = productRepository.findById(id).get();
        Double averageRating = 0.0;
        for(Rating r : product.getRatings()){
            averageRating = averageRating+r.getRating();
        }
        averageRating=averageRating/product.getRatings().size();
        ProductRating productRating = new ProductRating();
        productRating.setId(id);
        productRating.setAvergaeRating(averageRating);

        redisRepository.save(productRating);
        return productRating;

    }

}
