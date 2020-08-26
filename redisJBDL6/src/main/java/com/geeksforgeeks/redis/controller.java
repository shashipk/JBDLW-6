package com.geeksforgeeks.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class controller {
    @Autowired
    RedisRepository redisRepository;

    @PostMapping("/feed")
    public void storeFeed(@RequestBody Feed feed){
        redisRepository.save(feed);
    }

    @GetMapping("/feed/{id}")
    public Feed getFeed( @PathVariable("id")String id){
        return redisRepository.findById(id).get();
    }

    @PutMapping("/feed/{id}")
    public void updateFeed( @PathVariable("id")String id,
                            @RequestBody Feed feedRequest){
        Feed feed = redisRepository.findById(id).get();
        feed.setDescription(feedRequest.getDescription());
        redisRepository.save(feed);
    }

    @DeleteMapping("/feed/{id}")
    public void deleteFeed( @PathVariable("id")String id){
        Feed feed = redisRepository.findById(id).get();
        redisRepository.delete(feed);
    }
}
