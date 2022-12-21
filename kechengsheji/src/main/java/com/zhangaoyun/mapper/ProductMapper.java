package com.zhangaoyun.mapper;

import com.zhangaoyun.pojo.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper {
    List<Product> selectAll();
    void add(Product product);
    void update(Product product);
    void deleteByIds(@Param("ids") int[] ids);

    //分页查询
    List<Product> selectByPage(@Param("begin") int begin,@Param("size") int size);
    //查询总记录数
    int selectTotalCount();

    //分页+条件查询
    List<Product> selectByPageAndCondition(@Param("begin") int begin,@Param("size") int size,@Param("product") Product product);
    //查询总记录数
    int selectTotalCountByCondition(Product product);

    void upDateById(int id);

    Product selectById(int id);
}
