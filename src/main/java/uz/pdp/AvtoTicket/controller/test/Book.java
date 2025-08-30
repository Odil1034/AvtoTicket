package uz.pdp.AvtoTicket.controller.test;

import jakarta.persistence.Entity;
import lombok.*;
import uz.pdp.AvtoTicket.entity.BaseEntity;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Book extends BaseEntity {
    private String author;
    private String title;
    private int countOfPage;
}
