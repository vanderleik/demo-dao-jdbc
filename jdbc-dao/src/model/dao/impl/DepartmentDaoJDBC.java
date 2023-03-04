package model.dao.impl;

import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;
import model.utils.TranslationsConstants;

import java.sql.*;
import java.util.List;
import java.util.Objects;

public class DepartmentDaoJDBC implements DepartmentDao {
    private Connection conn;

    public DepartmentDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Department obj) {
        PreparedStatement st = null;
        if (Objects.isNull(obj.getName())) {
            throw new DbException(TranslationsConstants.NAME_NULL);
        }
        try {
            st = conn.prepareStatement(
                    "INSERT INTO department " +
                        "(Name)" +
                        "VALUES(?);",
                    Statement.RETURN_GENERATED_KEYS);//Retorna o id do departamento criado
        st.setString(1, obj.getName());

        int rowsAffected = st.executeUpdate();
        if (rowsAffected > 0) {
            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                obj.setId(id);
            }
            DB.closeResultSet(rs);
        } else {
            throw new DbException("Unexpected error! " + TranslationsConstants.NO_ROWS_AFFECTED);
        }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }

    }

    @Override
    public void update(Department obj) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Department findById(Integer id) {
        return null;
    }

    @Override
    public List<Department> findAll() {
        return null;
    }
}
