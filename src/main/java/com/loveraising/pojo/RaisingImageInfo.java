package com.loveraising.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RaisingImageInfo {
    private Integer id;
    private String raisingId;
    private String imageUrl;
}
