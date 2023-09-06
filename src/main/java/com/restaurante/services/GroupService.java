package com.restaurante.services;

import com.restaurante.dtos.GroupsDto;
import com.restaurante.entities.Groups;
import com.restaurante.exceptions.groups.GroupAlerdyExistExceptioin;
import com.restaurante.exceptions.groups.GroupNotExistException;
import com.restaurante.exceptions.groups.GroupNotFoundException;
import com.restaurante.repositories.GroupRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GroupService {

    private final GroupRepository groupRepository;
    private final ModelMapper mapper;

    public GroupsDto create(GroupsDto groupsDto){
        Optional<Groups> groupsOptional = groupRepository.findByName(groupsDto.getName());
        if (groupsOptional.isPresent()){
            throw new GroupAlerdyExistExceptioin();
        }

        Groups group = mapper.map(groupsDto, Groups.class);
        groupRepository.save(group);
        return mapper.map(group, GroupsDto.class);
    }

    public List<GroupsDto> listAll(){
        List<Groups> groupsList = groupRepository.findAll();
        if(groupsList.isEmpty()){
            throw new GroupNotFoundException();
        }
        return groupsList.stream().map(GroupsDto::new).collect(Collectors.toList());
    }

    public GroupsDto listOneGroup(Long id){
        Optional<Groups> groupsOptinal = groupRepository.findById(id);
        if (groupsOptinal.isEmpty()){
            throw new GroupNotExistException();
        }

        return mapper.map(groupsOptinal.get(), GroupsDto.class);
    }

    public GroupsDto update(Long id, GroupsDto groupsDto){
        Optional<Groups> groupsOptinal = groupRepository.findById(id);
        if (groupsOptinal.isEmpty()){
            throw new GroupNotExistException();
        }
        Groups group = mapper.map(groupsDto, Groups.class);
        group.setIdGroup(groupsOptinal.get().getIdGroup());
        groupRepository.save(group);
        return null;
    }

    public void delete(Long id){
        Optional<Groups> groupsOptinal = groupRepository.findById(id);
        if (groupsOptinal.isEmpty()){
            throw new GroupNotExistException();
        }
        groupRepository.deleteById(id);
    }
}
