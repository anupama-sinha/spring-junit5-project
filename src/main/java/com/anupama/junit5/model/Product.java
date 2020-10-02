package com.anupama.junit5.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@ToString
@NoArgsConstructor
@JsonFormat
@Getter
@Setter
@Entity
@Table(name="product")
public class Product implements Serializable {

   private static final long serialVersionUID = 1L;

   public Product(Long id, String name) {
      this.id = id;
      this.name = name;
   }

   @Id
   @Column(name="product_id")
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   @SequenceGenerator(name="PRODUCT_SEQ", initialValue = 1, allocationSize = 25)
   private Long id;
 
   @Column(name = "product_name")
   String name;

}