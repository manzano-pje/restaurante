package com.restaurante.services;

import com.restaurante.dtos.CompanyDto;
import com.restaurante.entities.Company;
import com.restaurante.repositories.CompanyRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CompanyServices {

    private final CompanyRepository companyRepository;

    public ResponseEntity<Object> createCompany(CompanyDto companyDto) {
        List<Company> companyList = companyRepository.findAll();
        if(!companyList.isEmpty()){
            //throw new CompanyExistException();
            return ResponseEntity.status(HttpStatus.CONFLICT).body("There is already a company registered.");
        }
        Company company = new Company();
        BeanUtils.copyProperties(companyDto, company);
        companyRepository.save(company);
        return ResponseEntity.status(HttpStatus.CREATED).body("Company created.");
    }

    public ResponseEntity<Object> listCompany(){
        List<Company> companyList = companyRepository.findAll();
        if(companyList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Company not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(companyList.stream().map(CompanyDto::new).collect(Collectors.toList()));
    }

    public ResponseEntity<Object> updateCompany(CompanyDto companyDto){
        List<Company> companyList = companyRepository.findAll();
        if(companyList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Company not found.");
        }
        Company company = new Company();
        BeanUtils.copyProperties(companyDto, company);
        company.setIdCompany(companyList.get(0).getIdCompany());
        company.setCnpj(companyList.get(0).getCnpj());
        companyRepository.save(company);
        return ResponseEntity.status(HttpStatus.OK).body("The company has been updated.");
    }

    public ResponseEntity<Object> deleteCompany(){
        List<Company>companyList = companyRepository.findAll();
        if(companyList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Company not found.");
        }
        companyRepository.deleteById(companyList.get(0).getIdCompany());
        return ResponseEntity.status(HttpStatus.OK).body("The company has been deleted");
    }
}
