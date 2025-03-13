package com.example.chat_channel;

import jakarta.validation.Valid;
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
    public ResponseEntity<Channel> createChannel(@Valid @RequestBody Channel channel){
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

    @PutMapping
    public ResponseEntity<Channel> updateChannel(@Valid @RequestBody Channel newChannel){
        Channel channel = channelService.updateChannel(newChannel);
        if (channel != null){
            return ResponseEntity.accepted().body(newChannel);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
