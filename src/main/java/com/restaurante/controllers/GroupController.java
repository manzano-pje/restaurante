package com.restaurante.controllers;

import com.restaurante.dtos.GroupsDto;
import com.restaurante.services.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(name = "/v1/group")
public class GroupController {

    private final GroupService groupService;

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody GroupsDto groupsDto){
        GroupsDto groupsReturn = groupService.create(groupsDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
                .buildAndExpand(groupsReturn.getIdGroup()).toUri();
        return ResponseEntity.created(uri).body("Group created.");
    }

    @GetMapping
    public List<GroupsDto> listAll(){
        return groupService.listAll();
    }

    @GetMapping("/{id}")
    public GroupsDto listOneGroup(@PathVariable long id){
        return groupService.listOneGroup(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody GroupsDto groupsDto){
        groupService.update(id, groupsDto);
        return ResponseEntity.ok("Group updated.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        groupService.delete(id);
        return ResponseEntity.ok("Group deleted.");
    }

}
