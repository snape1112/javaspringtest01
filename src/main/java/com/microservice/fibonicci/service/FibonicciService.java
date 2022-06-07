package com.microservice.fibonicci.service;

import com.microservice.fibonicci.model.Fibonicci;
import com.microservice.fibonicci.repository.FibonicciRepository;
import com.microservice.fibonicci.service.IFibonicciService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;

@Service
public class FibonicciService implements IFibonicciService {

    @Autowired
    private FibonicciRepository repository;

    @Override
    public List<Fibonicci> findAll() {

        List<Fibonicci> results = (List<Fibonicci>) repository.findAll();

        return results;
    }

    @Override
    @Cacheable("fibonicci")
    public Fibonicci save(Fibonicci entity) {
        Fibonicci res = repository.save(entity);

        return res;
    }

    public Fibonicci findByNumber(int number) {
        List<Fibonicci> res = repository.findByNumber(number);
        if(res.size() == 0) {
            return null;
        }
        else {
            return res.get(0);
        }
    };
}