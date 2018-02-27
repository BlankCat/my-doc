package com.dianjingyun.xhht.controller;

import java.math.BigDecimal;

/**
 * @author  zjf
 * @date 创建时间：2018年2月27日 
 * @Description 金钱数字转大写
 */
public class MoneyOpt {

  public interface IMoney {

    public  String moneyToUpper(String paranMoney);

  }
  
  public static  class MoneyUpper implements IMoney {
    public MoneyUpper(){}
    public String moneyToUpper(String paranMoney) {
        System.out.println("输入小写的金额：" + paranMoney);
        StringBuffer strMoney = new StringBuffer();
        String[] numList = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
        String[] unitList = { "分", "角", "元", "拾", "佰", "仟", "万","十万","百万","千万","亿"};
        BigDecimal money = new BigDecimal(paranMoney);
        double douMoney = money.doubleValue() * 100;
        if (money.intValue() == 0) {
            return "零元整";
        }
        // 只取小数后两位
        String strNum = money.setScale(2, BigDecimal.ROUND_DOWN).toString();
        strNum = strNum.substring(0, strNum.length() - 3)
                + strNum.substring(strNum.length() - 2, strNum.length());
        int len = strNum.length();
        int zero = 0;
        for (int i = 0; i < len; i++) {
            String str = strNum.substring(i, i + 1).trim();
            int nuitNum = len - i - 1;
            int num = Integer.valueOf(str).intValue();
            if (num == 0) {
                zero++;
                if (nuitNum == 2 || nuitNum == 6 || nuitNum == 10) {
                    if (nuitNum == 2 || zero < 4) 
                        strMoney.append(unitList[nuitNum]);
                        zero = 0;
                }
                } else {
                    if (zero > 0) {
                        strMoney.append(numList[0]);
                        zero = 0;
                    }
                    strMoney.append(numList[num]);
                    strMoney.append(unitList[nuitNum]);
                }
            }
            if (zero > 0) 
                strMoney.append("整");
                System.out.println("输入大写金额:" + strMoney.toString());
                return strMoney.toString();
        
    }
}
  
  public static void main(String[] args) {
    IMoney money=new MoneyUpper();
    
    money.moneyToUpper("1000301212");
  }
}
