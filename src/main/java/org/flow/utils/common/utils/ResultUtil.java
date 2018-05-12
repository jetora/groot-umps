package org.flow.utils.common.utils;

import org.flow.utils.common.enums.ErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

public class ResultUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(ResultUtil.class);

    /**
     * normal
     * @param success
     * @param data
     * @param message
     * @param <T>
     * @return
     */
    public static <T> ResponseResult<T> buildResult(String errorCode, String message , T data) {
        ResponseResult<T> result = ResponseResult.newInstance();
        result.setCode(errorCode);
        result.setData(data);
        result.setMsg(message);
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("generate rest result:{}", result);
        }
        return result;
    }

    public static <T> ResponseResult<T> buildResult(String errorCode, String message) {
        ResponseResult<T> result = ResponseResult.newInstance();
        result.setCode(errorCode);
        result.setMsg(message);
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("generate rest result:{}", result);
        }
        return result;
    }

    /**
     * success
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResponseResult<T> buildSuccessResult(String errCode,T data) {

        return buildResult(errCode, null,data);
    }

    /**
     * error message
     * @param message error message
     * @param <T>
     * @return
     */
    public static <T> ResponseResult<T> buildErrorResult(String errCode,String message) {

        return buildResult(errCode,message, null);
    }
}
