package model.dao;

import model.dao.impl.DepartmentDaoJDBC;
import model.dao.impl.SellerDaoJDBC;

import static db.DB.getConnection;

public class DaoFactory {
    public static SellerDao createSellerDao() {
        return new SellerDaoJDBC(getConnection());
    }

    public static DepartmentDao createDepartmentDao() {
        return new DepartmentDaoJDBC(getConnection());
    }
}
