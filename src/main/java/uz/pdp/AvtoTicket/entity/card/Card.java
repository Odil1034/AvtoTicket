package uz.pdp.AvtoTicket.entity.card;

import jakarta.persistence.*;
import lombok.*;
import uz.pdp.AvtoTicket.entity.BaseEntity;
import uz.pdp.AvtoTicket.entity.user.User;

import java.lang.annotation.Target;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "cards")
public class Card extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @Column(name = "card_number", unique = true, updatable = false)
    private String cardNumber;

    @Column(name = "expired_date")
    private String expiredDate;

    @Column(name = "holder_name")
    private String holderName;

}
