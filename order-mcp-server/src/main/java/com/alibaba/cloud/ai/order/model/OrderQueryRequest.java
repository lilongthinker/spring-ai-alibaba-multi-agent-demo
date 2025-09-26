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

package com.alibaba.cloud.ai.order.model;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * 订单查询请求DTO
 */
public class OrderQueryRequest {
    
    @NotNull(message = "用户ID不能为空")
    private Long userId;
    
    private String orderId;
    private String productName;
    private Integer sweetness;
    private Integer iceLevel;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Integer page = 0;
    private Integer size = 20;
    
    // 构造函数
    public OrderQueryRequest() {}
    
    public OrderQueryRequest(Long userId) {
        this.userId = userId;
    }
    
    // Getter和Setter方法
    public Long getUserId() {
        return userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    public String getOrderId() {
        return orderId;
    }
    
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    
    public String getProductName() {
        return productName;
    }
    
    public void setProductName(String productName) {
        this.productName = productName;
    }
    
    public Integer getSweetness() {
        return sweetness;
    }
    
    public void setSweetness(Integer sweetness) {
        this.sweetness = sweetness;
    }
    
    public Integer getIceLevel() {
        return iceLevel;
    }
    
    public void setIceLevel(Integer iceLevel) {
        this.iceLevel = iceLevel;
    }
    
    public LocalDateTime getStartTime() {
        return startTime;
    }
    
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }
    
    public LocalDateTime getEndTime() {
        return endTime;
    }
    
    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
    
    public Integer getPage() {
        return page;
    }
    
    public void setPage(Integer page) {
        this.page = page;
    }
    
    public Integer getSize() {
        return size;
    }
    
    public void setSize(Integer size) {
        this.size = size;
    }
    
    @Override
    public String toString() {
        return "OrderQueryRequest{" +
                "userId=" + userId +
                ", orderId='" + orderId + '\'' +
                ", productName='" + productName + '\'' +
                ", sweetness=" + sweetness +
                ", iceLevel=" + iceLevel +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", page=" + page +
                ", size=" + size +
                '}';
    }
}
