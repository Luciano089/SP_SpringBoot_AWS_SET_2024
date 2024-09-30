package models.dao;

import models.dao.impl.SellerDaoJdbc;

public class DaoFactory {
    public static SellerDao createSellerDao(){
        return new SellerDaoJdbc();
    }
}
