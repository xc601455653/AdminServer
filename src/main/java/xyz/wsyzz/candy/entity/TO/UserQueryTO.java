package xyz.wsyzz.candy.entity.TO;

import lombok.Data;
import xyz.wsyzz.candy.entity.BaseParam;

/**
 * Created by xucan on 2022/2/20.
 */
@Data
public class UserQueryTO extends BaseParam {

    private String userName;

    private Integer id;
}
