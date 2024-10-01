package models.dao.impl;

import db.DB;
import db.dbException;
import models.dao.SellerDao;
import models.entities.Department;
import models.entities.Seller;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SellerDaoJdbc implements SellerDao {

    private Connection conn;

    public SellerDaoJdbc(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void update(Seller obj) {

    }

    @Override
    public void insert(Seller obj) {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(
                    "INSERT INTO seller \n" +
                            "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
                            +  "VALUES "
                            + "(?, ?, ?, ?, ?) ", Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, obj.getName());
            stmt.setString(2, obj.getEmail());
            stmt.setDate(3, new java.sql.Date(obj.getBirthDate().getTime()));
            stmt.setDouble(4, obj.getBaseSalary());
            stmt.setInt(5, obj.getDepartment().getId());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);

                    obj.setId(id);
                }
                DB.closeResultSet(rs);
            } else {
                throw new dbException("Insert failed");
            }

        } catch (SQLException e) {
            throw new dbException(e.getMessage());
        } finally {
            DB.closeStatment(stmt);
        }

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Seller findById(Integer id) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(
                    "SELECT seller.*,department.Name as DepName "
                            + "FROM seller INNER JOIN department "
                            + "ON seller.DepartmentId = department.Id "
                            + "WHERE seller.Id = ? "
            );

            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                Department dep = instantiateDepartment(rs);
                Seller obj = intantiateSeller(rs, dep);
                return obj;
            }
            return null;
        } catch (SQLException e) {
            throw new dbException(e.getMessage());
        } finally {
            DB.closeStatment(stmt);
            DB.closeResultSet(rs);

        }

    }

    private Seller intantiateSeller(ResultSet rs, Department dep) throws SQLException {
        Seller obj = new Seller();
        obj.setId(rs.getInt("Id"));
        obj.setName(rs.getString("Name"));
        obj.setEmail(rs.getString("Email"));
        obj.setBaseSalary(rs.getDouble("BaseSalary"));
        obj.setBirthDate(rs.getDate("BirthDate"));
        obj.setDepartment(dep);
        return obj;
    }

    private Department instantiateDepartment(ResultSet rs) throws SQLException {
        Department dep = new Department();
        dep.setId(rs.getInt("DepartmentId"));
        dep.setName(rs.getString("DepName"));
        return dep;
    }

    @Override
    public List<Seller> findAll() {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(
                    "SELECT seller.*,department.Name as DepName "
                            + "FROM seller INNER JOIN department  "
                            + "ON seller.DepartmentId = department.Id "
                            + "ORDER BY Name "
            );

            rs = stmt.executeQuery();
            List<Seller> sellersList = new ArrayList<>();
            Map<Integer, Department> map = new HashMap<>();
            while (rs.next()) {
                Department dep = map.get(rs.getInt("DepartmentId"));
                if (dep == null) {
                    dep = instantiateDepartment(rs);
                    map.put(rs.getInt("DepartmentId"), dep);
                }
                Seller obj = intantiateSeller(rs, dep);
                sellersList.add(obj);

            }
            return sellersList;

        } catch (SQLException e) {
            throw new dbException(e.getMessage());
        } finally {
            DB.closeStatment(stmt);
            DB.closeResultSet(rs);

        }
    }

    @Override
    public List<Seller> findByDepartment(Department department) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(
                    "SELECT seller.*,department.Name as DepName "
                            + "FROM seller INNER JOIN department  "
                            + "ON seller.DepartmentId = department.Id "
                            + "WHERE DepartmentId = ? "
                            + "ORDER BY Name "
            );

            stmt.setInt(1, department.getId());
            rs = stmt.executeQuery();
            List<Seller> sellersList = new ArrayList<>();
            Map<Integer, Department> map = new HashMap<>();
            while (rs.next()) {
                Department dep = map.get(rs.getInt("DepartmentId"));
                if (dep == null) {
                    dep = instantiateDepartment(rs);
                    map.put(rs.getInt("DepartmentId"), dep);
                }
                Seller obj = intantiateSeller(rs, dep);
                sellersList.add(obj);

            }
            return sellersList;

        } catch (SQLException e) {
            throw new dbException(e.getMessage());
        } finally {
            DB.closeStatment(stmt);
            DB.closeResultSet(rs);

        }
    }

}
