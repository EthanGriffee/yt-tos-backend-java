package com.example.backend.persist;

import java.util.ArrayList;

import javax.annotation.PostConstruct;

import com.example.backend.models.Role;
import com.example.backend.models.Role.Type;
import com.example.backend.repositories.RoleRepository;
import com.example.backend.constants.ConstantRoles;

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
        for (String role : ConstantRoles.TownInvestArray) saving.add(new Role(role, Type.TOWN_INVESTIGATIVE)); 
        for (String role : ConstantRoles.TownKillingArray) saving.add(new Role(role, Type.TOWN_KILLING));
        for (String role : ConstantRoles.TownProtectiveArray) saving.add(new Role(role, Type.TOWN_PROTECTIVE));
        for (String role : ConstantRoles.TownSupportArray) saving.add(new Role(role, Type.TOWN_SUPPORT));
        saving.add(new Role("Godfather", Type.GODFATHER));
        saving.add(new Role("Mafioso", Type.MAFIOSO));
        for (String role : ConstantRoles.RandomMafia) saving.add(new Role(role, Type.RANDOM_MAFIA));
        for (String role : ConstantRoles.NeutralEvil) saving.add(new Role(role, Type.NEUTRAL_EVIL));
        for (String role : ConstantRoles.NeutralKilling) saving.add(new Role(role, Type.NEUTRAL_KILLING));
        roleRepo.saveAll(saving);
    }

}