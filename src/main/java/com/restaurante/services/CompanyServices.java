package com.restaurante.services;

import com.restaurante.dtos.CompanyDto;
import com.restaurante.entities.Company;
import com.restaurante.exceptions.CompanyAlreadyExistsException;
import com.restaurante.exceptions.CompanyNotFoundException;
import com.restaurante.exceptions.InternalServerErrorException;
import com.restaurante.exceptions.MethodNotSuportedException;
import com.restaurante.repositories.CompanyRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.MethodInvocationException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CompanyServices {

    private final CompanyRepository companyRepository;
    private final ModelMapper mapper;

    public CompanyDto create(CompanyDto companyDto) {
        try {
            Long count = companyRepository.count();
            if (count > 0) {
                throw new CompanyAlreadyExistsException();
            }

            Company company = mapper.map(companyDto, Company.class);
            companyRepository.save(company);
            CompanyDto retorno = mapper.map(company, CompanyDto.class);
            return  retorno;

        }catch (DataAccessException err){
            throw new InternalServerErrorException();
        }
    }

    public List<CompanyDto> list() {
        try {
            List<Company> companyList = companyRepository.findAll();
            if (companyList.isEmpty()) {
                throw new CompanyNotFoundException();
            }
            return companyList.stream().map(CompanyDto::new).collect(Collectors.toList());
        }catch (DataAccessException err){
            throw new InternalServerErrorException();
        }
    }

    public void update(CompanyDto companyDto){
        try {
            Optional<Company> companyOptional = companyRepository.findByCnpj("13647699000128");

            Company company = new Company();
            BeanUtils.copyProperties(companyDto, company);
            company.setId(company.getId());
            company.setCnpj(company.getCnpj());
            companyRepository.save(company);
        }catch (DataAccessException err){
            throw new InternalServerErrorException();
        }
    }

    public void delete(String cnpj) {
        try {
            Optional<Company> companyOptional = companyRepository.findByCnpj(cnpj);
            if (companyOptional.isEmpty()) {
                throw new CompanyNotFoundException();
            }
            try {
                companyRepository.deleteById(companyOptional.get().getId());
            }catch (MethodInvocationException e){
                throw new MethodNotSuportedException();
            }
        }catch (DataAccessException err){
            throw new InternalServerErrorException();
        }
    }
}
