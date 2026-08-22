package com.james.IKO_Myanmar.models;

import com.james.IKO_Myanmar.enums.BlogStatus;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity @Table(name="blogs")
public class Blog {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    @Column(nullable = false)
    public String title;
    @Column(nullable = false)
    public String text;
    @Column(name = "image_location")
    public String imageLocation;
    @Column(columnDefinition = "ENUM('Published', 'Draft', 'Removed')", nullable = false) @Enumerated(EnumType.STRING)
    public BlogStatus status;
    @Column(name = "publish_date")
    public LocalDate publishDate;
    @Column(name = "create_date")
    public LocalDateTime createDate;
    @Column(name = "update_date")
    public LocalDateTime updateDate;

    public Blog(
            Long id,
            String title,
            String text,
            String imageLocation,
            BlogStatus status,
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
    }
}