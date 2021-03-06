package com.taotao.controller;

import com.taotao.common.vo.EasyUITreeNode;
import com.taotao.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 商品分类管理Controller
 */
@Controller
@RequestMapping("/item/cat")
public class ItemCatController {
    @Autowired
    private ItemCatService itemCatService;

    /**
     * 展示商品类目 传入的是父层id
     * @param parentId
     * @return
     */
    @RequestMapping("/list")

    @ResponseBody
    public List<EasyUITreeNode> getItemCatList(@RequestParam(value = "id",defaultValue = "0") Long parentId){
        List<EasyUITreeNode>result = itemCatService.getItemCatList(parentId);
        for(EasyUITreeNode node:result){
            System.out.println(node.getId()+" "+ node.getState()+" " +node.getText());
        }
        System.out.println("++++++++++++++++++++++++++++++");
        return result;

    }
}
