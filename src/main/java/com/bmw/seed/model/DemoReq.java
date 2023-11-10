package com.bmw.seed.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@ApiModel("demo对象")
public class DemoReq implements Serializable {
    @Data
    @ApiModel("demo新增基础对象")
    public static class BaseInfo implements Serializable {
        @NotNull(message = "text不能为空")
        @ApiModelProperty(
                value = "text",
                required = true,
                example = "demo的内容"
        )
        private String text;

        @NotNull(message = "dcode不能为空")
        @ApiModelProperty(
                value = "dcode",
                required = true,
                example = "dcode对应的码值"
        )
        private String dcode;

    }

    @Data
    @ApiModel("demo返回展示对象")
    public static class ShowBaseInfo extends BaseInfo implements Serializable {
        @ApiModelProperty(
                value = "id",
                example = "1234"
        )
        private Long id;
        @ApiModelProperty(
                value = "创建时间",
                example = "2021-10-10 12:13:24"
        )
        private String createTimeString;
    }
}
