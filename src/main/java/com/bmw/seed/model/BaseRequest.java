package com.bmw.seed.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("基础请求")
public class BaseRequest<T> implements Serializable {
    @NotNull(message = "设备类型不能为空")
    @ApiModelProperty(
            value = "设备类型",
            example = "ios,android或h5"
    )
    private String deviceType;

    @NotNull(message = "设备编号不能为空")
    @ApiModelProperty(
            value = "设备No",
            example = "A123456bcdg67"
    )
    private String deviceNo;

    @NotNull(message = "版本号不能为空")
    @ApiModelProperty(
            value = "当前版本参数",
            example = "1.2.0"
    )
    private String version;

    @NotNull(message = "渠道号不能为空")
    @ApiModelProperty(
            value = "渠道ID",
            example = "xiaomi/huawei"
    )
    private String channelId;

    @Valid
    @ApiModelProperty("请求内容")
    private T data;
}

