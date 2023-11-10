package com.bmw.seed.controller;

import com.bmw.seed.model.BaseRequest;
import com.bmw.seed.model.Demo;
import com.bmw.seed.model.DemoReq;
import com.bmw.seed.service.DemoService;
import com.bmw.seed.util.bean.BaseResponse;
import com.bmw.seed.util.bean.PageReq;
import com.bmw.seed.util.bean.PageResp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.utils.DateUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping(value = "/demo")
@Api(value = "demo相关", tags = "demo相关")
@Slf4j
public class DemoController {

    @Autowired
    DemoService demoService;
    @Value("${data.showversion}")
    private String dataShowVersion;

    /**
     * 新增数据
     * @param demoData
     * @return
     */
    @PostMapping("/add")
    @ApiOperation("新增demo")
    public BaseResponse<Boolean> add(@Valid @RequestBody BaseRequest<DemoReq.BaseInfo> demoData) {
        DemoReq.BaseInfo baseInfo = demoData.getData();
        demoService.insert(baseInfo.getText(), baseInfo.getDcode());
        return BaseResponse.ok(true);
    }

    /**
     * 分页查询
     * @param reqData
     * @return
     */
    @PostMapping("/listPage")
    @ApiOperation("分页查询")
    public BaseResponse<PageResp<DemoReq.ShowBaseInfo>> list(@Valid @RequestBody BaseRequest<PageReq> reqData) {
        PageReq pageReq = reqData.getData();

        PageResp<Demo> demoPageResp = demoService.page(pageReq);
        PageResp<DemoReq.ShowBaseInfo> showPageResp = new PageResp<>();
        BeanUtils.copyProperties(demoPageResp, showPageResp);

        showPageResp.setList(new ArrayList<DemoReq.ShowBaseInfo>());

        demoPageResp.getList().stream().forEach(e -> {
            DemoReq.ShowBaseInfo showBaseInfo = new DemoReq.ShowBaseInfo();
            BeanUtils.copyProperties(e, showBaseInfo);
            //时间要做一下专门处理，因为没有名称一致的属性，Demo中只有ceateTime,但是返回的DemoReq.ShowBaseInfo里面的是createTime
            showBaseInfo.setCreateTimeString(DateUtils.formatDate(e.getCreateTime(), "yyyy-MM-dd HH:mm:SS"));
            showPageResp.getList().add(showBaseInfo);
        });
        return BaseResponse.ok(showPageResp);
    }

    /**
     * test
     * @return
     */
    @RequestMapping(value = "/test")
    public BaseResponse<String> test() {
        return BaseResponse.ok(dataShowVersion);
    }
}
