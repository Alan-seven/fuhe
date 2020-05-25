package com.jsite.core.service;

/**
 * 错误码，错误消息
 * @author 徐旺旺
 *
 */
public interface RespCode {
	public static final int SERVICE_RESP_ERROR_CODE_1 = 1;
	public static final String SERVICE_RESP_ERROR_CODE_1_MSG = "操作成功";
	
	public static final int SERVICE_RESP_ERROR_CODE_0 = 0;
	public static final String SERVICE_RESP_ERROR_CODE_0_MSG = "操作失败";
	/**
	 * 数据验证失败
	 */
	public static final int SERVICE_RESP_ERROR_CODE_2 = 2;
}
