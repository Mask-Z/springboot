package com.doodle.web.home;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 周云龙
 * @date 2018/5/2 13:54
 */
@Component
public class HomeProperties {

    @Value("${home.uuid}")
    private String uuid;
    @Value("${home.province}")
    private String province;
    @Value("${home.city}")
    private String city;
    @Value("${home.desc}")
    private String desc;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "HomeProperties{" +
                "uuid='" + uuid + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
