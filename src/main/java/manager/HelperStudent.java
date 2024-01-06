package manager;

import models.Gender;
import models.Hobby;
import models.StudentDTO;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public interface HelperStudent extends HelperBase {

    default void selectForms() {
        if (isElementPresent(By.id("adplus-anchor")))
            clean();
        click(By.xpath("//div[@class='category-cards']/div[2]"));
    }

    default void selectPracticeForms() {
        click(By. xpath (  "//span[.='Practice Form']"));

    }

    default void fillForm(StudentDTO student) {
        type(By.id("firstName"), student.getFirstName());
        type(By.id("lastName"), student.getLastName());
        type(By.id("userEmail"), student.getEmail());
        selectorGender(student.getGender());
        type(By.id("userNumber"), student.getPhone());
       // type(By.id("dateOfBirthInput"), student.getBirthday());
       // typeBDay( student.getBirthday());
        selectBDay(student.getBirthday());
        addSubject(student.getSubjects());
        selectHobby(student.getHobbies());
        addPicture();
        type(By.id("currentAddress"), student.getAddress());
        typeState(student.getState());
        typeCity(student.getCity());
    }


    default void selectorGender(Gender gender) {
        JavascriptExecutor js = (JavascriptExecutor) wd;

        if (gender.equals(Gender.MALE)) {
           // js.executeScript("document.querySelector('#gender-radio-1').click();");
           click(By. xpath ( "//Label[@for='gender-radio-1']"));
        } else if (gender.equals(Gender.FEMALE)) {
            click(By. xpath ( "//Label[@for='gender-radio-2']"));
           // js.executeScript("document.querySelector('#gender-radio-2').click();");
        } else {
            click(By. xpath ( "//Label[@for='gender-radio-3']"));
           // js.executeScript("document.querySelector('#gender-radio-3').click();");
        }


    }

    default void typeBDay(String birthDate){
        WebElement date = wd.findElement(By.xpath("//*[@id='dateOfBirthInput']"));
//        JavascriptExecutor js = (JavascriptExecutor) wd;
//        js.executeScript("document.querySelector('#dateOfBirthInput').click();");
        date.click();
        String os = System.getProperty("os.name");
        System.out.println("os: " + os);
        if(os.startsWith("Mac")){
            date.sendKeys(Keys.chord(Keys.COMMAND,"a"));
        }else {
            date.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        }
        date.sendKeys(birthDate);
        date.sendKeys(Keys.ENTER);
    }

    default void selectBDay(String birthday){
        String[] date = birthday.split(" ");
      click(By.xpath("//*[@id='dateOfBirthInput']"));
      new Select(wd.findElement(By.className ("react-datepicker__month-select"))).selectByValue(date[0]);
      new Select(wd.findElement(By.className ("react-datepicker__year-select"))).selectByValue(date[2]);
        click(By.xpath(  "//div[.='" + date [1] + "']")) ;

    }

    default void addSubject(String subjects) {
        String[] split = subjects.split(",");
//        JavascriptExecutor js = (JavascriptExecutor) wd;
//        js.executeScript("document.querySelector('#subjectsInput').click();");
       String locator = "subjectsInput";
        click(By.id(locator));
        for (String subject : split) {
            wd.findElement(By.id(locator)).sendKeys(subject);
            wd.findElement(By.id(locator)).sendKeys(Keys.ENTER);
        }
    }

    default void selectHobby(List<Hobby> hobbies) {
        for (Hobby hobby : hobbies) {
            switch (hobby) {
                case SPORTS:
                    click(By.xpath( "//Label[@for='hobbies-checkbox-1']"));
                    break;
                case READING:
                    click(By.xpath( "//Label[@for='hobbies-checkbox-2']"));
                    break;
                case MUSIC:
                    click(By.xpath( "//Label[@for='hobbies-checkbox-3']"));
                    break;

            }
        }
    }


    default void addPicture(){
        wd.findElement(By.id("uploadPicture"))
                .sendKeys("/Users/olgakolchina/Documents/QA40/DemoQA/icons8-team-FcLyt7lW5wg-unsplash.jpg");


    }

    default void typeState(String state) {
        wd.findElement(By.id("react-select-3-input")).sendKeys(state);
        wd.findElement(By.id("react-select-3-input")).sendKeys(Keys.ENTER);

    }

    default void typeCity(String city) {
        wd.findElement(By.id("react-select-4-input")).sendKeys(city);
        wd.findElement(By.id("react-select-4-input")).sendKeys(Keys.ENTER);

    }

    default void submit() {
       // click(By.id("submit"));
        click(By.xpath("//*[@id='submit']"));
    }


}
//*[@id="dateOfBirthInput"]