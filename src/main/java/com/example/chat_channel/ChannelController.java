package com.example.chat_channel;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return channelService.findChannelById(id).orElseThrow(() -> new EntityNotFoundException("no channel with id " + id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChannelById(@PathVariable Long id){
        channelService.findChannelById(id).orElseThrow(()-> new EntityNotFoundException("no channel with id " + id));
        channelService.deleteChannelById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Channel> updateChannel(@PathVariable Long id, @Valid @RequestBody Channel newChannel){
        Channel channel = channelService.findChannelById(id).orElseThrow(()-> new EntityNotFoundException("no channel with id " + id));
        channel.setName(newChannel.getName());
        channelService.updateChannel(channel);
        return ResponseEntity.ok(channel);
    }

}
