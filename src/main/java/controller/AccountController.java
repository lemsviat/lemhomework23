package controller;

import repository.GenericRepository;
import repository.hibernate.AccountHibernateRepositoryImpl;

public class AccountController {
    //GenericRepository accountRepository= new AccountRepositoryImpl();
    GenericRepository accountRepository= new AccountHibernateRepositoryImpl();

    public void create(){
        accountRepository.create();

    }
    public void read(){
    }
    public void update(){
    }
    public void delete(){
        accountRepository.delete();
    }
}
