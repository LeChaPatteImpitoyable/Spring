package com.ying.xman.backend.api.action;

import com.ying.xman.backend.api.framework.ApiInfo;
import com.ying.xman.backend.api.request.TestActionRequest;
import com.ying.xman.backend.api.response.ApiResult;
import com.ying.xman.backend.api.response.TestActionResponse;
import com.ying.xman.backend.services.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by yingsy on 2018/3/29.
 */
@ApiInfo(name = "/action/test", version = "1.0.0")
public class TestAction extends AbstractApi<TestActionRequest, ApiResult> {

    @Autowired
    private ICustomerService customerService;

    @Override
    public ApiResult doApi(TestActionRequest req) {
        ApiResult apiResult = new ApiResult();
        apiResult.setSuccess(true);
        apiResult.setErrorCode("100");
        apiResult.setErrorMsg("OK");
        String name = customerService.getCustomerName(req.getName());
        TestActionResponse response = new TestActionResponse();
        response.setName(name);
        apiResult.setData(response);
        return apiResult;
    }
}
