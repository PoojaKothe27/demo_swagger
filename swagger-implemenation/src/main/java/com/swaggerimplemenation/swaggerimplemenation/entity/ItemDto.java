package com.swaggerimplemenation.swaggerimplemenation.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Item Details", description = "Item Details for perticular Item")
public class ItemDto {

	@ApiModelProperty(name = "Id", value = "Unique Item Id", dataType = "long", readOnly = true, example = "101")
	private long id;
	@ApiModelProperty(name = "itemCode", value = "Unique Item Code", dataType = "long", required = true, example = "BOOK001")
	private String itemCode;
	@ApiModelProperty(name = "ItemName", value = "Item Name", dataType = "String", required = true, example = "Microservices architecture")
	private String itemName;
	@ApiModelProperty(name = "Item Description", value = "Description of the Item", dataType = "String", example = "Microservices architecture book for building Micro-services")
	private String itemDescription;
	@ApiModelProperty(name = "Status", value = "Status of the item", dataType = "long", required = true)
	private long status;
	@ApiModelProperty(name = "Price", value = "Price of the item", dataType = "double", required = true, example = "450.40")
	private double price;

}
