package com.coinomi.core.coins;

import com.coinomi.core.coins.families.BitFamily;

/**
 * @author Apollo
 */
public class ZCoreMain extends BitFamily {
    private ZCoreMain() {
        id = "zcore.main"; // Do not change this id as wallets serialize this string

        addressHeader = 80;
        p2shHeader = 0;
        acceptableAddressCodes = new int[] { addressHeader, p2shHeader };
        spendableCoinbaseDepth = 100;
        dumpedPrivateKeyHeader = 204;

        name = "ZCore";
        symbol = "ZCR";
        uriScheme = "zcore"; // TODO add multi uri
        bip44Index = 5;
        unitExponent = 8;
        feeValue = value(100000);
        minNonDust = value(1000); // 0.00001 ZCore mininput
        softDustLimit = value(100000); // 0.001 ZCore
        softDustPolicy = SoftDustPolicy.BASE_FEE_FOR_EACH_SOFT_DUST_TXO;
        signedMessageHeader = toBytes("ZCore Signed Message:\n");
    }

    private static ZCoreMain instance = new ZCoreMain();
    public static synchronized CoinType get() {
        return instance;
    }
}
