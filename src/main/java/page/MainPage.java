package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainPage extends BasePage {
    public MainPage() throws IOException {
        super();
        String url="https://work.weixin.qq.com/wework_admin/loginpage_wx?from=0014100135";

        driver.get(url);
        driver.manage().deleteAllCookies();

        //todo：从文件读取
        ChromeOptions options=new ChromeOptions();
        options.setExperimentalOption("debuggerAddress","127.0.0.1:9222");
        driver=new ChromeDriver(options);
        try {
            FileWriter fileWriter = new FileWriter("cookie.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Cookie cookie : driver.manage().getCookies()) {
                bufferedWriter.write(cookie.getName() + ';' + cookie.getValue() + ';' + cookie.getDomain() + ';' + cookie.getExpiry() + ';' + cookie.isSecure());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //cookie

        driver.manage().addCookie(cookie);
        driver.get(url);
    }

    public ContactPage toContact(){
        click(By.cssSelector("#menu_contacts"));
        return new ContactPage(driver);
    }

    public DepartmentPage toDepartment(){
        click(By.cssSelector("#menu_contacts"));
        click(By.cssSelector(".member_colLect_top_addBtn"));
        click(By.linkText("添加部门"));
        return new DepartmentPage(driver);
    }
}
