package com.example.auction.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import jakarta.validation.Valid;


@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotEmpty(message = "Tên sản phẩm không được để trống")
    @Size(min = 5, max = 50, message = "Tên sản phẩm phải có độ dài từ 5 đến 50 ký tự")
    private String name;

    @Column(nullable = false)
    @NotNull(message = "Giá khởi điểm không được để trống")
    @Min(value = 100000, message = "Giá khởi điểm phải ít nhất là 100,000 VND")
    private Double startingPrice;

    @Column(nullable = false)
    @NotEmpty(message = "Loại sản phẩm không được để trống")
    private String category;

    @Column(nullable = false)
    @NotEmpty(message = "Tình trạng không được để trống")
    private String status; // chờ duyệt, đang đấu giá, đã bán

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Double getStartingPrice() { return startingPrice; }
    public void setStartingPrice(Double startingPrice) { this.startingPrice = startingPrice; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
