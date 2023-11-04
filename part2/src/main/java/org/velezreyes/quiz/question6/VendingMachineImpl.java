package org.velezreyes.quiz.question6;

public class VendingMachineImpl implements VendingMachine{

  private double balance;

  public VendingMachineImpl() {
    this.balance = 0;
  }

  public static VendingMachine getInstance() {
    // Fix me!
    return new VendingMachineImpl();
  }

  @Override
  public void insertQuarter() {
    balance += 0.25;
  }

  @Override
  public Drink pressButton(String name) throws NotEnoughMoneyException, UnknownDrinkException {
    if (balance == 0) {
      throw new NotEnoughMoneyException();
    }

    switch (name) {
      case "ScottCola":
        if (balance >= 0.75) {
          balance -= 0.75;
          return new DrinkImpl("ScottCola", true);
        } else {
          throw new NotEnoughMoneyException();
        }
      case "KarenTea":
        if (balance >= 1.00) {
          balance -= 1.00;
          return new DrinkImpl("KarenTea", false);
        } else {
          throw new NotEnoughMoneyException();
        }
      default:
        throw new UnknownDrinkException();
    }
  }
}
