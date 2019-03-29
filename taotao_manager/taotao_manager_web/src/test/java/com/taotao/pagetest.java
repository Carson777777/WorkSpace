package com.taotao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.List;
public class pagetest {
    @Test
    public void Pagehelper(){
        //1.从spring容器中取出mapper
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        //2.设置查询的页数和行数
        PageHelper.startPage(1,30);
        TbItemMapper itemMapper = (TbItemMapper) applicationContext.getBean("tbItemMapper");
        //3.使用mapper进行查询
        TbItemExample example = new TbItemExample();
        List<TbItem> list = itemMapper.selectByExample(example);
        //4.
        PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(list);
        System.out.println(pageInfo.getPages());
        System.out.println(pageInfo.getTotal());
    }
}
