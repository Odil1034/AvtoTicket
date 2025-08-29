package uz.pdp.AvtoTicket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.AvtoTicket.entity.image.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {

}
