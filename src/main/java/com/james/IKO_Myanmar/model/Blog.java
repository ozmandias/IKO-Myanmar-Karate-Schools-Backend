package com.james.IKO_Myanmar.model;

import com.james.IKO_Myanmar.type.BlogStatus;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity @Table(name="blogs")
public class Blog {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    @Column(nullable = false)
    public String title;
    @Column(nullable = false)
    public String text;
    public String image_location;
    @Column(columnDefinition = "ENUM('Published', 'Draft', 'Removed')", nullable = false) @Enumerated(EnumType.STRING)
    public BlogStatus status;
    public LocalDate publish_date;
    public LocalDateTime create_date;
    public LocalDateTime update_date;

    public Blog(
            int id,
            String title,
            String text,
            String image_location,
            BlogStatus status,
            LocalDate publish_date,
            LocalDateTime create_date,
            LocalDateTime update_date
    ) {
          this.id = id;
          this.title = title;
          this.text = text;
          this.image_location = image_location;
          this.status = status;
          this.publish_date = publish_date;
          this.create_date = create_date;
          this.update_date = update_date;
    }
}