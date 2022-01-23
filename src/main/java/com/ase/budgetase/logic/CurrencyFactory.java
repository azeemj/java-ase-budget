package com.ase.budgetase.logic;

import com.ase.budgetase.interfaces.CurrencyInterface;

public class CurrencyFactory {

  public static CurrencyInterface createCurrency(String name) {

    if (name.equals("SL")) {
      return new Rupee();
    } else if (name.equals("US")) {
      return new USDollar();
    }

    throw new IllegalArgumentException("No such currency");
  }
}
