package com.week.ssm.mapper;

import com.week.ssm.po.Items;
import com.week.ssm.po.ItemsCustom;
import com.week.ssm.po.ItemsExample;
import com.week.ssm.po.ItemsQueryVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ItemsMapperCustom {
    //商品查询列表
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)throws Exception;
}