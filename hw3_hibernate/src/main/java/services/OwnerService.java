package services;

import dao.OwnerDaoImpl;
import models.Pet;
import models.Owner;

import java.util.List;

public class OwnerService {

    private OwnerDaoImpl ownerDao = new OwnerDaoImpl();

    public OwnerService() {
    }

    public Owner findUser(int id) {
        return ownerDao.findById(id);
    }

    public void saveUser(Owner owner) {
        ownerDao.save(owner);
    }

    public void deleteUser(Owner owner) {
        ownerDao.delete(owner);
    }

    public void updateUser(Owner owner) {
        ownerDao.update(owner);
    }

    public List<Owner> findAllUsers() {
        return ownerDao.findAll();
    }

    public Pet findAutoById(int id) {
        return ownerDao.findPetById(id);
    }


}