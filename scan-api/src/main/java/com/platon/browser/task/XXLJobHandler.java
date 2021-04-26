package com.platon.browser.task;

import com.platon.browser.bean.CommonConstant;
import com.platon.browser.utils.CommonUtil;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class XXLJobHandler {

    @XxlJob(value = "demoJobHandler", init = "init", destroy = "destroy")
    public ReturnT<String> demoJobHandler() throws Exception {
        for (int i = 0; i < 5; i++) {
            TimeUnit.SECONDS.sleep(2);
            log.error("========={}", i);
        }
        return ReturnT.SUCCESS;
    }

    @XxlJob(value = "demoJobHandler2", init = "init", destroy = "destroy")
    public ReturnT<String> demoJobHandler2() throws Exception {
        for (int i = 0; i < 5; i++) {
            TimeUnit.SECONDS.sleep(2);
            log.error("2========={}", i);
        }
        return ReturnT.SUCCESS;
    }

    @XxlJob(value = "demoJobHandler3", init = "init", destroy = "destroy")
    public ReturnT<String> demoJobHandler3() throws Exception {
        // 获取参数，最好做成json
        String test = XxlJobHelper.getJobParam();
        for (int i = 0; i < 5; i++) {
            TimeUnit.SECONDS.sleep(2);
            log.error("3========={}==========={}", i, test);
        }
        return ReturnT.SUCCESS;
    }

    public void init() {
        MDC.put(CommonConstant.TRACE_ID, CommonUtil.getTraceId());
        log.info("xxljob任务初始化");
    }

    public void destroy() {
        log.info("xxljob任务初始化销毁");
        MDC.remove(CommonConstant.TRACE_ID);
    }

}
