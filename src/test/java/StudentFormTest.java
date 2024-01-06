import manager.AppManager;
import manager.HelperStudent;
import models.Gender;
import models.Hobby;
import models.StudentDTO;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class StudentFormTest extends TestBase {
    @BeforeMethod
    public void precondition(){
        selectForms();
        selectPracticeForms();
    }

    @Test
    public void StudentFormTest(){
        List<Hobby> hobbies = new ArrayList<>();
        hobbies.add(Hobby.MUSIC);
        hobbies.add(Hobby.READING);

        StudentDTO student = StudentDTO.builder()
                .firstName("Mikki")
                .lastName("Rurck")
                .email("mikki@gmail.com")
                .gender(Gender.MALE)
                .phone("1234567890")
                .birthday("3 8 1982")
                .subjects("Maths,Physics")
                .hobbies(hobbies)
                .address("Main street, 5")
                .state("NCR")
                .city("Delhi")
                .build();
        cleanFooter();
        cleanDiv();
        fillForm(student);
        submit();
    }
}
