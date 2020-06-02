package page;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class ContactPage extends BasePage{
    By addMenber= By.linkText("添加成员");
    By username=By.name("username");
    By delate =By.linkText("删除");
    By departmentName=By.name("departmenrtName");
    By ownerDepartment=By.xpath("//*[@id=\"1688850821748232_anchor\"]");


    public ContactPage(RemoteWebDriver driver){
        super(driver);
    }

    public ContactPage addMember(String username,String acctid,String mobile){
        while (driver.findElements(this.username).size()==0){
            click(addMenber);
        }

        sendkeys(this.username,username);
        sendkeys(By.name("acctid"),acctid);
        sendkeys(By.name("mobile"),mobile);
        click(By.cssSelector(".js_btn_save"));

        return this;
    }

    public ContactPage search(String keyword){
        sendkeys(By.id("memberSearchInput"),keyword);
        return this;

    }

    public String getUserName(){
        return  driver.findElement(By.cssSelector(".member_display_cover_detail_name")).getText();

    }

    public ContactPage delete(){
        click(By.cssSelector(".js_delete"));
        click(By.linkText("确认"));
        click(By.id("clearMemberSearchInput"));
        return this;
    }

    public ContactPage importFromFile(URL path){
        System.out.println(path.getPath());
        return this;
    }

    public ContactPage addDepartment(String departmentName, String ownerDepartment){
        sendkeys(this.departmentName,departmentName);
        sendkeys(this.ownerDepartment,ownerDepartment);
        click(By.linkText("确定"));
        return null;
    }
}
