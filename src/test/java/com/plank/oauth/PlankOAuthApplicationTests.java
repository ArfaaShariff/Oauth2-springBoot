package com.plank.oauth;

import com.plank.oauth.controller.SecureController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Base64;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PlankOAuthApplication.class)
@WebAppConfiguration
public class PlankOAuthApplicationTests {

	protected MockMvc mockMvc;
	protected String token;

	@Autowired
	private SecureController secureController;


	//	@Test
//	public void contextLoads() {
//	}
	public SecureController secured;



//	@Value("${local.server.port}")
//	private int port;

	private String clientBasicAuthCredentials;

	@Before
	public  void setUp(){
		this.clientBasicAuthCredentials= Base64
				.getEncoder()
				.encodeToString("my_client_username:my_client_password".getBytes());
	}

	@Test
	public void secureAuthorization() throws Exception {
//		secured=mock(SecureController.class);
//		when(secured.secure()).then(HttpStatus.UNAUTHORIZED.value());

		this.mockMvc
				.perform(get("/secure")
						.header("Access Token", this.token)
						.header("Origin", "localhost:8000"))
//						.accept(MediaType.parseMediaType(EXPECTED_CONTENT_TYPE))
				.andExpect(status().isUnauthorized())
				.andExpect(content().contentType("application/json;charset=UTF-8"));
	}


}
