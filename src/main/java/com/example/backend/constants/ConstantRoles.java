package com.example.backend.constants;

import java.util.HashMap;
import java.util.Map;

public class ConstantRoles {
    public final static String[] TownInvestArray = {"Sheriff", "Investigator", "Lookout", "Spy"};
    public final static String[] TownKillingArray = {"Vigilante", "Veteran"};
    public final static String[] TownProtectiveArray = {"Bodyguard", "Doctor"};
    public final static String[] TownSupportArray = {"Mayor", "Escort", "Medium", "Retributionist", "Traansporter"};
    public final static String[] RandomMafia = {"Disguiser", "Forger", "Framer", "Janitor", "Blackmailer", "Consigliere", "Consort"};
    public final static String[] NeutralEvil = {"Jester", "Witch", "Executioner"};
    public final static String[] NeutralKilling = {"Arsonist", "Werewolf", "Serial Killer"};

    public static Map<String, Integer> role_to_index;
    static
    {
        role_to_index = new HashMap<>();
        int index = 0;
        role_to_index.put("Jailor", index);
        index += 1;
        for (String role : TownInvestArray) {
            role_to_index.put(role, index);
            index += 1;
        }
        for (String role : TownKillingArray) {
            role_to_index.put(role, index);
            index += 1;
        }
        for (String role : TownProtectiveArray) {
            role_to_index.put(role, index);
            index += 1;
        }
        for (String role : TownSupportArray) {
            role_to_index.put(role, index);
            index += 1;
        }
        role_to_index.put("Godfather", index);
        index += 1;
        role_to_index.put("Mafioso", index);
        index += 1;
        for (String role : RandomMafia) {
            role_to_index.put(role, index);
            index += 1;
        }
        for (String role : NeutralEvil) {
            role_to_index.put(role, index);
            index += 1;
        }
        for (String role : NeutralKilling) {
            role_to_index.put(role, index);
            index += 1;
        }
    }
}