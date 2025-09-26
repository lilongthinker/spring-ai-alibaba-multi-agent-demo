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

package com.alibaba.cloud.ai.feedback.controller;

import com.alibaba.cloud.ai.feedback.entity.Feedback;
import com.alibaba.cloud.ai.feedback.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {
    
    @Autowired
    private FeedbackService feedbackService;
    
    /**
     * 创建反馈记录
     */
    @PostMapping
    public ResponseEntity<Map<String, Object>> createFeedback(@RequestBody Feedback feedback) {
        Map<String, Object> response = new HashMap<>();
        try {
            Feedback createdFeedback = feedbackService.createFeedback(feedback);
            response.put("success", true);
            response.put("message", "反馈记录创建成功");
            response.put("data", createdFeedback);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "反馈记录创建失败: " + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
    
    /**
     * 根据ID查询反馈记录
     */
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getFeedbackById(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            Optional<Feedback> feedback = feedbackService.getFeedbackById(id);
            if (feedback.isPresent()) {
                response.put("success", true);
                response.put("message", "查询成功");
                response.put("data", feedback.get());
                return ResponseEntity.ok(response);
            } else {
                response.put("success", false);
                response.put("message", "反馈记录不存在");
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "查询失败: " + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
    
    /**
     * 根据用户ID查询反馈记录
     */
    @GetMapping("/user/{userId}")
    public ResponseEntity<Map<String, Object>> getFeedbacksByUserId(@PathVariable Long userId) {
        Map<String, Object> response = new HashMap<>();
        try {
            List<Feedback> feedbacks = feedbackService.getFeedbacksByUserId(userId);
            response.put("success", true);
            response.put("message", "查询成功");
            response.put("data", feedbacks);
            response.put("count", feedbacks.size());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "查询失败: " + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
    
    /**
     * 根据订单ID查询反馈记录
     */
    @GetMapping("/order/{orderId}")
    public ResponseEntity<Map<String, Object>> getFeedbacksByOrderId(@PathVariable String orderId) {
        Map<String, Object> response = new HashMap<>();
        try {
            List<Feedback> feedbacks = feedbackService.getFeedbacksByOrderId(orderId);
            response.put("success", true);
            response.put("message", "查询成功");
            response.put("data", feedbacks);
            response.put("count", feedbacks.size());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "查询失败: " + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
    
    /**
     * 根据反馈类型查询反馈记录
     */
    @GetMapping("/type/{feedbackType}")
    public ResponseEntity<Map<String, Object>> getFeedbacksByType(@PathVariable Integer feedbackType) {
        Map<String, Object> response = new HashMap<>();
        try {
            List<Feedback> feedbacks = feedbackService.getFeedbacksByType(feedbackType);
            response.put("success", true);
            response.put("message", "查询成功");
            response.put("data", feedbacks);
            response.put("count", feedbacks.size());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "查询失败: " + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
    
    /**
     * 更新反馈记录
     */
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateFeedback(@PathVariable Long id, @RequestBody Feedback feedback) {
        Map<String, Object> response = new HashMap<>();
        try {
            feedback.setId(id);
            Feedback updatedFeedback = feedbackService.updateFeedback(feedback);
            response.put("success", true);
            response.put("message", "反馈记录更新成功");
            response.put("data", updatedFeedback);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "反馈记录更新失败: " + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
    
    /**
     * 更新反馈解决方案
     */
    @PutMapping("/{id}/solution")
    public ResponseEntity<Map<String, Object>> updateFeedbackSolution(@PathVariable Long id, @RequestBody Map<String, String> request) {
        Map<String, Object> response = new HashMap<>();
        try {
            String solution = request.get("solution");
            boolean success = feedbackService.updateFeedbackSolution(id, solution);
            if (success) {
                response.put("success", true);
                response.put("message", "反馈解决方案更新成功");
                return ResponseEntity.ok(response);
            } else {
                response.put("success", false);
                response.put("message", "反馈解决方案更新失败");
                return ResponseEntity.badRequest().body(response);
            }
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "反馈解决方案更新失败: " + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
    
    /**
     * 删除反馈记录
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteFeedback(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            boolean success = feedbackService.deleteFeedback(id);
            if (success) {
                response.put("success", true);
                response.put("message", "反馈记录删除成功");
                return ResponseEntity.ok(response);
            } else {
                response.put("success", false);
                response.put("message", "反馈记录删除失败");
                return ResponseEntity.badRequest().body(response);
            }
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "反馈记录删除失败: " + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
    
    /**
     * 查询所有反馈记录
     */
    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllFeedbacks() {
        Map<String, Object> response = new HashMap<>();
        try {
            List<Feedback> feedbacks = feedbackService.getAllFeedbacks();
            response.put("success", true);
            response.put("message", "查询成功");
            response.put("data", feedbacks);
            response.put("count", feedbacks.size());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "查询失败: " + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
    
    /**
     * 统计用户反馈数量
     */
    @GetMapping("/user/{userId}/count")
    public ResponseEntity<Map<String, Object>> countFeedbacksByUserId(@PathVariable Long userId) {
        Map<String, Object> response = new HashMap<>();
        try {
            int count = feedbackService.countFeedbacksByUserId(userId);
            response.put("success", true);
            response.put("message", "统计成功");
            response.put("data", count);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "统计失败: " + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
    
    /**
     * 统计反馈类型数量
     */
    @GetMapping("/type/{feedbackType}/count")
    public ResponseEntity<Map<String, Object>> countFeedbacksByType(@PathVariable Integer feedbackType) {
        Map<String, Object> response = new HashMap<>();
        try {
            int count = feedbackService.countFeedbacksByType(feedbackType);
            response.put("success", true);
            response.put("message", "统计成功");
            response.put("data", count);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "统计失败: " + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
}
