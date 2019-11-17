package com.example.service;

import com.example.model.Beitrag;

import com.example.repository.BeitragRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BeitragService {

    @Autowired
    BeitragRepository beitragRepository;

    public List<Beitrag> getAllBeitraege() {
        List<Beitrag> beitraege = new ArrayList<Beitrag>();
        beitragRepository.findAll().forEach(beitrag -> beitraege.add(beitrag));
        return beitraege;
    }

    public Beitrag getBeitragById(int id) {
        return beitragRepository.findById(id).get();
    }

    public void saveOrUpdate(Beitrag beitrag) {
        beitragRepository.save(beitrag);
    }

    public void delete(int id) {
        beitragRepository.deleteById(id);
    }
}