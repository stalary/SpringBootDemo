package com.stalary.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Props
 *
 * @author lirongqian
 * @since 2018/03/19
 */
@Component
@Data
@ConfigurationProperties(prefix = "props")
public class Props {

    private Map<String, String> map = new HashMap<>();

    private String test;

}