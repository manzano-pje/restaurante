package com.restaurante.services;

import com.restaurante.entities.Company;
import com.restaurante.exceptions.CompanyAlreadyExistsException;
import com.restaurante.exceptions.CompanyNotFoundException;
import com.restaurante.exceptions.InternalServerErrorException;
import com.restaurante.exceptions.MethodNotSuportedException;
import com.restaurante.record.CompanyRecord;
import com.restaurante.repositories.CompanyRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.MethodInvocationException;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CompanyServices {

    private final CompanyRepository companyRepository;

    public CompanyRecord create(CompanyRecord companyRecord) {
        try {
            Optional<Company> optionalCompany = companyRepository.findByCnpj(companyRecord.cnpj());

            if (optionalCompany.isPresent()) {
                throw new CompanyAlreadyExistsException();
            }
            Company company = new Company();
            BeanUtils.copyProperties(companyRecord,company);
            companyRepository.save(company);
            return companyRecord;

        }catch (DataAccessException err){
            throw new InternalServerErrorException();
        }
    }

    public List<CompanyRecord> list() {
        try {
            List<Company> companyList = companyRepository.findAll();
            if (companyList.isEmpty()) {
                throw new CompanyNotFoundException();
            }
            return (companyList.stream().map(CompanyRecord::new).collect(Collectors.toList()));
        }catch (DataAccessException err){
            throw new InternalServerErrorException();
        }
    }

    public void update(CompanyRecord companyRecord){
        try {
            Company company = companyRepository.findByCnpj(companyRecord.cnpj()).orElseThrow(CompanyNotFoundException::new);

            BeanUtils.copyProperties(companyRecord, company);
            company.setIdCompany(company.getIdCompany());
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
                companyRepository.deleteById(companyOptional.get().getIdCompany());
            }catch (MethodInvocationException e){
                throw new MethodNotSuportedException();
            }
        }catch (DataAccessException err){
            throw new InternalServerErrorException();
        }
    }
}
