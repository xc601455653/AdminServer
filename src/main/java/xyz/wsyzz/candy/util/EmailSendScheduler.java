package xyz.wsyzz.candy.util;

import cn.hutool.json.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import xyz.wsyzz.candy.config.WebSocketServer;
import xyz.wsyzz.candy.controller.SalaryDetailsController;
import xyz.wsyzz.candy.entity.TO.SendMailParamTO;


/**
 * Created by xucan on 2022/3/26.
 */
@Component
public class EmailSendScheduler {

    private static Logger logger = LoggerFactory.getLogger(EmailSendScheduler.class);

    @Scheduled(fixedDelay = 1000)
    public void mailTask() {
        SendMailParamTO mailParamTO = null;
        try {
            mailParamTO = SalaryDetailsController.abq.take();
            logger.info("邮件发送开始==={}",mailParamTO.getEmployeeName());
            SendEmailUtils.sendMailByParam(mailParamTO);
            logger.info("邮件发送结束==={}",mailParamTO.getEmployeeName());
            WebSocketServer.broadCastInfo(String.format("%s邮件发送成功", mailParamTO.getEmployeeName()));
        } catch (InterruptedException e) {
            logger.error("从队列获取数据失败");
            e.printStackTrace();
        } catch (Exception e) {
            logger.error("薪资邮件发送失败,数据{}",JSONUtil.toJsonStr(mailParamTO));
            logger.error("发送邮件失败",e);
            e.printStackTrace();
        }
    }
}

