package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;
import model.utils.TranslationsConstants;

import java.util.List;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== TEST 1: department insert ===");
        Department newDepartment = new Department(null, "Pets");
        departmentDao.insert(newDepartment);

        System.out.println("Inserted! New id = " + newDepartment.getId());

        System.out.println("\n=== TEST 2: department update ===");
        Department department = departmentDao.findById(10);
        department.setName("Flowers");

        departmentDao.update(department);
        System.out.println(TranslationsConstants.UPDATE_COMPLETED);

        System.out.println("\n=== TEST 3: department findById ===");
        department = departmentDao.findById(10);
        System.out.println(department);

        System.out.println("\n=== TEST 4: department deleteById ===");
        System.out.print("Enter id for delete test: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println(TranslationsConstants.DELETE_COMPLETED);

        System.out.println("\n=== TEST 5: department findAll ===");
        List<Department> list = departmentDao.findAll();

        for (Department obj : list) {
            System.out.println(obj);
        }

        sc.close();
    }
}
