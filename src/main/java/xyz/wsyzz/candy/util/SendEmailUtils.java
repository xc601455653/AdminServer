package xyz.wsyzz.candy.util;

/**
 * Created by ${XC} on 2019/5/17.
 */
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import xyz.wsyzz.candy.entity.TO.SendMailParamTO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
import javax.mail.util.ByteArrayDataSource;

/**
 * 使用SMTP协议发送电子邮件
 */
public class SendEmailUtils {


    // 邮件发送协议
    private final static String PROTOCOL = "smtp";

    // SMTP邮件服务器
    private final static String HOST = "smtp.163.com";

    // SMTP邮件服务器默认端口
    private final static String PORT = "465";

    // 是否要求身份认证
    private final static String IS_AUTH = "true";

    // 是否启用调试模式（启用调试模式可打印客户端与服务器交互过程时一问一答的响应消息）
    private final static String IS_ENABLED_DEBUG_MOD = "true";

    // 发件人
    private static String from = "15071482539@163.com";

    // 收件人
    private static String to = "601455653@qq.com";

    private final static String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

    // 初始化连接邮件服务器的会话信息
    private static Properties props = null;

    private final static String CHARSET = "utf-8";
    static {
        props = new Properties();
        props.setProperty("mail.transport.protocol", PROTOCOL);
        props.setProperty("mail.smtp.host", HOST);
        props.setProperty("mail.smtp.port", PORT);
        props.setProperty("mail.smtp.auth", IS_AUTH);
        props.setProperty("mail.debug",IS_ENABLED_DEBUG_MOD);
        props.setProperty("mail.smtp.socketFactory.class",SSL_FACTORY);
        props.setProperty("mail.smtp.socketFactory.port",PORT);
    }


    /**
     * 发送简单的文本邮件
     */
    public static boolean sendTextEmail(String toEmail,String content) {
        return sendTextEmail(toEmail,content, "15071482539@163.com", "WMRMQTBDUMHBSBWG");
    }

    public static boolean sendTextEmail(String toEmail,String content, String fromMail, String fromMailPassword) {
        try {
            // 创建Session实例对象
            Session session = Session.getDefaultInstance(props);

            // 创建MimeMessage实例对象
            MimeMessage message = new MimeMessage(session);
            // 设置发件人
            message.setFrom(new InternetAddress(from));
            // 设置邮件主题
            message.setSubject("私人的163邮箱发出来的测试信息");
            // 设置收件人
            message.setRecipient(RecipientType.TO, new InternetAddress(toEmail));
            // 设置发送时间
            message.setSentDate(new Date());
            // 设置纯文本内容为邮件正文
            // message.setText("您的验证码是："+code+"!验证码有效期是10分钟，过期后请重新获取!");
            if (!StringUtils.isEmpty(content)) {
                message.setText(content);
            }
            // 保存并生成最终的邮件内容
            message.saveChanges();

            // 获得Transport实例对象
            Transport transport = session.getTransport();
            // 打开连接
            transport.connect(fromMail, fromMailPassword);
            // 将message对象传递给transport对象，将邮件发送出去
            transport.sendMessage(message, message.getAllRecipients());
            // 关闭连接
            transport.close();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
            // return false;
        }
    }

    public static void main(String[] args) throws Exception {
        // sendHtmlEmail("601455653@qq.com", 88888);
        //sendTextEmail("601455653@qq.com", "888888");
        //sendHtmlWithInnerImageEmail();
        sendMultipleEmail();
    }

    /**
     * 发送简单的html邮件
     */
    public static boolean sendHtmlEmail(String to,int code) throws Exception {
        // 创建Session实例对象
        Session session1 = Session.getInstance(props, new MyAuthenticator());

        // 创建MimeMessage实例对象
        MimeMessage message = new MimeMessage(session1);
        // 设置邮件主题
        message.setSubject("糖果注册");
        // 设置发送人
        message.setFrom(new InternetAddress(from));
        // 设置发送时间
        message.setSentDate(new Date());
        // 设置收件人
        message.setRecipients(RecipientType.TO, InternetAddress.parse(to));
        // 设置html内容为邮件正文，指定MIME类型为text/html类型，并指定字符编码为gbk
        message.setContent("<div><div><div><div><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"1728\" style=\"border-collapse: collapse; width: 1296pt; border-spacing: 0px;\" id=\"ntes_editor_table_10014\">\n" +
                "<!--StartFragment-->\n" +
                " <colgroup><col width=\"72\" span=\"24\" style=\"width: 54pt;\" />\n" +
                " </colgroup><tbody><tr height=\"44\" style=\"height: 33pt;\">\n" +
                "  <td height=\"44\" class=\"xl68\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; text-align: center; border: 0.5pt solid windowtext; height: 33pt; width: 54pt;\">序号</td>\n" +
                "  <td class=\"xl68\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; text-align: center; border-top: 0.5pt solid windowtext; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-left: none; width: 54pt;\">工号</td>\n" +
                "  <td class=\"xl68\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; text-align: center; border-top: 0.5pt solid windowtext; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-left: none; width: 54pt;\">　</td>\n" +
                "  <td class=\"xl68\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; text-align: center; border-top: 0.5pt solid windowtext; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-left: none; width: 54pt;\">服务公司</td>\n" +
                "  <td class=\"xl68\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; text-align: center; border-top: 0.5pt solid windowtext; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-left: none; width: 54pt;\">　</td>\n" +
                "  <td class=\"xl69\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; border-top: 0.5pt solid windowtext; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-left: none; width: 54pt;\">姓名</td>\n" +
                "  <td class=\"xl69\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; border-top: 0.5pt solid windowtext; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-left: none; width: 54pt;\">　</td>\n" +
                "  <td class=\"xl69\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; border-top: 0.5pt solid windowtext; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-left: none; width: 54pt;\">是否研发</td>\n" +
                "  <td class=\"xl70\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; border-top: 0.5pt solid windowtext; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-left: none; width: 54pt;\">基本工资&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 单位：元</td>\n" +
                "  <td class=\"xl71\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; border-top: 0.5pt solid windowtext; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-left: none; width: 54pt;\">其它应发&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 单位：元</td>\n" +
                "  <td class=\"xl71\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; border-top: 0.5pt solid windowtext; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-left: none; width: 54pt;\">考勤扣款&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 单位：元</td>\n" +
                "  <td class=\"xl71\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; border-top: 0.5pt solid windowtext; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-left: none; width: 54pt;\">工会会费<br />\n" +
                "    单位：元</td>\n" +
                "  <td class=\"xl69\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; border-top: 0.5pt solid windowtext; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-left: none; width: 54pt;\">其它扣款<br />\n" +
                "    单位:元</td>\n" +
                "  <td class=\"xl72\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; border-top: 0.5pt solid windowtext; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-left: none; width: 54pt;\">应发工资&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 单位：元</td>\n" +
                "  <td class=\"xl73\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; border-top: 0.5pt solid windowtext; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; background: rgb(226, 239, 218); border-left: none; width: 54pt;\">离职补偿金</td>\n" +
                "  <td class=\"xl69\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; border-top: 0.5pt solid windowtext; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-left: none; width: 54pt;\">养老险&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 单位：元</td>\n" +
                "  <td class=\"xl71\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; border-top: 0.5pt solid windowtext; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-left: none; width: 54pt;\">医疗险&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 单位：元</td>\n" +
                "  <td class=\"xl74\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; border-top: 0.5pt solid windowtext; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-left: none; width: 54pt;\">失业险&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 单位：元</td>\n" +
                "  <td class=\"xl75\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; border-top: 0.5pt solid windowtext; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; background: rgb(255, 192, 0); border-left: none; width: 54pt;\">公积金&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 单位：元</td>\n" +
                "  <td class=\"xl76\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; border-top: 0.5pt solid windowtext; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; background: yellow; border-left: none; width: 54pt;\">社保合计<br />\n" +
                "    单位：元</td>\n" +
                "  <td class=\"xl77\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; border-top: 0.5pt solid windowtext; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; background: red; border-left: none; width: 54pt;\">&nbsp;应交个税&nbsp;</td>\n" +
                "  <td class=\"xl78\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; border-top: 0.5pt solid windowtext; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; background: rgb(255, 192, 0); border-left: none; width: 54pt;\">报税工资&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 单位：元</td>\n" +
                "  <td class=\"xl79\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; border: none; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; background: red; width: 54pt;\">实发工资&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 单位：元</td>\n" +
                "  <td class=\"xl68\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; text-align: center; border: 0.5pt solid windowtext; width: 54pt;\">其它应发/扣款备注</td>\n" +
                " </tr>\n" +
                " <tr height=\"43\" style=\"height: 32.25pt;\">\n" +
                "  <td height=\"43\" class=\"xl68\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; text-align: center; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-left: 0.5pt solid windowtext; border-image: initial; height: 32.25pt; border-top: none; width: 54pt;\">　</td>\n" +
                "  <td class=\"xl68\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; text-align: center; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-top: none; border-left: none; width: 54pt;\">　</td>\n" +
                "  <td class=\"xl68\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; text-align: center; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-top: none; border-left: none; width: 54pt;\">　</td>\n" +
                "  <td class=\"xl68\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; text-align: center; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-top: none; border-left: none; width: 54pt;\">　</td>\n" +
                "  <td class=\"xl68\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; text-align: center; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-top: none; border-left: none; width: 54pt;\">　</td>\n" +
                "  <td class=\"xl69\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-top: none; border-left: none; width: 54pt;\">　</td>\n" +
                "  <td class=\"xl69\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-top: none; border-left: none; width: 54pt;\">　</td>\n" +
                "  <td class=\"xl69\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-top: none; border-left: none; width: 54pt;\">　</td>\n" +
                "  <td class=\"xl70\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-top: none; border-left: none; width: 54pt;\">　</td>\n" +
                "  <td class=\"xl71\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-top: none; border-left: none; width: 54pt;\">　</td>\n" +
                "  <td class=\"xl71\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-top: none; border-left: none; width: 54pt;\">　</td>\n" +
                "  <td class=\"xl71\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-top: none; border-left: none; width: 54pt;\">　</td>\n" +
                "  <td class=\"xl69\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-top: none; border-left: none; width: 54pt;\">　</td>\n" +
                "  <td class=\"xl72\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-top: none; border-left: none; width: 54pt;\">　</td>\n" +
                "  <td class=\"xl73\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; background: rgb(226, 239, 218); border-top: none; border-left: none; width: 54pt;\">　</td>\n" +
                "  <td class=\"xl69\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-top: none; border-left: none; width: 54pt;\">　</td>\n" +
                "  <td class=\"xl71\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-top: none; border-left: none; width: 54pt;\">　</td>\n" +
                "  <td class=\"xl74\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-top: none; border-left: none; width: 54pt;\">　</td>\n" +
                "  <td class=\"xl74\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-top: none; border-left: none; width: 54pt;\">　</td>\n" +
                "  <td class=\"xl74\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-top: none; border-left: none; width: 54pt;\">　</td>\n" +
                "  <td class=\"xl74\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-top: none; border-left: none; width: 54pt;\">　</td>\n" +
                "  <td class=\"xl74\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-top: none; border-left: none; width: 54pt;\">　</td>\n" +
                "  <td class=\"xl74\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; border-top: 0.5pt solid windowtext; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-left: none; width: 54pt;\">　</td>\n" +
                "  <td class=\"xl68\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; text-align: center; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-top: none; border-left: none; width: 54pt;\">　</td>\n" +
                " </tr>\n" +
                "<!--EndFragment-->\n" +
                "</tbody></table><div><br /></div></div></div></div></div>","text/html;charset=utf-8");

        //设置自定义发件人昵称
        String nick="";
        try {
            nick=javax.mail.internet.MimeUtility.encodeText("糖果学习中心");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        message.setFrom(new InternetAddress(nick+" <"+from+">"));
        // 保存并生成最终的邮件内容
        message.saveChanges();

        // 发送邮件
        try {
            Transport.send(message);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * 发送带内嵌图片的HTML邮件
     */
    public static void sendHtmlWithInnerImageEmail() throws MessagingException {
        // 创建Session实例对象
        Session session = Session.getDefaultInstance(props, new MyAuthenticator());

        // 创建邮件内容
        MimeMessage message = new MimeMessage(session);
        // 邮件主题,并指定编码格式
        message.setSubject("带内嵌图片的HTML邮件", "utf-8");
        // 发件人
        message.setFrom(new InternetAddress(from));
        // 收件人
        message.setRecipients(RecipientType.TO, InternetAddress.parse(to));
        // 抄送
//        message.setRecipient(RecipientType.CC, new InternetAddress("java_test@sohu.com"));
//        // 密送 (不会在邮件收件人名单中显示出来)
//        message.setRecipient(RecipientType.BCC, new InternetAddress("417067629@qq.com"));
        // 发送时间
        message.setSentDate(new Date());

        // 创建一个MIME子类型为“related”的MimeMultipart对象
        MimeMultipart mp = new MimeMultipart("related");
        // 创建一个表示正文的MimeBodyPart对象，并将它加入到前面创建的MimeMultipart对象中
        MimeBodyPart htmlPart = new MimeBodyPart();
        mp.addBodyPart(htmlPart);
        // 创建一个表示图片资源的MimeBodyPart对象，将将它加入到前面创建的MimeMultipart对象中
        MimeBodyPart imagePart = new MimeBodyPart();
        mp.addBodyPart(imagePart);

        // 将MimeMultipart对象设置为整个邮件的内容
        message.setContent(mp);

        // 设置内嵌图片邮件体
//        DataSource ds = new FileDataSource(new File("resource/firefoxlogo.png"));
//        DataHandler dh = new DataHandler(ds);
//        imagePart.setDataHandler(dh);
//        imagePart.setContentID("firefoxlogo.png");  // 设置内容编号,用于其它邮件体引用

        // 创建一个MIME子类型为"alternative"的MimeMultipart对象，并作为前面创建的htmlPart对象的邮件内容
        MimeMultipart htmlMultipart = new MimeMultipart("alternative");
        // 创建一个表示html正文的MimeBodyPart对象
        MimeBodyPart htmlBodypart = new MimeBodyPart();
        // 其中cid=androidlogo.gif是引用邮件内部的图片，即imagePart.setContentID("androidlogo.gif");方法所保存的图片
        htmlBodypart.setContent("<div><div><div><div><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"1728\" style=\"border-collapse: collapse; width: 1296pt; border-spacing: 0px;\" id=\"ntes_editor_table_10014\">\n" +
                "<!--StartFragment-->\n" +
                " <colgroup><col width=\"72\" span=\"24\" style=\"width: 54pt;\" />\n" +
                " </colgroup><tbody><tr height=\"44\" style=\"height: 33pt;\">\n" +
                "  <td height=\"44\" class=\"xl68\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; text-align: center; border: 0.5pt solid windowtext; height: 33pt; width: 54pt;\">序号</td>\n" +
                "  <td class=\"xl68\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; text-align: center; border-top: 0.5pt solid windowtext; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-left: none; width: 54pt;\">工号</td>\n" +
                "  <td class=\"xl68\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; text-align: center; border-top: 0.5pt solid windowtext; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-left: none; width: 54pt;\">　</td>\n" +
                "  <td class=\"xl68\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; text-align: center; border-top: 0.5pt solid windowtext; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-left: none; width: 54pt;\">服务公司</td>\n" +
                "  <td class=\"xl68\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; text-align: center; border-top: 0.5pt solid windowtext; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-left: none; width: 54pt;\">　</td>\n" +
                "  <td class=\"xl69\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; border-top: 0.5pt solid windowtext; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-left: none; width: 54pt;\">姓名</td>\n" +
                "  <td class=\"xl69\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; border-top: 0.5pt solid windowtext; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-left: none; width: 54pt;\">　</td>\n" +
                "  <td class=\"xl69\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; border-top: 0.5pt solid windowtext; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-left: none; width: 54pt;\">是否研发</td>\n" +
                "  <td class=\"xl70\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; border-top: 0.5pt solid windowtext; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-left: none; width: 54pt;\">基本工资&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 单位：元</td>\n" +
                "  <td class=\"xl71\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; border-top: 0.5pt solid windowtext; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-left: none; width: 54pt;\">其它应发&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 单位：元</td>\n" +
                "  <td class=\"xl71\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; border-top: 0.5pt solid windowtext; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-left: none; width: 54pt;\">考勤扣款&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 单位：元</td>\n" +
                "  <td class=\"xl71\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; border-top: 0.5pt solid windowtext; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-left: none; width: 54pt;\">工会会费<br />\n" +
                "    单位：元</td>\n" +
                "  <td class=\"xl69\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; border-top: 0.5pt solid windowtext; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-left: none; width: 54pt;\">其它扣款<br />\n" +
                "    单位:元</td>\n" +
                "  <td class=\"xl72\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; border-top: 0.5pt solid windowtext; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-left: none; width: 54pt;\">应发工资&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 单位：元</td>\n" +
                "  <td class=\"xl73\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; border-top: 0.5pt solid windowtext; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; background: rgb(226, 239, 218); border-left: none; width: 54pt;\">离职补偿金</td>\n" +
                "  <td class=\"xl69\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; border-top: 0.5pt solid windowtext; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-left: none; width: 54pt;\">养老险&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 单位：元</td>\n" +
                "  <td class=\"xl71\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; border-top: 0.5pt solid windowtext; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-left: none; width: 54pt;\">医疗险&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 单位：元</td>\n" +
                "  <td class=\"xl74\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; border-top: 0.5pt solid windowtext; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-left: none; width: 54pt;\">失业险&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 单位：元</td>\n" +
                "  <td class=\"xl75\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; border-top: 0.5pt solid windowtext; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; background: rgb(255, 192, 0); border-left: none; width: 54pt;\">公积金&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 单位：元</td>\n" +
                "  <td class=\"xl76\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; border-top: 0.5pt solid windowtext; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; background: yellow; border-left: none; width: 54pt;\">社保合计<br />\n" +
                "    单位：元</td>\n" +
                "  <td class=\"xl77\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; border-top: 0.5pt solid windowtext; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; background: red; border-left: none; width: 54pt;\">&nbsp;应交个税&nbsp;</td>\n" +
                "  <td class=\"xl78\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; border-top: 0.5pt solid windowtext; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; background: rgb(255, 192, 0); border-left: none; width: 54pt;\">报税工资&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 单位：元</td>\n" +
                "  <td class=\"xl79\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; border: none; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; background: red; width: 54pt;\">实发工资&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 单位：元</td>\n" +
                "  <td class=\"xl68\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; text-align: center; border: 0.5pt solid windowtext; width: 54pt;\">其它应发/扣款备注</td>\n" +
                " </tr>\n" +
                " <tr height=\"43\" style=\"height: 32.25pt;\">\n" +
                "  <td height=\"43\" class=\"xl68\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; text-align: center; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-left: 0.5pt solid windowtext; border-image: initial; height: 32.25pt; border-top: none; width: 54pt;\">　</td>\n" +
                "  <td class=\"xl68\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; text-align: center; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-top: none; border-left: none; width: 54pt;\">　</td>\n" +
                "  <td class=\"xl68\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; text-align: center; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-top: none; border-left: none; width: 54pt;\">　</td>\n" +
                "  <td class=\"xl68\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; text-align: center; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-top: none; border-left: none; width: 54pt;\">　</td>\n" +
                "  <td class=\"xl68\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; text-align: center; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-top: none; border-left: none; width: 54pt;\">　</td>\n" +
                "  <td class=\"xl69\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-top: none; border-left: none; width: 54pt;\">　</td>\n" +
                "  <td class=\"xl69\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-top: none; border-left: none; width: 54pt;\">　</td>\n" +
                "  <td class=\"xl69\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-top: none; border-left: none; width: 54pt;\">　</td>\n" +
                "  <td class=\"xl70\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-top: none; border-left: none; width: 54pt;\">　</td>\n" +
                "  <td class=\"xl71\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-top: none; border-left: none; width: 54pt;\">　</td>\n" +
                "  <td class=\"xl71\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-top: none; border-left: none; width: 54pt;\">　</td>\n" +
                "  <td class=\"xl71\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-top: none; border-left: none; width: 54pt;\">　</td>\n" +
                "  <td class=\"xl69\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-top: none; border-left: none; width: 54pt;\">　</td>\n" +
                "  <td class=\"xl72\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-top: none; border-left: none; width: 54pt;\">　</td>\n" +
                "  <td class=\"xl73\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; background: rgb(226, 239, 218); border-top: none; border-left: none; width: 54pt;\">　</td>\n" +
                "  <td class=\"xl69\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-top: none; border-left: none; width: 54pt;\">　</td>\n" +
                "  <td class=\"xl71\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-top: none; border-left: none; width: 54pt;\">　</td>\n" +
                "  <td class=\"xl74\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-top: none; border-left: none; width: 54pt;\">　</td>\n" +
                "  <td class=\"xl74\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-top: none; border-left: none; width: 54pt;\">　</td>\n" +
                "  <td class=\"xl74\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-top: none; border-left: none; width: 54pt;\">　</td>\n" +
                "  <td class=\"xl74\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-top: none; border-left: none; width: 54pt;\">　</td>\n" +
                "  <td class=\"xl74\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-top: none; border-left: none; width: 54pt;\">　</td>\n" +
                "  <td class=\"xl74\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; border-top: 0.5pt solid windowtext; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-left: none; width: 54pt;\">　</td>\n" +
                "  <td class=\"xl68\" width=\"72\" style=\"padding-top: 1px; padding-right: 1px; padding-left: 1px; vertical-align: middle; font-size: 10pt; font-weight: 700; font-family: 微软雅黑, sans-serif; text-align: center; border-right: 0.5pt solid windowtext; border-bottom: 0.5pt solid windowtext; border-image: initial; border-top: none; border-left: none; width: 54pt;\">　</td>\n" +
                " </tr>\n" +
                "<!--EndFragment-->\n" +
                "</tbody></table><div><br /></div></div></div></div></div>","text/html;charset=utf-8");
        // htmlMultipart.addBodyPart(htmlBodypart);
        htmlPart.setContent(htmlMultipart);

        // 保存并生成最终的邮件内容
        message.saveChanges();

        // 发送邮件
        Transport.send(message);
    }

    /**
     * 发送带内嵌图片、附件、多收件人(显示邮箱姓名)、邮件优先级、阅读回执的完整的HTML邮件
     */
    public static void sendMultipleEmail() throws Exception {
        String charset = "utf-8";   // 指定中文编码格式
        // 创建Session实例对象
        Session session = Session.getInstance(props,new MyAuthenticator());

        // 创建MimeMessage实例对象
        MimeMessage message = new MimeMessage(session);
        // 设置主题
        message.setSubject("使用JavaMail发送混合组合类型的邮件测试");
        // 设置发送人
        message.setFrom(new InternetAddress(from,"新浪测试邮箱",charset));
        // 设置收件人
        message.setRecipients(RecipientType.TO,
                new Address[] {
                        // 参数1：邮箱地址，参数2：姓名（在客户端收件只显示姓名，而不显示邮件地址），参数3：姓名中文字符串编码
                        new InternetAddress("601455653@qq.com", "徐灿173", charset),
                }
        );
        // 设置抄送
        message.setRecipient(RecipientType.CC, new InternetAddress("601455653@qq.com","王五_gmail",charset));
        // 设置密送
        message.setRecipient(RecipientType.BCC, new InternetAddress("601455653@qq.com", "赵六_QQ", charset));
        // 设置发送时间
        message.setSentDate(new Date());
        // 设置回复人(收件人回复此邮件时,默认收件人)
        message.setReplyTo(InternetAddress.parse("\"" + MimeUtility.encodeText("文化") + "\" <601455653@qq.com>"));
        // 设置优先级(1:紧急   3:普通    5:低)
        message.setHeader("X-Priority", "1");
        // 要求阅读回执(收件人阅读邮件时会提示回复发件人,表明邮件已收到,并已阅读)
        message.setHeader("Disposition-Notification-To", from);

        // 创建一个MIME子类型为"mixed"的MimeMultipart对象，表示这是一封混合组合类型的邮件
        MimeMultipart mailContent = new MimeMultipart("mixed");
        message.setContent(mailContent);

        // 附件
        MimeBodyPart attach1 = new MimeBodyPart();
        MimeBodyPart attach2 = new MimeBodyPart();
        // 内容
        MimeBodyPart mailBody = new MimeBodyPart();

        // 将附件和内容添加到邮件当中
        //mailContent.addBodyPart(attach1);
        mailContent.addBodyPart(attach2);
        mailContent.addBodyPart(mailBody);

        // 附件1(利用jaf框架读取数据源生成邮件体)
//        DataSource ds1 = new FileDataSource("resource/Earth.bmp");
//        DataHandler dh1 = new DataHandler(ds1);
//        attach1.setFileName(MimeUtility.encodeText("Earth.bmp"));
//        attach1.setDataHandler(dh1);

        // 附件2
        DataSource ds2 = new FileDataSource("C:\\Users\\xucan\\Desktop\\candy\\AdminServer\\src\\main\\resources\\banner.txt");
        DataHandler dh2 = new DataHandler(ds2);
        attach2.setDataHandler(dh2);
        attach2.setFileName(MimeUtility.encodeText("banner.txt"));

        // 邮件正文(内嵌图片+html文本)
        MimeMultipart body = new MimeMultipart("related");  //邮件正文也是一个组合体,需要指明组合关系
        mailBody.setContent(body);
//
//        // 邮件正文由html和图片构成
//        MimeBodyPart imgPart = new MimeBodyPart();
        MimeBodyPart htmlPart = new MimeBodyPart();
//        body.addBodyPart(imgPart);
        body.addBodyPart(htmlPart);
//
//        // 正文图片
//        DataSource ds3 = new FileDataSource("resource/firefoxlogo.png");
//        DataHandler dh3 = new DataHandler(ds3);
//        imgPart.setDataHandler(dh3);
//        imgPart.setContentID("firefoxlogo.png");

        // html邮件内容
        MimeMultipart htmlMultipart = new MimeMultipart("alternative");
         htmlPart.setContent(htmlMultipart);
        MimeBodyPart htmlContent = new MimeBodyPart();
        htmlContent.setContent(
                "<span style='color:red'>这是我自己用java mail发送的邮件哦！" +
                        "<img src='' /></span>"
                , "text/html;charset=gbk");
        htmlMultipart.addBodyPart(htmlContent);

        // 保存邮件内容修改
        message.saveChanges();

        /*File eml = buildEmlFile(message);
        sendMailForEml(eml);*/

        // 发送邮件
        Transport.send(message);
    }

    /**
     * 将邮件内容生成eml文件
     * @param message 邮件内容
     */
    public static File buildEmlFile(Message message) throws MessagingException, FileNotFoundException, IOException {
        File file = new File("c:\\" + MimeUtility.decodeText(message.getSubject())+".eml");
        message.writeTo(new FileOutputStream(file));
        return file;
    }

    /**
     * 发送本地已经生成好的email文件
     */
    public static void sendMailForEml(File eml) throws Exception {
        // 获得邮件会话
        Session session = Session.getInstance(props,new MyAuthenticator());
        // 获得邮件内容,即发生前生成的eml文件
        InputStream is = new FileInputStream(eml);
        MimeMessage message = new MimeMessage(session,is);
        //发送邮件
        Transport.send(message);
    }

    public static void sendMailByParam(SendMailParamTO sendMailParamTO) throws Exception{
        // 创建Session实例对象
        Session session = Session.getInstance(props,new MyAuthenticator());
        // 创建MimeMessage实例对象
        MimeMessage message = new MimeMessage(session);
        // 设置主题
        message.setSubject(sendMailParamTO.getSubject());
        // 设置发送人
        message.setFrom(new InternetAddress(from,from,CHARSET));
        // 设置收件人
        if (CollectionUtils.isEmpty(sendMailParamTO.getToMailAddressList())) {
            throw new RuntimeException("收件人不能为空");
        }
        ArrayList<InternetAddress> internetAddresses = new ArrayList<>();
        List<String> toMailAddressList = sendMailParamTO.getToMailAddressList();
        for (String address : toMailAddressList) {
            InternetAddress internetAddress = new InternetAddress(address, address, CHARSET);
            internetAddresses.add(internetAddress);
        }
        message.setRecipients(RecipientType.TO, internetAddresses.toArray(new InternetAddress[internetAddresses.size()]));
        // 设置抄送
        if (sendMailParamTO.getAddressList() != null && sendMailParamTO.getAddressList().size() > 0) {
            ArrayList<InternetAddress> internetAddressesCC = new ArrayList<>();
            List<String> addressList = sendMailParamTO.getAddressList();
            for (String address : addressList) {
                InternetAddress internetAddress = new InternetAddress(address, address, CHARSET);
                internetAddressesCC.add(internetAddress);
            }
            message.setRecipients(RecipientType.CC, internetAddressesCC.toArray(new InternetAddress[internetAddressesCC.size()]));
        }
        // 设置密送
        // message.setRecipients(RecipientType.BCC, internetAddressesCC.toArray(new InternetAddress[internetAddressesCC.size()]));
        // 设置发送时间
        message.setSentDate(new Date());
        // 设置回复人(收件人回复此邮件时,默认收件人)
        message.setReplyTo(new InternetAddress[] { new InternetAddress(from,from,CHARSET) });
        // 设置优先级(1:紧急   3:普通    5:低)
        message.setHeader("X-Priority", "3");
        // 要求阅读回执(收件人阅读邮件时会提示回复发件人,表明邮件已收到,并已阅读)
        if ("1".equals(sendMailParamTO.getReceiptFlag())) {
            message.setHeader("Disposition-Notification-To", from);
        }
        // 创建一个MIME子类型为"mixed"的MimeMultipart对象，表示这是一封混合组合类型的邮件
        MimeMultipart mailContent = new MimeMultipart("mixed");
        message.setContent(mailContent);
        // 附件
        MimeBodyPart attach = new MimeBodyPart();
        // 内容
        MimeBodyPart mailBody = new MimeBodyPart();
        // 将附件和内容添加到邮件当中
        mailContent.addBodyPart(attach);
        mailContent.addBodyPart(mailBody);
        // 附件2
        DataSource ds = new ByteArrayDataSource("我是一个文本附件","text/html;charset=utf-8");
        DataHandler dh = new DataHandler(ds);
        attach.setDataHandler(dh);
        attach.setFileName(MimeUtility.encodeText("banner.txt"));
        // 邮件正文(内嵌图片+html文本)
        MimeMultipart body = new MimeMultipart("related");  //邮件正文也是一个组合体,需要指明组合关系
        mailBody.setContent(body);
        // 邮件正文由html构成
        MimeBodyPart htmlPart = new MimeBodyPart();
        body.addBodyPart(htmlPart);
        // html邮件内容
        MimeMultipart htmlMultipart = new MimeMultipart("alternative");
        htmlPart.setContent(htmlMultipart);
        MimeBodyPart htmlContent = new MimeBodyPart();
        htmlContent.setContent(sendMailParamTO.getContent(), "text/html;charset=gbk");
        htmlMultipart.addBodyPart(htmlContent);
        // 保存邮件内容修改
        message.saveChanges();
        // 发送邮件
        Transport.send(message);
    }

    /**
     * 向邮件服务器提交认证信息
     */
    static class MyAuthenticator extends Authenticator {

        private String username = "15071482539@163.com";

        private String password = "WMRMQTBDUMHBSBWG";

        public MyAuthenticator() {
            super();
        }

        public MyAuthenticator(String username, String password) {
            super();
            this.username = username;
            this.password = password;
        }

        @Override
        protected PasswordAuthentication getPasswordAuthentication() {

            return new PasswordAuthentication(username, password);
        }
    }
}
