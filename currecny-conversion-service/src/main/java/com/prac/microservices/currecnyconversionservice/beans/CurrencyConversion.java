package com.prac.microservices.currecnyconversionservice.beans;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CurrencyConversion {
//    @Id
    private Long id;
//    @Column(name = "currency_from")
    private String from;
//    @Column(name = "currency_to")
    private String to;
    private BigDecimal quantity;
    private BigDecimal conversionMultiple;


    private BigDecimal totalAmount;
    public String environment;
}
