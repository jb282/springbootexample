package com.example.controller;

import com.example.model.Beitrag;
import com.example.model.User;
import com.example.repository.BeitragRepository;
import com.example.repository.UserRepo;
import com.example.service.BeitragService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BeitragController {


    @Autowired
    BeitragService beitragService;
    @Autowired
    BeitragRepository beitragRepository;
    String currentUserName = "";
    @Autowired
    UserRepo userRepo;

    @RequestMapping(method = RequestMethod.GET, value = "/getAllBeitraege")
    private ResponseEntity getAllBeitraege() {
        return ResponseEntity.ok().body(beitragService.getAllBeitraege());
    }

    @GetMapping("/beitraege")
    private List<Beitrag> getAllXBeitraege() {
        return beitragService.getAllBeitraege();
    }

    @GetMapping("/beitraege/{id}")
    private Beitrag getBeitrag(@PathVariable("id") int id) {
        return beitragService.getBeitragById(id);
    }

    @DeleteMapping("/beitraege/{id}")
    private void deleteBeitrag(@PathVariable("id") int id) {
        beitragService.delete(id);
    }

    @PostMapping("/beitraege")
    private int saveBeitrag(@RequestBody Beitrag beitrag) {
        beitragService.saveOrUpdate(beitrag);
        return beitrag.getId();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/newBeitrag")
    private ResponseEntity newBeitrag(@RequestBody Beitrag newBeitrag) {

        Beitrag beitrag = newBeitrag;

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            currentUserName = authentication.getName();
        } else {
            currentUserName = "null";
        }
        beitrag.setMitbringerId(userRepo.findByUsername(currentUserName).getId());
        beitragRepository.save(beitrag);
        return ResponseEntity.ok().body(null);
    }
}