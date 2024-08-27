package org.example;

import models.Pet;
import models.Owner;
import services.OwnerService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        OwnerService ownerService = new OwnerService();
        Owner owner = new Owner("Masha", "masha@gmail.com");
        ownerService.saveUser(owner);
        Pet dog = new Pet("Cooper", 3);
        dog.setOwner(owner);
        owner.addPet(dog);
        Pet cat = new Pet("Snowy", 5);
        cat.setOwner(owner);
        owner.addPet(cat);
        ownerService.updateUser(owner);

        owner.setName("Sasha");
        ownerService.updateUser(owner);
    }
}