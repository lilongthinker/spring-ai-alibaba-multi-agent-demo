/*
 * Copyright 2025 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.alibaba.cloud.ai.order.entity;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 产品实体类
 */
public class Product {
    
    private Long id;
    
    @NotBlank(message = "产品名称不能为空")
    private String name;
    
    private String description;
    
    @NotNull(message = "价格不能为空")
    @DecimalMin(value = "0.01", message = "价格必须大于0")
    private BigDecimal price;
    
    @Min(value = 0, message = "库存不能为负数")
    private Integer stock;
    
    @Min(value = 1, message = "保质期必须大于0")
    private Integer shelfTime;
    
    @Min(value = 1, message = "制作时间必须大于0")
    private Integer preparationTime;
    
    private Boolean isSeasonal;
    
    private LocalDate seasonStart;
    
    private LocalDate seasonEnd;
    
    private Boolean isRegional;
    
    private String availableRegions;
    
    private Boolean status;
    
    private LocalDateTime createdAt;
    
    private LocalDateTime updatedAt;
    
    // 构造函数
    public Product() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.stock = 0;
        this.shelfTime = 30;
        this.preparationTime = 5;
        this.isSeasonal = false;
        this.isRegional = false;
        this.status = true;
    }
    
    public Product(String name, String description, BigDecimal price, Integer stock) {
        this();
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }
    
    // 生命周期回调方法
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
    
    public void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
    
    // Getter和Setter方法
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public BigDecimal getPrice() {
        return price;
    }
    
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
    public Integer getStock() {
        return stock;
    }
    
    public void setStock(Integer stock) {
        this.stock = stock;
    }
    
    public Integer getShelfTime() {
        return shelfTime;
    }
    
    public void setShelfTime(Integer shelfTime) {
        this.shelfTime = shelfTime;
    }
    
    public Integer getPreparationTime() {
        return preparationTime;
    }
    
    public void setPreparationTime(Integer preparationTime) {
        this.preparationTime = preparationTime;
    }
    
    public Boolean getIsSeasonal() {
        return isSeasonal;
    }
    
    public void setIsSeasonal(Boolean isSeasonal) {
        this.isSeasonal = isSeasonal;
    }
    
    public LocalDate getSeasonStart() {
        return seasonStart;
    }
    
    public void setSeasonStart(LocalDate seasonStart) {
        this.seasonStart = seasonStart;
    }
    
    public LocalDate getSeasonEnd() {
        return seasonEnd;
    }
    
    public void setSeasonEnd(LocalDate seasonEnd) {
        this.seasonEnd = seasonEnd;
    }
    
    public Boolean getIsRegional() {
        return isRegional;
    }
    
    public void setIsRegional(Boolean isRegional) {
        this.isRegional = isRegional;
    }
    
    public String getAvailableRegions() {
        return availableRegions;
    }
    
    public void setAvailableRegions(String availableRegions) {
        this.availableRegions = availableRegions;
    }
    
    public Boolean getStatus() {
        return status;
    }
    
    public void setStatus(Boolean status) {
        this.status = status;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", shelfTime=" + shelfTime +
                ", preparationTime=" + preparationTime +
                ", isSeasonal=" + isSeasonal +
                ", seasonStart=" + seasonStart +
                ", seasonEnd=" + seasonEnd +
                ", isRegional=" + isRegional +
                ", availableRegions='" + availableRegions + '\'' +
                ", status=" + status +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}

