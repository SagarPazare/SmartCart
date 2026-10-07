package com.smartcart.orderservice.entity;
import jakarta.persistence.*; import java.math.BigDecimal; import java.time.LocalDateTime;
@Entity @Table(name="orders") public class Order {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false) private Long userId; @Column(nullable=false) private Long productId; @Column(nullable=false) private Integer quantity;
 @Column(nullable=false,precision=12,scale=2) private BigDecimal totalAmount; @Column(nullable=false,length=30) private String status;
 @Column(nullable=false,updatable=false) private LocalDateTime createdAt;
 @PrePersist protected void onCreate(){createdAt=LocalDateTime.now();}
 public Long getId(){return id;} public Long getUserId(){return userId;} public Long getProductId(){return productId;} public Integer getQuantity(){return quantity;} public BigDecimal getTotalAmount(){return totalAmount;} public String getStatus(){return status;} public LocalDateTime getCreatedAt(){return createdAt;}
 public void setUserId(Long v){userId=v;} public void setProductId(Long v){productId=v;} public void setQuantity(Integer v){quantity=v;} public void setTotalAmount(BigDecimal v){totalAmount=v;} public void setStatus(String v){status=v;}
}
