package com.zhangaoyun.service;

import com.zhangaoyun.mapper.ProductMapper;
import com.zhangaoyun.mapper.UserMapper;
import com.zhangaoyun.pojo.PageBean;
import com.zhangaoyun.pojo.Product;
import com.zhangaoyun.pojo.User;
import com.zhangaoyun.util.SqlSessionFactoryUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class ProductService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public List<Product> selectAll(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
        List<Product> products = mapper.selectAll();
        sqlSession.close();
        return products;
    }

    public void add(Product product){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
        mapper.add(product);
        sqlSession.commit();
        sqlSession.close();
    }
    public void update(Product product){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
        mapper.update(product);
        sqlSession.commit();
        sqlSession.close();
    }

    public void deleteByIds(int[] ids){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
        mapper.deleteByIds(ids);
        sqlSession.commit();
        sqlSession.close();
    }
    /*分页查询
    * currentPage：当前页码
    * pageSize：每页展示条数
    * */
    public PageBean<Product> selectByPage(int currentPage,int pageSize){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);

        //计算
        int begin = ( currentPage - 1) * pageSize;
        int size = pageSize;

        List<Product> rows = mapper.selectByPage(begin, size);
        int totalCount = mapper.selectTotalCount();

        PageBean<Product> productPageBean = new PageBean<>();
        productPageBean.setRows(rows);
        productPageBean.setTotalCount(totalCount);

        sqlSession.close();

        return productPageBean;

    }
    public PageBean<Product> selectByPageAndCondition(int currentPage,int pageSize, Product product){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
        //计算
        int begin = ( currentPage - 1) * pageSize;
        int size = pageSize;
        String name = product.getName();
        if ( name != null && name.length() > 0) {
           product.setName("%"+name+"%");
        }
        String type = product.getType();
        if ( type != null && type.length() > 0) {
            product.setName("%"+type+"%");
        }
        List<Product> rows = mapper.selectByPageAndCondition(begin,size,product);
        int totalCount = mapper.selectTotalCountByCondition(product);

        PageBean<Product> productPageBean = new PageBean<>();
        productPageBean.setRows(rows);
        productPageBean.setTotalCount(totalCount);

        sqlSession.close();

        return productPageBean;

    }
    public void upDateById(int id){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
        mapper.upDateById(id);
    }

    public Product selectById(int id){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
        Product product = mapper.selectById(id);
        return product;
    }

}
