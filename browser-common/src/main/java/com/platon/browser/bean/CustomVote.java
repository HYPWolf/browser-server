package com.platon.browser.bean;

import com.platon.browser.dao.entity.Vote;
import lombok.Data;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Chendongming
 * @Date: 2019/8/16 15:36
 * @Description: 投票实体扩展类
 */
@Data
public class CustomVote extends Vote {

    public CustomVote(){
        super();
        Date date = new Date();
        this.setCreateTime(date);
        this.setUpdateTime(date);
    }

    /**
     * 投票类型枚举类：
     *  1.支持
     *  2.反对
     *  3.弃权
     */
    public enum OptionEnum {
        SUPPORT("1", "支持"),
        OPPOSITION("2", "反对"),
        ABSTENTION("3", "弃权"),
        INVALID_SUPPORT("11", "支持（无效）"),
        INVALID_OPPOSITION("12", "反对（无效）"),
        INVALID_ABSTENTION("13", "弃权（无效）");
        private String code;
        private String desc;
        OptionEnum ( String code, String desc ) {
            this.code = code;
            this.desc = desc;
        }
        public String getCode () {
            return code;
        }
        public String getDesc () {
            return desc;
        }
        private static final Map<String, OptionEnum> ENUMS = new HashMap<>();
        static {
            Arrays.asList(OptionEnum.values()).forEach(en -> ENUMS.put(en.code, en));
        }
        public static OptionEnum getEnum ( String code ) {
            return ENUMS.get(code);
        }
        public static boolean contains ( String code ) {
            return ENUMS.containsKey(code);
        }
        public static boolean contains ( OptionEnum en ) {
            return ENUMS.containsValue(en);
        }
    }
}
