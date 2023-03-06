package com.example.WishlistSanta;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;


@SpringBootTest
@AutoConfigureMockMvc
class WishlistSantaApplicationTests {

	@Autowired
	private WishlistRepository repository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testWishGenerator()  {
		ArrayList<User> lists = new ArrayList<>();
		lists = repository.wishGenerator();
		String testName = "Nils";
		Assertions.assertEquals("Nils", lists.get(0).getName());
	}



}
