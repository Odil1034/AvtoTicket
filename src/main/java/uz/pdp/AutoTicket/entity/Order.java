package uz.pdp.AutoTicket.entity;

import jakarta.persistence.*;
import lombok.*;
import uz.pdp.AutoTicket.enums.PaymentStatus;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "orders")
public class Order extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @Builder.Default
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "total_price")
    private Double totalPrice;

    @Builder.Default
    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private PaymentStatus status = PaymentStatus.FAILED;

    @OneToMany(mappedBy = "order")
    private List<Ticket> tickets;

}
