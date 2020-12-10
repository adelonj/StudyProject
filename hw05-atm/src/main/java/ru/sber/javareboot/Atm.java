package ru.sber.javareboot;

import java.util.List;

public interface Atm {
    //todo принимать банкноты разных номиналов (на каждый номинал должна быть своя ячейка)
    void acceptMoney(List<Banknote> amount);

    //todo выдавать запрошенную сумму минимальным количеством банкнот или ошибку если сумму нельзя выдать
    List<Banknote> withdrawMoney(long amount);

    //todo выдавать сумму остатка денежных средств
    long showBalance();
}
