package um.edu.uy;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = MainRestaurante.class)
@RunWith(SpringRunner.class)
public class TestImagenes {

	@Test
	public void test() throws IOException {
		File file = new File("C:\\Users\\Rainer\\Desktop\\IMG1.jpg");
		byte[] fileContent = Files.readAllBytes(file.toPath());
		System.out.println(fileContent);
		
		
	}
	
	

}
