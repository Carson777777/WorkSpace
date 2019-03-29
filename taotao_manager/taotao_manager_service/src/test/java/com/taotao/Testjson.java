package com.taotao;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taotao.mapper.TbItemParamMapper;
import com.taotao.pojo.TbItemParam;
import com.taotao.pojo.TbItemParamExample;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Collection;
import java.util.List;


public class Testjson {
    private ApplicationContext applicationContext;
    @Before
    public void Setup(){
         applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    }

    @Test
    public void testJson() throws Exception {
        TbItemParamMapper tbItemParamMapper = (TbItemParamMapper) applicationContext.getBean("tbItemParamMapper");
        TbItemParamExample tbItemParamExample = new TbItemParamExample();
        List<TbItemParam> tbItemParams = tbItemParamMapper.selectByExampleWithBLOBs(tbItemParamExample);
        for (TbItemParam param : tbItemParams) {
            System.out.println(param.getId());
            System.out.println(param.getItemCatId());
            System.out.println(param.getCreated());
            System.out.println(param.getUpdated());
            System.out.println(param.getParamData());
            System.out.println("+++++++++++++");
        }
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode node = objectMapper.readTree(tbItemParams.get(0).getParamData());
        for (int i = 0; i < node.size(); i++) {
            JsonNode childNode = node.get(i);
            System.out.println("readValueFromJson>>>" + childNode.get("group").toString());// 获取name
            System.out.println(node);
        }
    }
}
