package com.lambdaworks.redis.api.sync;

import java.util.List;
import com.lambdaworks.redis.TransactionResult;

/**
 * Synchronous executed commands for Transactions.
 * 
 * @param <K> Key type.
 * @param <V> Value type.
 * @author Mark Paluch
 * @since 4.0
 * @generated by com.lambdaworks.apigenerator.CreateSyncApi
 */
public interface RedisTransactionalCommands<K, V> {

    /**
     * Discard all commands issued after MULTI.
     * 
     * @return String simple-string-reply always {@code OK}.
     */
    String discard();

    /**
     * Execute all commands issued after MULTI.
     *
     * @return List&lt;Object&gt; array-reply each element being the reply to each of the commands in the atomic transaction.
     *
     *         When using {@code WATCH}, {@code EXEC} can return a
     */
    TransactionResult exec();

    /**
     * Mark the start of a transaction block.
     *
     * @return String simple-string-reply always {@code OK}.
     */
    String multi();

    /**
     * Watch the given keys to determine execution of the MULTI/EXEC block.
     *
     * @param keys the key
     * @return String simple-string-reply always {@code OK}.
     */
    String watch(K... keys);

    /**
     * Forget about all watched keys.
     *
     * @return String simple-string-reply always {@code OK}.
     */
    String unwatch();
}
