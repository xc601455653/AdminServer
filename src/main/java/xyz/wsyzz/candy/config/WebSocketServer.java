package xyz.wsyzz.candy.config;

/**
 * Created by ${XC} on 2019/5/17.
 */
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;
import javax.servlet.http.HttpSession;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * WebSocket服务端示例
 * @author xc
 *
 */
@ServerEndpoint(value = "/ws/chat", configurator = WebSocketConfig.class)
@Component
public class WebSocketServer {

    private static Logger logger = LoggerFactory.getLogger(WebSocketServer.class);
    private static final AtomicInteger ONLINECOUNT = new AtomicInteger(0);
    // concurrent包的线程安全Set，用来存放每个客户端对应的Session对象。
    private static CopyOnWriteArraySet<Session> sessionSet = new CopyOnWriteArraySet<>();


    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session, EndpointConfig config) {
        Object o = config.getUserProperties().get(HttpSession.class.getName());
        Object name = ((HttpSession) o).getAttribute("name");
        System.out.println(name);
        sessionSet.add(session);
        int cnt = ONLINECOUNT.incrementAndGet(); // 在线数加1
        logger.info("有连接加入，当前连接数为：{}", cnt);
        sendMessage(session, "连接成功");
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(Session session) {
        sessionSet.remove(session);
        int cnt = ONLINECOUNT.decrementAndGet();
        logger.info("有连接关闭，当前连接数为：{}", cnt);
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message
     * 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        logger.info("来自客户端的消息：{}",message);
        sendMessage(session, "收到消息，消息内容："+message);

    }

    /**
     * 出现错误
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        logger.error("发生错误：{}，Session ID： {}",error.getMessage(),session.getId());
        error.printStackTrace();
    }

    /**
     * 发送消息，实践表明，每次浏览器刷新，session会发生变化。
     * @param session
     * @param message
     */
    public static void sendMessage(Session session, String message) {
        try {
            session.getBasicRemote().sendText(String.format("%s (From Server，Session ID=%s)",message,session.getId()));
        } catch (IOException e) {
            logger.error("发送消息出错：{}", e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 群发消息
     * @param message
     * @throws IOException
     */
    public static void broadCastInfo(String message) throws IOException {
        for (Session session : sessionSet) {
            if(session.isOpen()){
                sendMessage(session, message);
            }
        }
    }

    /**
     * 指定Session发送消息
     * @param sessionId
     * @param message
     * @throws IOException
     */
    public static void sendMessage(String sessionId,String message) throws IOException {
        Session session = null;
        for (Session s : sessionSet) {
            if(s.getId().equals(sessionId)){
                session = s;
                break;
            }
        }
        if(session!=null){
            sendMessage(session, message);
        }
        else{
            logger.warn("没有找到你指定ID的会话：{}",sessionId);
        }
    }

}

