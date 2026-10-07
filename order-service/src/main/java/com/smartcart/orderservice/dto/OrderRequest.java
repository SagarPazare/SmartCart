package com.smartcart.orderservice.dto;
import jakarta.validation.constraints.*; import java.math.BigDecimal;
public class OrderRequest { @NotNull private Long userId; @NotNull private Long productId; @NotNull @Min(1) private Integer quantity; @NotNull @DecimalMin("0.01") private BigDecimal totalAmount;
 public Long getUserId(){return userId;} public Long getProductId(){return productId;} public Integer getQuantity(){return quantity;} public BigDecimal getTotalAmount(){return totalAmount;}
 public void setUserId(Long v){userId=v;} public void setProductId(Long v){productId=v;} public void setQuantity(Integer v){quantity=v;} public void setTotalAmount(BigDecimal v){totalAmount=v;}}
