package uz.pdp.AutoTicket.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "documents")
public class Document extends BaseEntity {

    @Column(name = "original_name", nullable = false, updatable = false)
    private String originalName; // profileImage

    @Column(name = "mime_type")
    private String mimeType;    // image/jpg

    private String url;

    private String extension;  // .jpg

    @Column(nullable = false)
    private Double size;

    @Column(name = "generated_name", unique = true, updatable = false, nullable = false)
    private String generatedName;  // fdasferefdasfe321ir34214g

    @PrePersist
    public void assignGeneratedName() {
        if (this.generatedName == null) {
            this.generatedName = UUID.randomUUID().toString();
        }
    }
}
