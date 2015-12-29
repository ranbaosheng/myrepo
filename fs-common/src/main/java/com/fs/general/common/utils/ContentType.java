package com.fs.general.common.utils;

import java.util.Map;

import com.google.common.collect.Maps;

/**
 * 
 * @author fangli
 *
 */
public class ContentType {

    /**
     ******************************** 操作类型********************************************************************
     */
    /**
     * 新增
     */
    public static Integer OPER_TYPE_ADD = 1;
    /**
     * 修改
     */
    public static Integer OPER_TYPE_UPDATE = 2;
    /**
     * 删除
     */
    public static Integer OPER_TYPE_DELETE = 3;
    /**
     * 查询
     */
    public static Integer OPER_TYPE_SELECT = 4;
    /**
     * 详单
     */
    public static Integer OPER_TYPE_DETAIL = 5;
    /**
     * 下载
     */
    public static Integer OPER_TYPE_DOWNLOAD = 6;
    /**
     * 上传
     */
    public static Integer OPER_TYPE_UPLOAD = 7;
    /**
     * *********************************系统模块*******************************************************************
     */
    /**
     * 操作员
     */
    public static Integer SYS_MOUDLE_USER = 1;
    /**
     * 角色
     */
    public static Integer SYS_MOUDLE_ROLE = 2;
    /**
     * 菜单
     */
    public static Integer SYS_MOUDLE_RESOURCE = 3;
    /**
     * 参数
     */
    public static Integer SYS_MOUDLE_PARAMETER = 4;
    /**
     * 字典类型
     */
    public static Integer SYS_MOUDLE_DICTS = 5;
    /**
     * 数据字典
     */
    public static Integer SYS_MOUDLE_DICTIONARY = 6;
    /**
     * 栏目
     */
    public static Integer SYS_MOUDLE_COLUMN = 7;
    /**
     * 文章
     */
    public static Integer SYS_MOUDLE_ARTICAL = 8;
    /**
     * 广告位
     */
    public static Integer SYS_MOUDLE_AD_PLACE = 9;
    /**
     * 广告
     */
    public static Integer SYS_MOUDLE_AD = 10;
    /**
     * 前台模板
     */
    public static Integer SYS_MOUDLE_TEMPLE = 11;
    /**
     * 邮件模板
     */
    public static Integer SYS_MOUDLE_MAIL_TEMP = 12;
    /**
     * 短信模板
     */
    public static Integer SYS_MOUDLE_SMS_TEMP = 13;
    /**
     * 资源文件
     */
    public static Integer SYS_MOUDLE_FIEL = 14;
    /**
     * SEO
     */
    public static Integer SYS_MOUDLE_SEO = 15;
    /**
     * 网站参数
     */
    public static Integer SYS_MOUDLE_NET_PARA = 16;
    /**
     * 系统消息
     */
    public static Integer SYS_MOUDLE_MESSAGE = 17;

    /**
     * 银行卡字典
     */
    public static final Integer SYS_MOUDLE_YHKZD = 18;
    /**
     * 第三方银行卡
     */
    public static final Integer SYS_MOUDLE_DSFYHK = 19;
    /**
     * 第三方支付
     */
    public static final Integer SYS_MOUDLE_DSFZF = 20;

    /****************
     * 1 充值 2 支付 3 提现 4 绑卡 5 还款 6 借款 7 滞纳金 8 认购 9 冻结 10 解冻
     **********************/
    /**
     * 1充值
     */
    public static final Integer PAY_OPER_TYPE_CZ = 1;
    /**
     * 11新建
     */
    public static final Integer PAY_CZ_STATUS_1 = 11;

    /**
     * 2 支付
     */
    public static final Integer PAY_OPER_TYPE_ZF = 2;
    /**
     * 21新建
     */
    public static final Integer PAY_ZF_STATUS_1 = 21;
    /**
     * 3 提现
     */
    public static final Integer PAY_OPER_TYPE_TX = 3;
    /**
     * 31提现申请中
     */
    public static final Integer PAY_TX_STATUS_1 = 31;
    /**
     * 32提现支付中（已生成提现流水）
     */
    public static final Integer PAY_TX_STATUS_2 = 32; 
    /**
     * 33提现成功
     */
    public static final Integer PAY_TX_STATUS_3 = 33; 
    /**
     * 34提现失败
     */
    public static final Integer PAY_TX_STATUS_4 = 34;
    /**
     * 35提现驳回
     */
    public static final Integer PAY_TX_STATUS_5 = 35;
    /**
     * 4 绑卡
     */
    public static final Integer PAY_OPER_TYPE_BC = 4;
    /**
     * 41新建
     */
    public static final Integer PAY_BC_STATUS_1 = 41;
    /**
     * 5 还款
     */
    public static final Integer PAY_OPER_TYPE_HK = 5;
    /**
     * 51新建
     */
    public static final Integer PAY_HK_STATUS_1 = 51;
    /**
     * 6 借款
     */
    public static final Integer PAY_OPER_TYPE_JK = 6;
    /**
     * 61新建
     */
    public static final Integer PAY_JK_STATUS_1 = 61;
    /**
     * 7 滞纳金
     */
    public static final Integer PAY_OPER_TYPE_ZNJ = 7;
    /**
     * 71新建
     */
    public static final Integer PAY_ZNJ_STATUS_1 = 71;
    /**
     * 8 认购
     */
    public static final Integer PAY_OPER_TYPE_RG = 8;
    /**
     * 81新建
     */
    public static final Integer PAY_RG_STATUS_1 = 81;
    /**
     * 9 冻结
     */
    public static final Integer PAY_OPER_TYPE_DJ = 9;
    /**
     * 91新建
     */
    public static final Integer PAY_DJ_STATUS_1 = 91;
    /**
     * 10 解冻
     */
    public static final Integer PAY_OPER_TYPE_JD = 10;
    /**
     * 101新建
     */
    public static final Integer PAY_JD_STATUS_1 = 101;

    public static Map<Integer, String> payOperTypeMap = Maps.newHashMap();
    
    static {
        payOperTypeMap.put(PAY_OPER_TYPE_CZ, "CZ");
        payOperTypeMap.put(PAY_OPER_TYPE_ZF, "ZF");
        payOperTypeMap.put(PAY_OPER_TYPE_TX, "TX");
        payOperTypeMap.put(PAY_OPER_TYPE_BC, "BC");
        payOperTypeMap.put(PAY_OPER_TYPE_HK, "HK");
        payOperTypeMap.put(PAY_OPER_TYPE_JK, "JK");
        payOperTypeMap.put(PAY_OPER_TYPE_ZNJ, "ZNJ");
        payOperTypeMap.put(PAY_OPER_TYPE_RG, "RG");
        payOperTypeMap.put(PAY_OPER_TYPE_DJ, "DJ");
        payOperTypeMap.put(PAY_OPER_TYPE_JD, "JD");
    }

}
