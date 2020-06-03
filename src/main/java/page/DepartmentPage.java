package page;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DepartmentPage extends BasePage{
    By departmentName;

    public DepartmentPage(RemoteWebDriver driver) {
        super(driver);
        departmentName = By.name(String.valueOf(departmentName));
    }

    public DepartmentPage addDepartment(String departmentName){
        sendkeys(this.departmentName,departmentName);
        click(By.linkText("选择所属部门"));
        click(By.cssSelector(".jstree-2#\\31688850821748232_anchor"));
        click(By.linkText("确定"));
        return null;
    }


}
