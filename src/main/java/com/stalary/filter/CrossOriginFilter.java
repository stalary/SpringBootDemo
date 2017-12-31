package com.stalary.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class CrossOriginFilter implements Filter {

    private String allowOrigin;

    private static final Logger logger = LoggerFactory
            .getLogger(CrossOriginFilter.class);
    public static final NumberFormat FORMAT = new DecimalFormat("0.000");

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        allowOrigin = filterConfig.getInitParameter("allowOrigin");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        long begin = System.currentTimeMillis();

        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", allowOrigin);
        response.setHeader("Access-Control-Allow-Methods",
                "GET, POST, PUT, DELETE, OPTIONS");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers",
                "Origin, X-Requested-With, Content-Type, Accept, Authorization");

        chain.doFilter(req, res);


        if (logger.isInfoEnabled()) {
            long end = System.currentTimeMillis();
            BigDecimal processed = new BigDecimal(end - begin)
                    .divide(new BigDecimal(1000));
            String uri = ((HttpServletRequest) req).getRequestURI();
            //login.do 作为负载均衡健康检查的url,打印日志的话,日志量会很大
            if (!uri.equals("/login.do")) {
                logger.info("Processed in {} second(s). URI={}",
                        FORMAT.format(processed), uri);
            }

        }
    }

    @Override
    public void destroy() {

    }
}
