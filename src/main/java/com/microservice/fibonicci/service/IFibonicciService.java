package com.microservice.fibonicci.service;

import com.microservice.fibonicci.model.Fibonicci;

import java.util.List;

public interface IFibonicciService {
    List<Fibonicci> findAll();
    Fibonicci save(Fibonicci entity);
    Fibonicci findByNumber(int number);
}