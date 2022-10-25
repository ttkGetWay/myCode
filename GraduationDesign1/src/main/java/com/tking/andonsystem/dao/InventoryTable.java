package com.tking.andonsystem.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryTable {
    private Long id;
    private String materialName;
    private String materialNumber;
    private String specifications;
    private String unit;
    private Long totalNumber;

}
