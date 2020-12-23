package controller;

import repository.GenericRepository;
import repository.hibernate.SpecialtyHibernateRepositoryImpl;

public class SpecialtyController {
    //GenericRepository specialtyRepository= new SpecialtyRepositoryImpl();
    GenericRepository specialtyRepository= new SpecialtyHibernateRepositoryImpl();

    public void create(){
        specialtyRepository.create();
    }
    public void read(){
    }
    public void update(){
    }
    public void delete(){
    }
}
