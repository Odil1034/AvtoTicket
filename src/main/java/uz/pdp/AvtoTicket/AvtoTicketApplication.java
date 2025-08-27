package uz.pdp.AvtoTicket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AvtoTicketApplication {

	public static void main(String[] args) {
		SpringApplication.run(AvtoTicketApplication.class, args);
	}

}
