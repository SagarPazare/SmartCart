package com.smartcart.orderservice.controller;
import com.smartcart.orderservice.dto.OrderRequest; import com.smartcart.orderservice.entity.Order; import com.smartcart.orderservice.repository.OrderRepository; import jakarta.validation.Valid; import org.springframework.http.*; import org.springframework.kafka.core.KafkaTemplate; import org.springframework.web.bind.annotation.*; import java.util.List;
@RestController @RequestMapping("/api/orders") public class OrderController {
 private final OrderRepository repo; private final KafkaTemplate<String,String> kafka;
 public OrderController(OrderRepository repo,KafkaTemplate<String,String> kafka){this.repo=repo;this.kafka=kafka;}
 @PostMapping public ResponseEntity<Order> create(@Valid @RequestBody OrderRequest r){Order o=new Order();o.setUserId(r.getUserId());o.setProductId(r.getProductId());o.setQuantity(r.getQuantity());o.setTotalAmount(r.getTotalAmount());o.setStatus("PLACED");Order saved=repo.save(o);String event="{\"orderId\":"+saved.getId()+",\"userId\":"+saved.getUserId()+",\"totalAmount\":"+saved.getTotalAmount()+"}";kafka.send("order-created",String.valueOf(saved.getId()),event);return ResponseEntity.status(HttpStatus.CREATED).body(saved);}
 @GetMapping public List<Order> all(){return repo.findAll();}
 @GetMapping("/{id}") public ResponseEntity<Order> one(@PathVariable Long id){return repo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());}
}
