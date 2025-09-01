package uz.pdp.AutoTicket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AutoTicketApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutoTicketApplication.class, args);
	}

}
