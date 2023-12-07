package com.csaraos.onepiece.dto;

import com.csaraos.onepiece.model.Nakama;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
@NoArgsConstructor
public class ResponseDto {
    private String msg;
    private Integer code;
    private Nakama nakama;
}
