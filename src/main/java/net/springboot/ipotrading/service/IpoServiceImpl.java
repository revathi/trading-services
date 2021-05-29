package net.springboot.ipotrading.service;

import net.springboot.ipotrading.model.Ipo;
import net.springboot.ipotrading.repository.IpoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IpoServiceImpl implements IpoService {

    @Autowired
    private IpoRepository ipoRepository;

    @Override
    public void save(Ipo ipo) {
        ipoRepository.save(ipo);
    }
    public List<Ipo> findAll() {
       return ipoRepository.findAll();}
}

