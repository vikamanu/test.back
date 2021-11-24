package ru.manuvika;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import ru.manuvika.db.dao.CategoriesMapper;
import ru.manuvika.db.dao.ProductsMapper;
import ru.manuvika.db.model.Categories;
import ru.manuvika.db.model.Products;
import ru.manuvika.db.model.ProductsExample;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
                .build(Main.class.getResourceAsStream("myBatis/mybatis-config.xml"));
        SqlSession session = sqlSessionFactory.openSession();
        CategoriesMapper categoryMapper = session.getMapper(CategoriesMapper.class);
        ProductsMapper productsMapper = session.getMapper(ProductsMapper.class);
        Categories categories = categoryMapper.selectByPrimaryKey(1L);
        System.out.println(categories);
        ProductsExample example = new ProductsExample();
        example.createCriteria().andCategoryIdEqualTo(1L);
        List<Products> products = productsMapper.selectByExample(example);
        System.out.println(products);

    }
}