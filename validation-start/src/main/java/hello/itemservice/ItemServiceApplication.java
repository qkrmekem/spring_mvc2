package hello.itemservice;

import hello.itemservice.web.validation.ItemValidator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ItemServiceApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(ItemServiceApplication.class, args);
	}

	// 글로벌 validator 적용하기
	// 단 각 메서드에 @Validated가 걸려있어야함
	@Override
	public Validator getValidator() {
		return new ItemValidator();
	}
}
