package com.socks.tests;

import com.github.javafaker.Faker;
import com.socks.api.ProjectConfig;
import com.socks.api.responses.UserLoginPayload;
import com.socks.api.services.AuthenticationApiService;
import com.socks.api.services.UserApiService;
import io.qameta.allure.*;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Locale;

import static com.socks.api.conditions.Conditions.statusCode;

public class UsersTest {

	private final UserApiService userApiService = new UserApiService();
	private final AuthenticationApiService authenticationApiService = new AuthenticationApiService();
	private Faker faker;

	@BeforeClass
	public void setUp() {
		ProjectConfig config = ConfigFactory.create(ProjectConfig.class, System.getProperties());
		faker = new Faker(new Locale(config.locale()));
		RestAssured.baseURI = config.baseUrl();
	}

//	{
//		"@context": "/api/contexts/User",
//			"@id": "/api/users/31",
//			"@type": "User"
//	}

//	@BeforeClass
//	public void setUp() {
//		Map myVars = new HashMap();
//		ProjectConfig config = ConfigFactory.create(ProjectConfig.class,myVars);
//		faker = new Faker(new Locale(config.locale()));
////		RestAssured.baseURI = config.prodEnv();
//		RestAssured.baseURI = config.baseUrl();
//	}

//	@BeforeClass
//	public void setUp() {
//		Map myVars = new HashMap();
//		System.getenv().put("test", "prod");
//		ProjectConfig config = ConfigFactory.create(ProjectConfig.class,myVars);
//		faker = new Faker(new Locale(config.locale()));
//		RestAssured.baseURI = config.baseUrl();
//	}
//
//	@Test
//	public void testsCanRegisterNewUser() {
//		//given
//		UserPayload user = new UserPayload()
//				.username(faker.name().username())
//				.firstName(faker.name().firstName())
//				.lastName(faker.name().lastName())
//				.phone(faker.phoneNumber().cellPhone())
//				.email("test1@gmail.com")
//				.password("test1234");
//		//expect
//		userApiService.registerUser(user)
//				.shouldHave(statusCode(200))
//				.shouldHave(bodyField("id", not(isEmptyOrNullString())));
//	}

	@Test
	@Epic(value = "Smoke testing")
	@Feature(value = "Permission")
	@Story(value = "Check Permission")
	@Severity(value = SeverityLevel.CRITICAL)
	public void invalidDataTest(){
		Assert.assertEquals(200,201);
	}

	@Epic(value = "Smoke testing")
	@Feature(value = "Permission")
	@Story(value = "Check Permission")
	@Severity(value = SeverityLevel.NORMAL)
	@Test
	public void validDataTest(){
		Assert.assertEquals(200,200);
	}

	@Epic(value = "Smoke testing")
	@Feature(value = "Permission")
	@Story(value = "Check Permission")
	@Severity(value = SeverityLevel.BLOCKER)
	@Test
	public void testUserLoginWithInvalidCredential1() {
		//given
		UserLoginPayload user = new UserLoginPayload()
				.email("admin12@admin.com");// - is super admin // !!!!!!!! do not delete [!!!.password("admin");
		//expect
		authenticationApiService.loginUser(user)
				.shouldHave(statusCode(401));
		//                .shouldHave(bodyField("token", not(isEmptyOrNullString())))
//                .shouldHave(bodyField("refresh_token", not(isEmptyOrNullString())));
		//check email
		//
	}

//	@Test
//	public void testRegisterNewUser() {
//		UserPayload user = new UserPayload()
//				.username(faker.name().username())
//				.firstName(faker.name().firstName())
//				.lastName(faker.name().lastName())
//				.email("test1@gmail.com")
//				.password("test1234");
//
//		userApiService.registerUser(user)
//				.shouldHave(statusCode(200));
//	}
//
//	@Test(enabled=false)
//	public void testsCanRegisterNewUserPojo() {
//		//given
//		UserPayload user = new UserPayload()
//				.username(RandomStringUtils.randomAlphabetic(6))
//				.email("test2@gmail.com")
//				.password("test1234");
//		//expect
//		UserRegistrationResponse response = userApiService.registerUser(user)
//				.shouldHave(statusCode(200))
//				.asPojo(UserRegistrationResponse.class);
//
//		response.id();
//	}

//	@Test
//	public void testCanNotRegisterSameUserTwice() {
//		UserPayload user = new UserPayload()
//				.firstName(faker.name().firstName())
//				.lastName(faker.name().lastName())
//				.email("test1@gmail.com")
//				.password("test1234");
//
//		userApiService.registerUser(user)
//				.shouldHave(statusCode(200));
//
//		userApiService.registerUser(user)
//				.shouldHave(statusCode(500));
//
//	}
}
