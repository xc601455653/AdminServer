package xyz.wsyzz.candy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import xyz.wsyzz.candy.entity.model.DictItem;
import xyz.wsyzz.candy.mapper.DictItemMapper;
import xyz.wsyzz.candy.service.DictItemService;

import java.util.List;

/**
 * Created by xucan on 2022/5/15.
 */
@Service
public class DictItemServiceImpl implements DictItemService {

    @Autowired
    private DictItemMapper dictItemMapper;

    @Override
    public List<DictItem> getListByEntity(DictItem dictItemt) {
        Example example = new Example(DictItem.class);
        example.and().andEqualTo("dictId",dictItemt.getDictId()).andEqualTo("itemValue" ,dictItemt.getItemValue());
        List<DictItem> items = dictItemMapper.selectByExample(example);
        return items;
    }
}
