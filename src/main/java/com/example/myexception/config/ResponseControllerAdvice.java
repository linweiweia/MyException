package com.example.myexception.config;

import com.example.myexception.exception.MyException;
import com.example.myexception.vo.ResultVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author linweiwei
 * @version 1.0
 * @date 2020-08-26 15:25
 * @describe:
 */

@RestControllerAdvice(basePackages = {"com.example.myexception.controller"})
public class ResponseControllerAdvice implements ResponseBodyAdvice<Object> {
    /**
     * 判断哪些方法需要执行beforeBodyWrite
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        // 如果返回不是ResultVO就需要增强
        return !methodParameter.getParameterType().equals(ResultVO.class);
    }

    /**
     * 对返回到前端的结果进行数据处理 例如String处理 加密处理
     * 这里对返回不是ResultVO转为ResultVO类型
     * @param data  controller接口返回的数据
     * @param methodParameter 方法名,可以获取方法的返回值类型
     * @return
     */
    @Override
    public Object beforeBodyWrite(Object data, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {

        //String类型不能直接封装到ResultVO的data属性，要做特别处理
        if (methodParameter.getGenericParameterType().equals(String.class)) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                //code和message是构造方法成功
                return objectMapper.writeValueAsString(new ResultVO<>(data));
            } catch (JsonProcessingException e) {
                throw new MyException("返回String类型错误");
            }
        }

        //可以直接封装到ResultVO的Data直接返回
        return new ResultVO<>(data);

    }
}
