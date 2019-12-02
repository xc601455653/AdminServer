package xyz.wsyzz.candy.listener;


import org.springframework.stereotype.Component;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by xucan on 2019/11/28.
 */
@Component
public class RequestListener implements ServletRequestListener {
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        ((HttpServletRequest)sre.getServletRequest()).getSession();
    }
}
