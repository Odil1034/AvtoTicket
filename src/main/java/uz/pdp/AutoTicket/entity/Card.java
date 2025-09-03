package uz.pdp.AutoTicket.entity;

import jakarta.persistence.*;
import lombok.*;
import uz.pdp.AutoTicket.enums.CardStatus;

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

    @Column(nullable = false)
    private String name;

    @Column(name = "holder_name")
    private String holderName;

    @Column(name = "card_number", unique = true, updatable = false)
    private String cardNumber;

    @Column(name = "expired_date")
    private String expiredDate;

    private CardStatus status;

}
