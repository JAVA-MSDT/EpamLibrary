package com.epam.library.model.dto.orderservice.adminstration.search;

import com.epam.library.model.dto.orderservice.adminstration.AdministrationOrderDisplay;

public interface FindOrderIndex {

    boolean isOrderExist(AdministrationOrderDisplay orderDisplay, Object value);
}
