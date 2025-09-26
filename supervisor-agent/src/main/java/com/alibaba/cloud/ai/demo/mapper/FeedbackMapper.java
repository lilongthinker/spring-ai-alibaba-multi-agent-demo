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

package com.alibaba.cloud.ai.demo.mapper;

import java.util.Date;
import java.util.List;

import com.alibaba.cloud.ai.demo.entity.Feedback;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * FeedbackMapper
 * @author yaohui
 * @create 2025/9/4 17:06
 **/
@Mapper
public interface FeedbackMapper {
	
	/**
	 * 根据时间范围查询反馈数据
	 */
	@Select("SELECT * FROM feedback WHERE created_at BETWEEN #{startTime} AND #{endTime}")
	@Results({
			@Result(property = "id", column = "id"),
			@Result(property = "orderId", column = "order_id"),
			@Result(property = "userId", column = "user_id"),
			@Result(property = "feedbackType", column = "feedback_type"),
			@Result(property = "rating", column = "rating"),
			@Result(property = "content", column = "content"),
			@Result(property = "solution", column = "solution"),
			@Result(property = "createdAt", column = "created_at"),
			@Result(property = "updatedAt", column = "updated_at")
	})
	List<Feedback> selectByTimeRange(@Param("startTime") Date startTime, @Param("endTime") Date endTime);
	
	/**
	 * 获取反馈表中created_at的最大月份
	 */
	@Select("SELECT DATE_FORMAT(MAX(created_at), '%Y-%m') FROM feedback")
	String selectMaxCreatedMonth();
	
}