package com.bmw.seed.util.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <Description>
 *
 * @author yalin.gao@shunyagroup.com
 * @version 1.0
 * @date 2020/07/29
 */
@ApiModel("基础分页对象")
public class PageReq implements Serializable {

    @NotNull(message = "page 不能为空")
    @ApiModelProperty(
            value = "page",
            example = "1"
    )
    private Integer page;
    @Range(min = 1, max = 20, message = "每页最多20条数据")
    @NotNull(message = "pageSize 不能为空")
    @ApiModelProperty(
            value = "pageSize",
            example = "10"
    )
    private Integer pageSize;


    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Data
    public static class PageReqVo extends PageReq {
        private String dcode;
    }

}
