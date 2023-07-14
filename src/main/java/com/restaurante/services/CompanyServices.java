package com.restaurante.services;

import com.restaurante.dtos.CompanyDto;
import com.restaurante.entities.Company;
import com.restaurante.exceptions.CompanyExistException;
import com.restaurante.exceptions.CompanyNotFoundException;
import com.restaurante.exceptions.InternalServerErrorException;
import com.restaurante.repositories.CompanyRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CompanyServices {

    private final CompanyRepository companyRepository;

    public Company createCompany(CompanyDto companyDto) {
        try {
            List<Company> companyList = companyRepository.findAll();
            if (!companyList.isEmpty()) {
                throw new CompanyExistException();
            }
            Company company = new Company();
            BeanUtils.copyProperties(companyDto, company);
            companyRepository.save(company);
            return null;
        }catch (DataAccessException err){
            throw new InternalServerErrorException();
        }
    }

    public List<CompanyDto> listCompany() {
        try {
            List<Company> companyList = companyRepository.findAll();
            if (companyList.isEmpty()) {
                throw new CompanyNotFoundException();
            }
            return (companyList.stream().map(CompanyDto::new).collect(Collectors.toList()));
        }catch (DataAccessException err){
            throw new InternalServerErrorException();
        }
    }

    public Company updateCompany(CompanyDto companyDto){
        try {
            List<Company> companyList = companyRepository.findAll();
            if (companyList.isEmpty()) {
                throw new CompanyNotFoundException();
            }
            Company company = new Company();
            BeanUtils.copyProperties(companyDto, company);
            company.setIdCompany(companyList.get(0).getIdCompany());
            company.setCnpj(companyList.get(0).getCnpj());
            companyRepository.save(company);
            return null;
        }catch (DataAccessException err){
            throw new InternalServerErrorException();
        }
    }

    public Company deleteCompany() {
        try {
            List<Company> companyList = companyRepository.findAll();
            if (companyList.isEmpty()) {
                throw new CompanyNotFoundException();
            }
            companyRepository.deleteById(companyList.get(0).getIdCompany());
            return null;
        }catch (DataAccessException err){
            throw new InternalServerErrorException();
        }

    }
}
