package xyz.wsyzz.candy.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.wsyzz.candy.common.ResultData;
import xyz.wsyzz.candy.entity.TO.SendMailParamTO;
import xyz.wsyzz.candy.util.ResultDataUtils;
import xyz.wsyzz.candy.util.SendEmailUtils;

/**
 * Created by xucan on 2022/2/26.
 */
@RestController
@RequestMapping("commontool")
@Api(description = "通用工具服务", tags = {"CommonToolController"})
public class CommonToolController {

    @ApiOperation("发送邮件服务")
    @PostMapping("sendmail")
    public ResultData sendMail(@RequestBody SendMailParamTO sendMailParamTO) throws Exception{
        if (CollectionUtils.isEmpty(sendMailParamTO.getToMailAddressList())) {
            return ResultDataUtils.exception("收件人邮箱地址不能为空");
        }
        if (StringUtils.isEmpty(sendMailParamTO.getContent())) {
            return ResultDataUtils.exception("内容不能为空");
        }
        SendEmailUtils.sendMailByParam(sendMailParamTO);
        return ResultDataUtils.success();
    }

}
