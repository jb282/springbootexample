package com.example;

import com.example.model.Beitrag;
import com.example.model.Role;
import com.example.model.User;
import com.example.repository.BeitragRepository;
import com.example.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Transactional
@Component
public class Setup implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private UserRepo repo;
    @Autowired
    private BeitragRepository beitragRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        //Users
        User admin = new User("admin", "admin", true, Role.ADMIN);

        admin.setUsername("admin");
        admin.setPassword(new BCryptPasswordEncoder().encode("admin"));
        admin.setEmail("admin@gmail.com");
        admin.setPic("https://images.unsplash.com/photo-1497316730643-415fac54a2af?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80");
        admin.setDescription("ilsudfasj sdjfopasjk asdofjasnd fospdjfmas fposjdmf aslofjn sd ofls dfasnd fs dfasd fasklgnäodfm sdk ns sdälfäasodfn asldfk släd fsdf");
        repo.save(admin);
        //Users 2
        User timberlake = new User("timberlake", "admin", true, Role.ADMIN);

        timberlake.setUsername("timberlake");
        timberlake.setPassword(new BCryptPasswordEncoder().encode("admin"));
        timberlake.setEmail("timberlake@gmail.com");
        timberlake.setPic("https://s1.r29static.com/bin/entry/4b3/x,80/1705671/image.jpg");
        timberlake.setDescription("ilsudfasj sdjfopasjk asdofjasnd fospdjfmas fposjdmf aslofjn sd ofls dfasnd fs dfasd fasklgnäodfm sdk ns sdälfäasodfn asldfk släd fsdf");
        repo.save(timberlake);

        //Beitraege
        Beitrag b1 = new Beitrag("Schweiz", "Schokolade", 1);
        b1.setPic("https://swiss-made.shop/media/shop/thumbnails/300x450f/maestrani-schweizer-schokolade-caramel-salz-swiss-made.jpg");
        beitragRepository.save(b1);
        //Beitraege 2
        Beitrag b2 = new Beitrag("USA", "Cheetos", timberlake.getId().intValue());
        b2.setPic("https://images-na.ssl-images-amazon.com/images/I/81hy4pM6YOL._SY445_.jpg");
        beitragRepository.save(b2);
    }

}
