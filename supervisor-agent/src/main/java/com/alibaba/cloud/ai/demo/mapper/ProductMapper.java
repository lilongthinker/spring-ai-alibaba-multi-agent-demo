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

import com.alibaba.cloud.ai.demo.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * 产品数据访问层 - MyBatis Mapper
 */
@Mapper
public interface ProductMapper {

    /**
     * 根据ID查找产品
     */
    @Select("SELECT * FROM products WHERE id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "description", column = "description"),
            @Result(property = "price", column = "price"),
            @Result(property = "stock", column = "stock"),
            @Result(property = "shelfTime", column = "shelf_time"),
            @Result(property = "preparationTime", column = "preparation_time"),
            @Result(property = "isSeasonal", column = "is_seasonal"),
            @Result(property = "seasonStart", column = "season_start"),
            @Result(property = "seasonEnd", column = "season_end"),
            @Result(property = "isRegional", column = "is_regional"),
            @Result(property = "availableRegions", column = "available_regions"),
            @Result(property = "status", column = "status"),
            @Result(property = "createdAt", column = "created_at"),
            @Result(property = "updatedAt", column = "updated_at")
    })
    Product selectById(Long id);
}
