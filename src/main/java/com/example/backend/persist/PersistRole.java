package com.example.backend.persist;

import java.util.ArrayList;

import javax.annotation.PostConstruct;

import com.example.backend.models.Role;
import com.example.backend.models.Role.Type;
import com.example.backend.repositories.RoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersistRole {

    @Autowired
    RoleRepository roleRepo;

    @PostConstruct
    public void initApiUserData() {
        ArrayList<Role> saving = new ArrayList<Role>();
        saving.add(new Role("Jailor", Type.JAILOR));      
        saving.add(new Role("Sheriff", Type.TOWN_INVESTIGATIVE)); 
        saving.add(new Role("Investigator", Type.TOWN_INVESTIGATIVE));      
        saving.add(new Role("Lookout", Type.TOWN_INVESTIGATIVE)); 
        saving.add(new Role("Spy", Type.TOWN_INVESTIGATIVE)); 
        saving.add(new Role("Vigilante", Type.TOWN_KILLING));
        saving.add(new Role("Veteran", Type.TOWN_KILLING));
        saving.add(new Role("Body Guard", Type.TOWN_PROTECTIVE));
        saving.add(new Role("Doctor", Type.TOWN_PROTECTIVE));
        saving.add(new Role("Escort", Type.TOWN_SUPPORT));
        saving.add(new Role("Mayor", Type.TOWN_SUPPORT));
        saving.add(new Role("Medium", Type.TOWN_SUPPORT));
        saving.add(new Role("Retributionist", Type.TOWN_SUPPORT));
        saving.add(new Role("Transporter", Type.TOWN_SUPPORT));
        saving.add(new Role("Godfather", Type.GODFATHER));
        saving.add(new Role("Mafioso", Type.MAFIOSO));
        saving.add(new Role("Disguiser", Type.RANDOM_MAFIA));
        saving.add(new Role("Forger", Type.RANDOM_MAFIA));
        saving.add(new Role("Framer", Type.RANDOM_MAFIA));
        saving.add(new Role("Janitor", Type.RANDOM_MAFIA));
        saving.add(new Role("Blackmailer", Type.RANDOM_MAFIA));
        saving.add(new Role("Consigliere", Type.RANDOM_MAFIA));
        saving.add(new Role("Consort", Type.RANDOM_MAFIA));
        saving.add(new Role("Jester", Type.NEUTRAL_EVIL));
        saving.add(new Role("Witch", Type.NEUTRAL_EVIL));
        saving.add(new Role("Executioner", Type.NEUTRAL_EVIL));
        saving.add(new Role("Arsonist", Type.NEUTRAL_KILLING));
        saving.add(new Role("Werewolf", Type.NEUTRAL_KILLING));
        saving.add(new Role("Serial Killer", Type.NEUTRAL_KILLING));
        roleRepo.saveAll(saving);
    }

}