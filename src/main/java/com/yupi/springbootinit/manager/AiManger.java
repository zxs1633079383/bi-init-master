package com.yupi.springbootinit.manager;


import com.yupi.springbootinit.common.ErrorCode;
import com.yupi.springbootinit.exception.BusinessException;
import com.yupi.yucongming.dev.client.YuCongMingClient;
import com.yupi.yucongming.dev.common.BaseResponse;
import com.yupi.yucongming.dev.model.DevChatRequest;
import com.yupi.yucongming.dev.model.DevChatResponse;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class AiManger {

    @Resource
    private YuCongMingClient yuCongMingClient;

    public String  doChar(Long moudleId,String message){
        // 1651472468042432513
        DevChatRequest request = new DevChatRequest();
        request.setModelId(moudleId);
        request.setMessage(message);
        BaseResponse<DevChatResponse> response = yuCongMingClient.doChat(request);
//        System.out.println(response);
        if(response.getData() == null) {
            throw  new BusinessException(ErrorCode.PARAMS_ERROR," AI系统异常");
        }
        return response.getData().getContent();
    }

}
