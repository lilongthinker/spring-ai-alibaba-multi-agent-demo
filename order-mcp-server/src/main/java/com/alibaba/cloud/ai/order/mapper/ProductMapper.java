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

package com.alibaba.cloud.ai.order.mapper;

import com.alibaba.cloud.ai.order.entity.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 产品数据访问层 - MyBatis Mapper
 */
@Mapper
public interface ProductMapper {
    
    /**
     * 插入产品
     */
    @Insert("INSERT INTO products (name, description, price, stock, shelf_time, preparation_time, is_seasonal, season_start, season_end, is_regional, available_regions, status, created_at, updated_at) " +
            "VALUES (#{name}, #{description}, #{price}, #{stock}, #{shelfTime}, #{preparationTime}, #{isSeasonal}, #{seasonStart}, #{seasonEnd}, #{isRegional}, #{availableRegions}, #{status}, #{createdAt}, #{updatedAt})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Product product);
    
    /**
     * 根据ID更新产品
     */
    @Update("UPDATE products SET stock = #{stock}, updated_at = #{updatedAt} WHERE id = #{id}")
    int updateById(Product product);
    
    /**
     * 根据ID删除产品
     */
    @Delete("DELETE FROM products WHERE id = #{id}")
    int deleteById(Long id);
    
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
    
    /**
     * 根据产品名称查找产品
     */
    @Select("SELECT * FROM products WHERE name = #{name}")
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
    Product selectByName(String name);
    
    /**
     * 根据产品名称和状态查找产品
     */
    @Select("SELECT * FROM products WHERE name = #{name} AND status = #{status}")
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
    Product selectByNameAndStatus(@Param("name") String name, @Param("status") Integer status);
    
    /**
     * 查找所有上架的产品
     */
    @Select("SELECT * FROM products WHERE status = 1 ORDER BY name")
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
    List<Product> selectByStatusTrueOrderByName();
    
    /**
     * 查找所有上架且库存大于0的产品
     */
    @Select("SELECT * FROM products WHERE status = 1 AND stock > #{stock} ORDER BY name")
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
    List<Product> selectByStatusTrueAndStockGreaterThanOrderByName(Integer stock);
    
    /**
     * 检查产品是否存在且上架
     */
    @Select("SELECT COUNT(*) > 0 FROM products WHERE name = #{name} AND status = 1")
    boolean existsByNameAndStatusTrue(String name);
    
    /**
     * 检查产品库存是否充足
     */
    @Select("SELECT CASE WHEN stock >= #{quantity} THEN true ELSE false END FROM products WHERE name = #{name} AND status = 1")
    boolean checkStockAvailability(@Param("name") String name, @Param("quantity") Integer quantity);
    
    /**
     * 查找季节性产品
     */
    @Select("SELECT * FROM products WHERE is_seasonal = 1 AND status = 1 ORDER BY name")
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
    List<Product> selectByIsSeasonalTrueAndStatusTrueOrderByName();
    
    /**
     * 查找地区限定产品
     */
    @Select("SELECT * FROM products WHERE is_regional = true AND status = true ORDER BY name")
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
    List<Product> selectByIsRegionalTrueAndStatusTrueOrderByName();
    
    /**
     * 根据产品名称模糊查询
     */
    @Select("SELECT * FROM products WHERE name LIKE CONCAT('%', #{name}, '%') AND status = 1 ORDER BY name")
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
    List<Product> selectByNameContainingIgnoreCaseAndStatusTrueOrderByName(String name);
}
