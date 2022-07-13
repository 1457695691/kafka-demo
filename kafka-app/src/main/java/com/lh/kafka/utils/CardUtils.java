package com.lh.kafka.utils;


import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 银行卡校验工具类
 *
 * @author 李航
 */
public class CardUtils extends StringUtils {


    /**
     * 校验银行卡有效性
     * (正则规则：长度16，前6位622566，7、8位产品类型，有效值01、02、03)
     *
     * @param cardNum 银行卡号
     * @return true or false
     */
    public static boolean isBankCard(String cardNum) {
        Pattern pattern = Pattern
                .compile("^([6][2][2][5][6][6][0][1-3]\\d{8})$");
        Matcher match = pattern.matcher(cardNum);
        return match.matches();
    }


    /**
     * 工具类测试
     */
    public static void main(String[] args) {
        List<String> cardList = new ArrayList<>();
        //right
        cardList.add("6225660112345678");
        //error
        cardList.add("test110");
        cardList.add("520");
        cardList.add("622566011234567");
        cardList.add("6225660512345678");
        cardList.add("62256605123456#8");
        cardList.add("6225660&12345678");

        cardList.forEach(it -> {
            boolean result = isBankCard(it);
            System.out.println(result);
        });
    }

}
