package xyz.wsyzz.candy.service;

import org.springframework.stereotype.Service;
import xyz.wsyzz.candy.entity.model.DictItem;

import java.util.List;

/**
 * Created by xucan on 2022/5/15.
 */
@Service
public interface DictItemService {

    List<DictItem> getListByEntity(DictItem dictItemt);
}
