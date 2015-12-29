package com.fs.general.common.utils;

import java.util.Map;
import java.util.ResourceBundle;

import com.google.common.collect.Maps;

/**
 * 常量类
 * 
 * @author guojun
 *
 */
public class Constants {

	/**
	 * 读取加载pay URL的配置文件
	 */
	public static ResourceBundle pay = ResourceBundle.getBundle("pay");

	/**
	 * 逻辑与的转义表示
	 */
	public static final String AND_AMP = "&";
	/**
	 * 等号
	 */
	public static final String EQU = "=";

	/**
	 * 第三方支付错误代码
	 */
	public static Map<String, String> errorCode = Maps.newHashMap();

	static {
		errorCode.put("310012121", "系统内部异常");
		errorCode.put("310012123", "系统内部异常");
		errorCode.put("310012125", "系统内部异常");
		errorCode.put("310099995", "系统内部异常");
		errorCode.put("200100001", "系统内部异常");
		errorCode.put("200300000", "系统内部异常");
		errorCode.put("200300001", "系统内部异常");
		errorCode.put("200300006", "系统内部异常");
		errorCode.put("200300009", "系统内部异常");
		errorCode.put("200300010", "系统内部异常");
		errorCode.put("200300028", "系统内部异常");
		errorCode.put("200300030", "系统内部异常");
		errorCode.put("200300076", "系统内部异常");
		errorCode.put("200300077", "系统内部异常");
		errorCode.put("200300092", "系统内部异常");
		errorCode.put("200500000", "系统内部异常");
		errorCode.put("200500002", "系统内部异常");
		errorCode.put("200500015", "系统内部异常");
		errorCode.put("200500028", "系统内部异常");
		errorCode.put("200600000", "系统内部异常");
		errorCode.put("200600002", "系统内部异常");
		errorCode.put("200600004", "系统内部异常");
		errorCode.put("200600016", "系统内部异常");
		errorCode.put("200700006", "系统内部异常");
		errorCode.put("200700007", "系统内部异常");
		errorCode.put("200700008", "系统内部异常");
		errorCode.put("200700011", "系统内部异常");
		errorCode.put("209900000", "系统内部异常");
		errorCode.put("209900013", "系统内部异常");
		errorCode.put("100138001", "系统内部异常");
		errorCode.put("100131000", "无此接口");
		errorCode.put("100134011", "签名错误");
		errorCode.put("100134012", "绑定信息不存在 ");
		errorCode.put("100134001", "支付渠道错误");
		errorCode.put("100134002", "支付方式错误");
		errorCode.put("100130001", "tradeCode 错误 ");
		errorCode.put("100130002", "requestId 错误 ");
		errorCode.put("100130003", "tradeProcess 错误 ");
		errorCode.put("100130004", "mersignature 错误 ");
		errorCode.put("100130005", "userIdIdentity 错误 ");
		errorCode.put("100130006", "encode 错误 ");
		errorCode.put("100130011", "totalBizType 错误 ");
		errorCode.put("100130012", "总金额错误 ");
		errorCode.put("100130013", "passThrough 错误 ");
		errorCode.put("100130014", "goodsDesc 错误 ");
		errorCode.put("100130015", "rePayTimeOut 错误 ");
		errorCode.put("100130016", "商品信息错误 ");
		errorCode.put("100130017", "noticeurl 错误 ");
		errorCode.put("100130021", "productId 错误 ");
		errorCode.put("100130022", "productName 错误 ");
		errorCode.put("100130023", "产品金额错误 ");
		errorCode.put("100130024", "merAcct 错误 ");
		errorCode.put("100130025", "bizType 错误 ");
		errorCode.put("100130026", "productNumber 错误 ");
		errorCode.put("100130031", "requestOrderId 错误 ");
		errorCode.put("100130032", "bindId 错误 ");
		errorCode.put("100130034", "randomValidateId 错误 ");
		errorCode.put("100130035", "randomCode 错误 ");
		errorCode.put("100130036", "bankCode 错误 ");
		errorCode.put("200100004", "bankCode 错误 ");
		errorCode.put("100130037", "bankAccount 错误或 shortBankAccount 错误 ");
		errorCode.put("100130038", "bankCardType 错误 ");
		errorCode.put("100130039", "validDate 错误 ");
		errorCode.put("100130040", "cvnCode 错误 ");
		errorCode.put("100130041", "idType 错误 ");
		errorCode.put("100130042", "idNumber 错误 ");
		errorCode.put("100130043", "name 错误 ");
		errorCode.put("100130044", "mobilePhone 错误 ");
		errorCode.put("100130045", "isNeedBind 错误 ");
		errorCode.put("100130046", "tradeId 错误 ");
		errorCode.put("200200000", "订单号重复 ");
		errorCode.put("200300026", "该订单不能重新支付 ");
		errorCode.put("200300027", "该订单已过期无法继续支付 ");
		errorCode.put("200100003", "指定业务类型不存在 ");
		errorCode.put("200300089", "银行处理超时 ");
		errorCode.put("200300234", "商户关联的支付渠道不存在 ");
		errorCode.put("200500046", "此用户不存在 ");
		errorCode.put("200600023", "此商户不存在 ");
		errorCode.put("200700012", "60 秒内重复发送短信 ");
		errorCode.put("310000000", "输入参数不合法 ");
		errorCode.put("310012122", "银行通信异常 ");
		errorCode.put("310040001", "认证信息不匹配 ");
		errorCode.put("310040002", "支付金额超过银行卡每日限额 ");
		errorCode.put("310040003", "银行卡余额不足 ");
		errorCode.put("310040004", "银行支付失败 ");
		errorCode.put("310013603", "银行支付失败 ");
		errorCode.put("310040005", "银行正在处理，请稍候 ");
		errorCode.put("310040006", "银行卡未开通此功能 ");
		errorCode.put("310040007", "银行卡类型不支持此业务 ");
		errorCode.put("310030001", "银行通讯异常，请联系丰付客服 ");
		errorCode.put("310040008", "支付金额超出单笔交易限额 ");
		errorCode.put("310040009", "系统忙，请稍后再");
	}

}
