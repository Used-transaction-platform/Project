package com.example.ssafy_book;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.3.0.
 */
public class Escrow extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b506004805460ff191690556105258061002a6000396000f3fe6080604052600436106100b9576000357c01000000000000000000000000000000000000000000000000000000009004806362e7d2641161008157806362e7d264146101555780637150d8ae1461017f578063795612d6146101945780637f8661a11461019c578063c19d93fb146101c6578063e21f37ce146101ff576100b9565b8063078f8085146100be57806308551a53146100e55780630a7f463f146101165780633fa4f2451461012b5780634d35e4ad14610140575b600080fd5b3480156100ca57600080fd5b506100d3610289565b60408051918252519081900360200190f35b3480156100f157600080fd5b506100fa6102d3565b60408051600160a060020a039092168252519081900360200190f35b34801561012257600080fd5b506100d36102e2565b34801561013757600080fd5b506100d3610326565b34801561014c57600080fd5b506100d361032c565b34801561016157600080fd5b506100d36004803603602081101561017857600080fd5b5035610376565b34801561018b57600080fd5b506100fa6103c9565b6100d36103d8565b3480156101a857600080fd5b506100d3600480360360208110156101bf57600080fd5b5035610449565b3480156101d257600080fd5b506101db610462565b604051808260058111156101eb57fe5b60ff16815260200191505060405180910390f35b34801561020b57600080fd5b5061021461046b565b6040805160208082528351818301528351919283929083019185019080838360005b8381101561024e578181015183820152602001610236565b50505050905090810190601f16801561027b5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b6000600260045460ff16600581111561029e57fe5b146102a857600080fd5b600154600160a060020a031633146102bf57600080fd5b506004805460ff1916600390811790915590565b600154600160a060020a031681565b6000600360045460ff1660058111156102f757fe5b1461030157600080fd5b600254600160a060020a0316331461031857600080fd5b600154600160a060020a0316ff5b60005481565b6000600260045460ff16600581111561034157fe5b1461034b57600080fd5b600254600160a060020a0316331461036257600080fd5b506004805460ff1916600590811790915590565b60008060045460ff16600581111561038a57fe5b1461039457600080fd5b506001805473ffffffffffffffffffffffffffffffffffffffff1916331781556000919091556004805460ff19168217905590565b600254600160a060020a031681565b6000600160045460ff1660058111156103ed57fe5b146103f757600080fd5b506002805473ffffffffffffffffffffffffffffffffffffffff19163317815560008054600154600160a060020a0316825260056020526040909120805490910190556004805460ff19168217905590565b6000816001141561031857600254600160a060020a0316ff5b60045460ff1681565b6003805460408051602060026001851615610100026000190190941693909304601f810184900484028201840190925281815292918301828280156104f15780601f106104c6576101008083540402835291602001916104f1565b820191906000526020600020905b8154815290600101906020018083116104d457829003601f168201915b50505050508156fea165627a7a72305820bf2cd6df5ff0b31050fb0aae3c9de08e73516a382f76a2039201d84a4baff22a0029";

    public static final String FUNC_SENDITEM = "sendItem";

    public static final String FUNC_SELLER = "seller";

    public static final String FUNC_CONFIRMITEM = "confirmItem";

    public static final String FUNC_VALUE = "value";

    public static final String FUNC_SIREN = "siren";

    public static final String FUNC_REGISTERITEM = "registerItem";

    public static final String FUNC_BUYER = "buyer";

    public static final String FUNC_BUYITEM = "buyItem";

    public static final String FUNC_EXIT = "exit";

    public static final String FUNC_STATE = "state";

    public static final String FUNC_MESSAGE = "message";

    @Deprecated
    protected Escrow(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Escrow(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Escrow(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Escrow(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<TransactionReceipt> sendItem() {
        final Function function = new Function(
                FUNC_SENDITEM, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> seller() {
        final Function function = new Function(FUNC_SELLER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> confirmItem() {
        final Function function = new Function(
                FUNC_CONFIRMITEM, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> value() {
        final Function function = new Function(FUNC_VALUE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> siren() {
        final Function function = new Function(
                FUNC_SIREN, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> registerItem(BigInteger amount) {
        final Function function = new Function(
                FUNC_REGISTERITEM, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> buyer() {
        final Function function = new Function(FUNC_BUYER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> buyItem(BigInteger weiValue) {
        final Function function = new Function(
                FUNC_BUYITEM, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteCall<TransactionReceipt> exit(BigInteger result) {
        final Function function = new Function(
                FUNC_EXIT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(result)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> state() {
        final Function function = new Function(FUNC_STATE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> message() {
        final Function function = new Function(FUNC_MESSAGE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    @Deprecated
    public static Escrow load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Escrow(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Escrow load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Escrow(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Escrow load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Escrow(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Escrow load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Escrow(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Escrow> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Escrow.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<Escrow> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Escrow.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Escrow> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Escrow.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Escrow> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Escrow.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
