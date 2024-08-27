package dao;

import models.Owner;

public interface OwnerDao {

    Owner findById(int id);

    void save(Owner owner);

    void update(Owner owner);

    void delete(Owner owner);

}
