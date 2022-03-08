package xyz.wsyzz.candy.entity.TO;

import lombok.Data;

import java.util.List;

/**
 * Created by xucan on 2022/3/8.
 */
@Data
public class BatchAddTO<T> {

    List<T> datalist;
}
