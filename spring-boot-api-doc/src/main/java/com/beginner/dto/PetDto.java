package com.beginner.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Benim Pet nesnem", description = "Benim Pet")
public class PetDto {

    @ApiModelProperty(value = "Pet nesnesinin tekil ID alani")
    private int id;
    @ApiModelProperty(value = "Pet nesnesinin tekil Adi alani")
    private String name;
    @ApiModelProperty(value = "Pet nesnesinin tekil Tarih alani")
    private Date date;
}
