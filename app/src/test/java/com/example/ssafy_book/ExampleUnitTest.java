package com.example.ssafy_book;

import android.util.Log;

import com.google.gson.Gson;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.junit.Test;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.RawTransaction;
import org.web3j.crypto.TransactionEncoder;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.admin.methods.response.PersonalUnlockAccount;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthAccounts;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.utils.Convert;
import org.web3j.utils.Numeric;

import java.io.File;
import java.math.BigInteger;
import java.security.Provider;
import java.security.Security;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void createNewFile(){
        try {
            WalletUtils.generateLightNewWalletFile("1234", new File("./"));
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void addition_isCorrect() {
        try {
            Credentials credentials = WalletUtils.loadCredentials("1234", new File("C:/Users/YUJEONG/Desktop/CarryShare3/Ssafy_book/app/UTC--2019-08-02T14-01-42.84Z--6b9b9256df091a2fde6d52bca086771370f12dce.json"));
            System.out.println(credentials.getAddress());

            Web3j web3 = Web3j.build(new HttpService("https://ropsten.infura.io/v3/54d36833f95649589f812aaa17ea8163"));

            BigInteger amount = BigInteger.valueOf(1).multiply(BigInteger.valueOf(10).pow(17));
            RawTransaction rawTransaction  = RawTransaction.createEtherTransaction(BigInteger.ZERO, BigInteger.ONE, BigInteger.valueOf(21000), "0x352d3169979f2bc4869d8e66822eb3133cdc8278", amount);

            byte[] signedMessage = TransactionEncoder.signMessage(rawTransaction, credentials);
            String hexValue = Numeric.toHexString(signedMessage);

            System.out.println(hexValue);

            EthSendTransaction ethSendTransaction = web3.ethSendRawTransaction(hexValue).sendAsync().get();
            String transactionHash = ethSendTransaction.getTransactionHash();

            System.out.println(transactionHash);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void gethTransactionTest(){

//        String URL = "http://163.239.200.176:8545";
//        String  gethAddress = "0xf2f28e374e0b0082cea1177a43d54ec516f33e21";
//        BigInt amount = new BigInt(1);
//
//
//
//        Web3j web3 = Web3j.build(new HttpService(URL));
//
//
//        byte[] data = new byte[]{};
//        try {
//            EthereumClient   ethereumClient = Geth.newEthereumClient(URL);
//            EthAccounts ethAccount = web3.ethAccounts().sendAsync().get();
//
//
//            Context context = Geth.newContext();
//            long nonce = ethereumClient.getPendingNonceAt(context, account);
//
//            Transaction transaction = Geth.newTransaction(nonce, Geth.newAddressFromHex("0x352d3169979f2bc4869d8e66822eb3133cdc8278"), amount,Geth.newBigInt(1),Geth.newBigInt(21000), data);
//            transaction = keyStore.signTxPassphrase(account, passphrase, transaction, networkId);
//            ethereumClient.sendTransaction(context,transaction);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    @Test
    public void gethKeystoreTest(){

        final String keyStorePath = "home/selab/ssafy/b2bEth/keystore";
        final String passphras = "1234";

        String URL = "http://163.239.200.176:8545";

        try {
            Admin admin = Admin.build(new HttpService(URL));
            Web3j web3 = Web3j.build(new HttpService(URL));

            EthAccounts ethAccount = web3.ethAccounts().sendAsync().get();
            System.out.println("ethAccount" + ethAccount.toString());

            String accountArray[] = ethAccount.getAccounts().toArray(new String[0]);
            System.out.println("ethaccount : 2" + accountArray[2]);
            System.out.println("ethaccount : 1" + accountArray[1]);

            //geth에 account 생성
//            System.out.println(admin.personalNewAccount("test123456").sendAsync().get().getAccountId());

            PersonalUnlockAccount personalUnlockAccount = admin.personalUnlockAccount(accountArray[2],"test1").sendAsync().get();
            System.out.println("personalUnlockAccount : " + personalUnlockAccount.accountUnlocked());

            String message = "";

            BigInteger amount = BigInteger.valueOf(1).multiply(BigInteger.valueOf(10).pow(17));
            Transaction transaction = Transaction.createFunctionCallTransaction(accountArray[2],null,BigInteger.ONE,BigInteger.valueOf(21000),accountArray[3],amount,message);

            EthSendTransaction ethSendTransaction = web3.ethSendTransaction(transaction).sendAsync().get();
            String txId = ethSendTransaction.getTransactionHash();

            System.out.println(txId);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void smartContractTest(){

        String URL = "http://163.239.200.176:8545";
        Web3j web3 = Web3j.build(new HttpService(URL));
        Admin admin = Admin.build(new HttpService(URL));
//
        BigInteger GAS = SimpleStorage.GAS_LIMIT;
        BigInteger GAS_PRICE = SimpleStorage.GAS_PRICE;

        try {
            Credentials credentials = WalletUtils.loadCredentials("1234", new File("C:/Users/YUJEONG/Desktop/CarryShare3/Ssafy_book/app/UTC--2019-08-02T14-01-42.84Z--6b9b9256df091a2fde6d52bca086771370f12dce.json"));

            System.out.println(credentials.getAddress());
            EthGetBalance ethGetBalance = web3.ethGetBalance("0x6b9b9256df091a2fde6d52bca086771370f12dce", DefaultBlockParameterName.LATEST).sendAsync().get();
            BigInteger wei = ethGetBalance.getBalance();

            System.out.println(Convert.fromWei(wei.toString(),Convert.Unit.ETHER).toString());

//            Escrow_ssafy contractTest = Escrow_ssafy.load("0x6748604496a577559c714c5a4d6e2565d0b509e6",web3,credentials,new DefaultGasProvider());
//
//            System.out.println(contractTest.registrItem(BigInteger.valueOf(4)).sendAsync().get());
//
//            BigInteger bint = contractTest.value().sendAsync().get();
//            System.out.println("Value : " + bint);
//
//            System.out.println("GAS : " + GAS_PRICE);
//            System.out.println("GASLIMIT : " + GAS);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Test
    public void contractDeploy(){
        String URL = "http://163.239.200.176:8545";
        Web3j web3 = Web3j.build(new HttpService(URL));
        Admin admin = Admin.build(new HttpService(URL));

        try {
            Credentials credentials = WalletUtils.loadCredentials("1234", new File("C:/Users/YUJEONG/Desktop/CarryShare3/Ssafy_book/app/UTC--2019-08-02T14-01-42.84Z--6b9b9256df091a2fde6d52bca086771370f12dce.json"));

            Escrow_ssafy escrow_ssafy = Escrow_ssafy.deploy(web3,credentials,new DefaultGasProvider()).sendAsync().get();
            System.out.println("Contract Address : " +  escrow_ssafy.getContractAddress());

            System.out.println("Escrow State : " + String.valueOf(escrow_ssafy.registrItem(BigInteger.valueOf(40)).sendAsync().get()));


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Test
    //보안모듈 추가
    public void setupBouncyCastle() {
        final Provider provider = Security.getProvider(BouncyCastleProvider.PROVIDER_NAME);
        if (provider == null) {
            // Web3j will set up the provider lazily when it's first used.
            return;
        }
        if (provider.getClass().equals(BouncyCastleProvider.class)) {
            // BC with same package name, shouldn't happen in real life.
            return;
        }
        // Android registers its own BC provider. As it might be outdated and might not include
        // all needed ciphers, we substitute it with a known BC bundled in the app.
        // Android's BC has its package rewritten to "com.android.org.bouncycastle" and because
        // of that it's possible to have another BC implementation loaded in VM.
        Security.removeProvider(BouncyCastleProvider.PROVIDER_NAME);
        Security.insertProviderAt(new BouncyCastleProvider(), 1);
    }

}