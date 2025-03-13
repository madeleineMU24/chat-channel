package com.example.chat_channel;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/channels")
@RestController
public class ChannelController {

    ChannelService channelService;

    public ChannelController(ChannelService channelService){
        this.channelService = channelService;
    }

    @PostMapping
    public ResponseEntity<Channel> createChannel(@RequestBody Channel channel){
        Channel result = channelService.createChannel(channel);

        return ResponseEntity.ok(result);
    }

    @GetMapping
    public List<Channel> findAllChannels(){
        return channelService.findAllChannels();
    }

    @GetMapping("/{id}")
    public Channel findChannelById(@PathVariable Long id){
        Optional<Channel> channel = channelService.findChannelById(id);
        return channel.orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteChannelById(@PathVariable Long id){
        channelService.deleteChannelById(id);
    }
}
