package uz.pdp.AvtoTicket.entity.order;

import jakarta.persistence.*;
import lombok.*;
import uz.pdp.AvtoTicket.entity.BaseEntity;
import uz.pdp.AvtoTicket.entity.ticket.Ticket;
import uz.pdp.AvtoTicket.entity.user.User;
import uz.pdp.AvtoTicket.enums.PaymentStatus;

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

    @Column(name = "created_at", updatable = false)
    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "total_price")
    private Double totalPrice;

    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    @OneToMany(mappedBy = "order")
    private List<Ticket> tickets;

}
