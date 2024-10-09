package models.dao;

import db.DB;
import models.dao.impl.DepartmentDaoJDBC;
import models.dao.impl.SellerDaoJdbc;


public class DaoFactory {
    public static SellerDao createSellerDao(){
        return new SellerDaoJdbc(DB.getConnection());
    }

    public static DepartmentDao createDepartmentDao() {
        return new DepartmentDaoJDBC(DB.getConnection());
    }
}
