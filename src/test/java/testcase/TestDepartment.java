package testcase;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import page.DepartmentPage;
import page.MainPage;

import java.io.IOException;

public class TestDepartment {
    static MainPage main;
    static DepartmentPage department;


    @BeforeAll
    static void beforeAll() throws IOException {
        main=new MainPage();
        department=main.toDepartment();
    }

    @Test
    void addDepartment(){

    }
}
