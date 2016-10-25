package com.ipartek.formacion.perrera.controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ws.rs.core.Response;

public class PerroControlllerTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetAll() {
		
		PerroController controller = new PerroController();
		
		Response response = controller.getAll("asc", "id");
		
		assertEquals( 200, response.getStatus() );
		
		//ordenacion ascendente por id
		
		
		
		response = controller.getAll("desc", "id");
		
		
		//ordenacion descendente por id
		
		
		
	}

}
