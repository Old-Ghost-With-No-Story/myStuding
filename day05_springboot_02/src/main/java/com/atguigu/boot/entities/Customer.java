package com.atguigu.boot.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author 姽辫
 * @className Cunsummer
 * @date Create in 2022-09-15 13:53
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@ApiModel("顾客实体类")
public class Customer {
    @ApiModelProperty(value = "顾客id", hidden = true, example = "0")
    private Integer id;
    @ApiModelProperty(value = "顾客用户名")
    private String cname;
    @ApiModelProperty(value = "顾客年龄", example = "0")
    private Integer age;
    @ApiModelProperty("顾客电话号码")
    private String phone;
    @ApiModelProperty(value = "顾客性别|0:女；1:男", example = "0")
    private Byte sex;
    @ApiModelProperty(value = "顾客账号创建日期", hidden = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date birth;
}
