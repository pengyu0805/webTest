package testcase;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import page.ContactPage;
import page.MainPage;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestContact {
    static MainPage main;
    static ContactPage contact;
    @BeforeAll
    static void beforeAll() throws IOException {
        main=new MainPage();
        contact=main.toContact();
    }

    @Test
    void testAddMember(){
        String username=contact.addMember("test1","test1","13012345678").search("test1").getUserName();
        assertEquals(username,"test1");

    }

    @Test
    void  testImportFromFile(){
        contact.importFromFile(this.getClass().getResource("/通讯录批量导入模板.xlsx"));
    }

    @Test
    void testAddDepartment(){
        ContactPage departmentName=contact.addDepartment("部门1","py");

    }


    @AfterAll
    static void afterAll(){
        try {
            Thread.sleep(20000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        contact.quit();

    }

}
