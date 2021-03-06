package jfxtest.annotated;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import javax.annotation.PostConstruct;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import de.roskenet.jfxsupport.test.GuiTest;
import javafx.scene.control.Button;
@RunWith(SpringRunner.class)
@SpringBootTest
public class AnnotatedUnconventionalNameTest extends GuiTest {
	
	@Autowired
	private Annotated buttonsView;
	
    @PostConstruct
    public void constructView() throws Exception {
        init(buttonsView);
    }
	
	/*
	 * Asserts that we can find a view if the class name doesn't end with 'view'
	 * see https://github.com/roskenet/springboot-javafx-support/issues/38
	 */
	@Test
	public void showsI18nText() throws Exception {
	   Button theButton = (Button) find("#theButton");
	   assertThat(theButton.getText(), is("The default Button Text"));
	}
}
