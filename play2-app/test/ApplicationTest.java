import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.contentType;

import java.util.ArrayList;

import org.junit.Test;
import org.oregami.entities.Game;

import play.mvc.Content;


/**
*
* Simple (JUnit) tests that can call all parts of a play app.
* If you are interested in mocking a whole application, see the wiki for more details.
*
*/
public class ApplicationTest {

    @Test 
    public void simpleCheck() {
        int a = 1 + 1;
        assertThat(a).isEqualTo(2);
    }
    
    @Test
    public void renderTemplate() {
        Content html = views.html.index.render(new ArrayList<Game>());
        assertThat(contentType(html)).isEqualTo("text/html");
    }
  
   
}