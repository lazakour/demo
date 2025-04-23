package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
@RestController
@RequestMapping("/mypath")
public class DemoApplication {

	Logger logger = Logger.getLogger(DemoApplication.class.getName());

	@Autowired MyRepository myRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	//	@GetMapping("/mypath")
	@GetMapping
	public String myGetMethod1(@RequestParam(value = "parameter1", defaultValue = "") String businessKey,
							   @RequestParam(value = "parameter2", defaultValue = "") String property1,
							   @RequestParam(value = "parameter3", defaultValue = "") String property2,
							   @RequestParam(value = "parameter4", defaultValue = "") String property3 ) {
		System.out.println("myGetMethod1...entry");
//		Optional<MyEntity> all = myRepository.findByBusinessKeyAndField1AndField2AndField3(businessKey, property1, property2, property3);
		Optional<MyEntity> all = myRepository.findByBusinessKeyQuery(businessKey);
		MyEntity myEntity = all.orElseThrow();
		Long id = myEntity.Id;
		System.out.println("myGetMethod1...exit");
		return String.format("Primary key is = %d", id);
	}



	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void myPostMethod1(@RequestBody MyMessage myMessage) {
		System.out.println("myPostMethod1...entry");
		MyEntity myEntity = new MyEntity(myMessage.businessKey(), myMessage.property1(), myMessage.property2(), myMessage.property3());
		myEntity = myRepository.save(myEntity);

		logger.log(Level.INFO, "");

		System.out.println("myPostMethod1...exit");
	}

//	@GetMapping("/{variable1}")
//	public String myGetMethod2(@PathVariable(value = "variable1") String businessKey) { // TODO: parent child relationship
//		System.out.println("myGetMethod2...entry");
//		MyEntity myEntity = myRepository.findByBusinessKey(businessKey);
//		//MyEntity myEntity = myRepository.findByField1("Greece");
//		Long id = myEntity.Id;
//		System.out.println("myGetMethod2...exit");
//		return String.format("Primary key is %d", id);
//	}

//	@Bean
//	CommandLineRunner commandLineRunner(JdbcTemplate jdbcTemplate) {
//		//myRepository.deleteAll();
//		jdbcTemplate.update("CREATE TABLE MY_PET_OWNER\n" +
//				"(\n" +
//				"    ID BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,\n" +
//				"    NAME VARCHAR(255)\n" +
//				");\n" );
//		return args -> { // lamda function
//			System.out.println("Initialized tables..." );
//		};
//	}
}
