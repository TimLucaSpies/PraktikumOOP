package business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import business.Tees.Teesorte;

class TeeladenTest {
	Teesorte test1;
	Teesorte test2;
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test1() {
		String arr [] = {"Schwarzer", "Tee"};
		test1 = new Teesorte(945, "Weihnachtstee", "ja", "Zimt", arr);
		assertTrue(()-> test1.getIdentnummer()==945);
	}
	
	@Test
	void test2() {
		assertThrows(IllegalArgumentException.class, () -> test2 = new Teesorte(1, "Test", "Test", "Test", null));
	}
	
//Anforderugen: 
//Testfall 945, Weihnachtstee, ja, Zimt, Schwarzer Tee
}
