package com.james.IKO_Myanmar.models;

import com.james.IKO_Myanmar.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity @Table(name="blogs")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class Blog {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(nullable = false)
    String title;

    @Column(nullable = false)
    String text;

    @Column(name = "image_location")
    String imageLocation;

    @Column(columnDefinition = "ENUM('Published', 'Draft', 'Removed')", nullable = false) @Enumerated(EnumType.STRING)
    Status status;

    @Column(name = "publish_date")
    LocalDate publishDate;

    @Column(name = "create_date")
    LocalDateTime createDate;

    @Column(name = "update_date")
    LocalDateTime updateDate;

    /*public Blog(
            Long id,
            String title,
            String text,
            String imageLocation,
            Status status,
            LocalDate publishDate,
            LocalDateTime createDate,
            LocalDateTime updateDate
    ) {
          this.id = id;
          this.title = title;
          this.text = text;
          this.imageLocation = imageLocation;
          this.status = status;
          this.publishDate = publishDate;
          this.createDate = createDate;
          this.updateDate = updateDate;
    }*/
}