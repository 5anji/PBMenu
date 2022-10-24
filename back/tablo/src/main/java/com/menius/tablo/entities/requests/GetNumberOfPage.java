package com.menius.tablo.entities.requests;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class GetNumberOfPage {
    private int pages;
    private int nrOfItems;
}
