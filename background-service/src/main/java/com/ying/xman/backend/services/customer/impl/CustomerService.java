package com.ying.xman.backend.services.customer.impl;

import com.ying.xman.backend.services.customer.ICustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by yingsy on 2018/3/29.
 */
@Service
public class CustomerService implements ICustomerService {

    /** logger */
    private static final Logger LOG = LoggerFactory.getLogger(CustomerService.class);

    @Override
    public String getCustomerName(String name) {
        LOG.info("---------name:"+name);
        return name;
    }
}
