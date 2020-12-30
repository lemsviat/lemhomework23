package controller;

import repository.GenericRepository;
import repository.hibernate.AccountHibernateRepositoryImpl;

public class AccountController {
    GenericRepository accountRepository= new AccountHibernateRepositoryImpl();
}
