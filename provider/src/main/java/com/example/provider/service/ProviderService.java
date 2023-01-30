package com.example.provider.service;
import com.example.provider.pojo.provider;
import com.example.provider.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProviderService {

    private final ProviderRepository providerRepository;

    @Autowired
    public ProviderService(ProviderRepository providerRepository){
        this.providerRepository = providerRepository;
    }

    public provider save(provider user){
        providerRepository.save(user);
        if(user == null) {
            throw new IllegalArgumentException("Can't create student since it's null");
        }
        return user;
    }

    public List<provider> getAll(){
        List<provider> users = new ArrayList<provider>(providerRepository.findAll());
        if(users == null) {
            throw new IllegalArgumentException("Can't create student since it's null");
        }
        return users;
    }

}
